from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
import time

def selenium_code_script4():
    messages = []
    
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    chrome_options.add_argument("--disable-infobars")
    chrome_options.add_argument("--disable-extensions")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    wait = WebDriverWait(driver, 20)
    
    try:
        try:
            driver.get('https://development.d36z6oo50ky8dh.amplifyapp.com/login')
            page_title = driver.title
            messages.append(f'Page Title: {page_title}')
            wait = WebDriverWait(driver, 90)
            username_field = wait.until(EC.visibility_of_element_located((By.ID, "username")))
            username_field.send_keys("aarushp123098@gmail.com")
            password_field = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "#password")))
            password_field.send_keys("OLOtx095")
            login_button = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[type='button']")))
            login_button.click()
            time.sleep(5)
            messages.append("Login Successful")
        except Exception as e:
            messages.append(f"Login Test Failed: {str(e)}")

        # Select project
        try:
            driver.find_element(By.XPATH, "(//div/p/button[contains(text(),'aarushCTT1AB 3')])[2]").click()
            time.sleep(6)
            messages.append("Project selected successfully")
        except Exception as e:
            messages.append(f"Project selection failed: {str(e)}")

        # Switch to iframe
        try:
            iframe = driver.find_element(By.XPATH, "(//iframe[@id='iframeD3'])[1]")
            driver.switch_to.frame(iframe)
            # Click on the info pop button and other actions
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
            
            root_node = driver.find_element(By.XPATH, "(//*[contains(text(), '40K IP GAMES')])[1]")
            ActionChains(driver).move_to_element(root_node).perform()
            messages.append("Hovered to element")

        # Switch back to default content
            driver.switch_to.default_content()
            time.sleep(2)
    
            # Maximize screen
            node_text_element11 = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[@aria-label='maximize'])[1]")))
            node_text_element11.click()
            time.sleep(2)
            
        except Exception as e:
            messages.append(f"Hover to element failed: {str(e)}")

        # Add prefix and suffix
        try:
            driver.find_element(By.XPATH, "(//span[@class='ag-header-icon ag-header-cell-menu-button'])[6]").click()
            driver.find_element(By.XPATH, "*//span[text()='Add Prefix and Suffix']").click()
            driver.find_element(By.XPATH, "//div/label[text()='Enter prefix']//following-sibling::div/input").send_keys("Test  ")
            driver.find_element(By.XPATH, "//div/label[text()='Enter suffix']//following-sibling::div/input").send_keys("application")
            driver.find_element(By.XPATH, "*//button[text()='Apply']").click()
            messages.append("Prefix and suffix applied")
        except Exception as e:
            messages.append(f"Prefix and suffix operation failed: {str(e)}")

        # Search and replace
        try:
            search_element = driver.find_element(By.XPATH, "//span[text()='K/T: ORKS CON BKLET']")
            ActionChains(driver).context_click(search_element).perform()
            driver.find_element(By.XPATH, "//div[@class='ag-menu-option']/span[text()='Search and replace']").click()
            driver.find_element(By.XPATH, "//div/label[text()='Replace Text']//following-sibling::div/input").send_keys("Test")
            driver.find_element(By.XPATH, "//span[text()='Case Sensitive']").click()
            driver.find_element(By.XPATH, "//span[text()='Match Entire Cell']").click()
            driver.find_element(By.XPATH, "//button[text()='Replace']").click()
            messages.append("Search and replace successful")
        except Exception as e:
            messages.append(f"Search and replace failed: {str(e)}")

        # Actions search and replace
        try:
            driver.find_element(By.XPATH, "*//button[@id='demo-customized-button']").click()
            driver.find_element(By.XPATH, "//ul[@role='menu' and @aria-labelledby='demo-customized-button']/li/p[text()='Search and Replace']").click()
            driver.find_element(By.XPATH, "//div/label[text()='Enter search text']//following-sibling::div/input").send_keys("Test")
            driver.find_element(By.XPATH, "//div/label[text()='Enter replace text']//following-sibling::div/input").send_keys("Updatedtest")
            driver.find_element(By.XPATH, "//span[contains(text(),'Case ')]").click()
            driver.find_element(By.XPATH, "//span[contains(text(),'Match')]").click()
            driver.find_element(By.XPATH, "//button[text()='Replace']").click()
            updated_value = driver.find_element(By.XPATH, "//button[text()='Updatedtest']").text
            messages.append(f"Actions search and replace successful: {updated_value}")
        except Exception as e:
            messages.append(f"Actions search and replace failed: {str(e)}")

    finally:
        driver.quit()
        print("\n".join(messages))

    return messages
