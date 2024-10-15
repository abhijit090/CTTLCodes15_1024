from flask import Flask, request, render_template_string
import requests
from bs4 import BeautifulSoup
import urllib.parse

app = Flask(__name__)

# HTML template as a string
html_template = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Scraper</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Web Scraper</h1>
    <form method="post">
        <label for="search_value">Search:</label>
        <input type="text" id="search_value" name="search_value" required>
        <button type="submit">Search</button>
    </form>

    {% if error %}
        <p>{{ error }}</p>
    {% elif search_value %}
        <h2>Results for "{{ search_value }}"</h2>
        <h3>Chosen URL: <a href="{{ chosen_url }}" target="_blank">{{ chosen_url }}</a></h3>
        <p>{{ reason }}</p>

        <h3>Key-Value Pairs:</h3>
        <table>
            <tr>
                <th>Key</th>
                <th>Value</th>
            </tr>
            {% for key, value in key_value_pairs.items() %}
            <tr>
                <td>{{ key }}</td>
                <td>{{ value }}</td>
            </tr>
            {% endfor %}
        </table>

        <h3>Digital Assets:</h3>
        <ul>
            {% for asset in assets %}
            <li><a href="{{ asset }}" target="_blank">{{ asset }}</a></li>
            {% endfor %}
        </ul>
    {% endif %}
</body>
</html>
"""

def search_web(query):
    search_query = urllib.parse.quote(query)
    search_url = f"https://www.google.com/search?q={search_query}"
    headers = {"User-Agent": "Mozilla/5.0"}
    response = requests.get(search_url, headers=headers)
    
    if response.status_code != 200:
        print(f"Error fetching search results: {response.status_code}")
        return []
    
    soup = BeautifulSoup(response.text, 'html.parser')
    
    results = []
    for link in soup.find_all('a', href=True):
        url = link['href']
        if url.startswith('/url?q='):
            url = url.split('/url?q=')[1].split('&')[0]
            results.append(url)
    
    return results

def extract_key_value_pairs_and_assets(soup):
    key_value_pairs = {}
    asset_urls = set()
    for tag in soup.find_all(['p', 'span', 'li', 'td', 'div']):
        text = tag.get_text(strip=True)
        if ':' in text:
            key, value = map(str.strip, text.split(':', 1))
            if key and value:
                key_value_pairs[key] = value

    for tag in soup.find_all(['img', 'a']):
        if tag.name == 'img' and tag.get('src'):
            asset_urls.add(tag['src'])
        elif tag.name == 'a' and tag.get('href'):
            href = tag['href']
            if href.lower().endswith(('jpg', 'png', 'gif', 'pdf', 'svg', 'webp')):
                asset_urls.add(href)
    
    return key_value_pairs, list(asset_urls)

def evaluate_urls(urls):
    if not urls:
        return None, "No URLs found", {}, []

    best_url = None
    best_score = 0
    best_key_value_pairs = {}
    best_assets = []

    for url in urls:
        try:
            response = requests.get(url)
            soup = BeautifulSoup(response.text, 'html.parser')
            
            key_value_pairs, asset_urls = extract_key_value_pairs_and_assets(soup)
            score = len(key_value_pairs)
            
            if score > best_score:
                best_score = score
                best_url = url
                best_key_value_pairs = key_value_pairs
                best_assets = asset_urls
        except Exception as e:
            print(f"Error processing {url}: {e}")

    if best_url:
        reason = f"Selected URL based on the highest number of key-value pairs found: {best_score}"
        return best_url, reason, best_key_value_pairs, best_assets
    else:
        return None, "No suitable URLs found", {}, []

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        search_value = request.form.get('search_value')
        urls = search_web(search_value)
        chosen_url, reason, key_value_pairs, assets = evaluate_urls(urls)
        
        if chosen_url is None:
            return render_template_string(html_template, error="No suitable URLs found.")
        
        return render_template_string(html_template,
                                      search_value=search_value,
                                      chosen_url=chosen_url,
                                      reason=reason,
                                      key_value_pairs=key_value_pairs,
                                      assets=assets)
    return render_template_string(html_template)

if __name__ == '__main__':
    app.run(debug=True)