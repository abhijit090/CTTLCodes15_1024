from flask import Flask, render_template, request
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time


app = Flask(__name__, template_folder='Template')

@app.route('/')
def index():
    return render_template('index1.html')

@app.route("/automation", methods=['POST'])
def run_automation():
    if request.method == 'POST':
        search_key = request.form.get('script_name')
        try:
            if search_key == 'script1':
                result = selenium_code_script1()
            elif search_key == 'script2':
                result = selenium_code_script2()
            elif search_key == 'script3':
                result = selenium_code_script3()
            else:
                result = 'Invalid script selected'
        except Exception as e:
            result = f'An error occurred: {str(e)}'
        return result
    return 'Method not allowed'

def selenium_code_script1():
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    try:
        driver.get("https://www.facebook.com/")
        time.sleep(4)
        # Verify the page title
        title = driver.title
        return f"Page title is: {title}"
    finally:
        driver.quit()

def selenium_code_script2():
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    try:
        driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login")
        time.sleep(4)
        # Example action: Click a button
        title = driver.title
        return f"Page title is: {title}"
    finally:
        driver.quit()

def selenium_code_script3():
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    try:
        driver.get("https://www.google.com")

        # Find the search box and perform a search
        search_box = driver.find_element(By.NAME, "q")
        search_box.send_keys("Flask Selenium Test")
        search_box.submit()

        # Optionally, add a delay for demo purposes
        time.sleep(3)  # Sleep for 3 seconds

        # Return some result to Flask
        return "Selenium script executed successfully!"
    finally:
        driver.quit()

if __name__ == '__main__':
    app.run(debug=True)










