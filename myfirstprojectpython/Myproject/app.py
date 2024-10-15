from flask import Flask, render_template, request
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
import time

app = Flask(__name__, template_folder='Template')

@app.route('/')
def index():
    return render_template('index.html')

@app.route("/automation", methods=['GET', 'POST'])
def run_automation():
    if request.method == 'POST':
        search_key = request.form.get('search_key')
        title = selenium_code(search_key)
        return title

def selenium_code(search_key):
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)

    try:
        # Open a website
        driver.get('https://development.d36z6oo50ky8dh.amplifyapp.com/login')

        # Create a WebDriverWait object
        wait = WebDriverWait(driver, 10)

        # Capture the page title
        page_title = driver.title
        print(f'Page Title: {page_title}')

        # Find and fill the username field
        username_field = wait.until(EC.visibility_of_element_located((By.ID, "username")))
        username_field.send_keys("aarushp123098@gmail.com")

        # Find and fill the password field
        password_field = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "#password")))
        password_field.send_keys("OLOtx095")

        # Find and click the login button
        login_button = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[type='button']")))
        login_button.click()

        # Wait and capture login person's name
        wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")))
        element = driver.find_element(By.XPATH, "(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")
        display_name = element.text
        print("Login Person Name: " + display_name)
        time.sleep(4)

        # Open a specific project test
        parent = driver.find_element(By.XPATH, "//div[@id='panel1bh-header']")
        project_name = parent.find_element(By.XPATH, "(//*[contains(text(), 'aarushCTT1AB')])[2]")
        project_name.click()
        time.sleep(4)

        # Switch to iframe and interact with elements
        iframe1 = driver.find_element(By.XPATH, "(//iframe[@id='iframeD3'])[1]")
        driver.switch_to.frame(iframe1)
        time.sleep(8)
        node_text_element1 = wait.until(EC.visibility_of_element_located((By.XPATH, "(//*[contains(text(), '40K IP GAMES')])[1]")))
        node_text_element1.click()
        time.sleep(2)

        # Interact with elements inside the iframe
        driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
        time.sleep(2)
        driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
        time.sleep(2)
        driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
        time.sleep(2)

        # Move to element and perform actions
        rootnode11 = driver.find_element(By.XPATH, "(//*[contains(text(), '40K IP GAMES')])[1]")
        actions1s = ActionChains(driver)
        actions1s.move_to_element(rootnode11).perform()
        time.sleep(2)
        driver.switch_to.default_content()
        time.sleep(4)

        # Close the AG Grid
        closetab11 = wait.until(EC.element_to_be_clickable((By.XPATH, "//*[@aria-label='Save']")))
        closetab11.click()

        # Return the page title for display
        return f'Page Title: {page_title}, Login Person Name: {display_name}'

    finally:
        driver.quit()

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)








