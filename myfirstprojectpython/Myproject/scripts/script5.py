from flask import Flask, render_template, request
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
import pickle
import requests
from flask import Flask, jsonify


def selenium_code_script5():
    messages = []

    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    chrome_options.add_argument("--disable-infobars")
    chrome_options.add_argument("--disable-extensions")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)

    try:
        
        
    #     wait = WebDriverWait(driver, 90)
    #
    #     # Step 1: Navigate to the login page
    #     print("Navigating to the login page...")
    #     driver.get('https://development.d36z6oo50ky8dh.amplifyapp.com/login')
    #
    #     # Comment out body hiding for debugging
    #     driver.execute_script("document.body.style.display = 'none';")
    #
    #     # Step 3: Enter username and password
    #     username = 'aarushp123098@gmail.com'
    #     password = 'OLOtx095'
    #
    #     print("Attempting to find the username field...")
    #     username_field = wait.until(EC.visibility_of_element_located((By.ID, "username")))
    #     username_field.send_keys(username)
    #
    #     print("Attempting to find the password field...")
    #     password_input = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "#password")))
    #     password_input.send_keys(password)
    #
    #     # Step 4: Click the login button
    #     print("Attempting to click the login button...")
    #     login_button = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[type='button']")))
    #     login_button.click()
    #
    #     # Step 5: Wait for the page to load and check for the system display type
    #     time.sleep(3)  # Wait for a few seconds for the login to complete
    #     messages.append("Login Successful")
    #
    #     # Optional sleep - you can replace this with a more robust wait if needed
    #     time.sleep(40)
    #
    #     # Test 2: Verify login person's name
    #     try:
    #         print("Verifying the login person's name...")
    #         wait = WebDriverWait(driver, 50)
    #         element = wait.until(EC.visibility_of_element_located(
    #             (By.XPATH, "(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")))
    #
    #         display_name = element.text
    #         messages.append(f"Login Person Name: {display_name}")
    #
    #     except Exception as e:
    #         messages.append(f"Person Name Verification Failed: {str(e)}")
    #         driver.save_screenshot('error_screenshot.png')  # Save a screenshot for debugging
    #         with open('error_page_source.html', 'w') as f:
    #             f.write(driver.page_source)  # Save the page source for inspection
    #
    # except Exception as e:
    #     messages.append(f"Login Test Failed: {str(e)}")
    #     driver.save_screenshot('error_screenshot.png')  # Save a screenshot for debugging
    #     with open('error_page_source.html', 'w') as f:
    #         f.write(driver.page_source)  # Save the page source for inspection
    #
    # finally:
    #     driver.quit()
    #
    # return messages
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    #     # Send request to get authentication token
        response = requests.post(
            
            'https://development.d36z6oo50ky8dh.amplifyapp.com/login',
            data={
                'username': 'aarushp123098@gmail.com',
                'password': 'OLOtx095'
            },
            headers={'Content-Type': 'application/x-www-form-urlencoded'}
        )
    
    #     # Print response for debugging
    
        print("Response Status Code:", response.status_code)
        print("Abhijit",response)
        print("Response Content:", response.content.decode('utf-8'))  # Decode bytes for better readability
    
        if response.status_code != 200:
            print("Error: Received status code", response.status_code)
            return jsonify({"error": "Invalid status code", "status_code": response.status_code}), response.status_code
    
    #     # Check Content-Type for JSON response
        if 'application/json' not in response.headers.get('Content-Type', ''):
            print("Error: Response is not JSON", response.content)
            return jsonify({"error": "Response is not JSON", "response": response.content.decode('utf-8')}), 500
    
    #     # Attempt to parse the token from the response
        try:
            response_data = response.json()  # Parse JSON
            token = response_data.get('token')  # Safely get 'token'
            if not token:
                print("Error: Token not found in response", response_data)  # Log missing token
                return jsonify({"error": "Token parsing failed", "response": response_data}), 400
        except ValueError:
            print("Error: Invalid JSON response", response.content)
            return jsonify({"error": "Invalid JSON response", "response": response.content.decode('utf-8')}), 500
    
    #     # Use the token to set the cookie and navigate
        driver.get('https://development.d36z6oo50ky8dh.amplifyapp.com/project')
        driver.add_cookie({
            'name': 'auth_token',
            'value': token,
            'path': '/'
        })
        driver.refresh()
    
    #     # Return a success response
        return jsonify({"message": "Automation script executed successfully!"}), 200
    
    except Exception as e:
        print("An error occurred:", e)
        return jsonify({"error": str(e)}), 500
    finally:
        driver.quit()
    
    return messages  # Provide error details in response
    

        
#         # Step 1: Log in and save cookies
#         driver.get('https://development.d36z6oo50ky8dh.amplifyapp.com/login')
#
#         # Wait for the username and password fields
#         wait = WebDriverWait(driver, 90)
#         username_field = wait.until(EC.visibility_of_element_located((By.ID, "username")))
#         username_field.send_keys("aarushp123098@gmail.com")
#         password_field = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "#password")))
#         password_field.send_keys("OLOtx095")
#
#         # Click login button
#         login_button = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[type='button']")))
#         login_button.click()
#
#         # Wait for the login to complete (adjust time if necessary)
#         time.sleep(5)
#
#         # Save cookies to a file
#         cookies = driver.get_cookies()
#         with open("cookies.pkl", "wb") as file:
#             pickle.dump(cookies, file)
#
#         # Confirm login
#         print("Logged in. Page Title:", driver.title)
#
#     finally:
#         driver.quit()
#
#
# # Function to bypass login using saved cookies
# # def selenium_code_script5():
#     chrome_options = Options()
    # chrome_options.add_argument("--start-maximized")
    # chrome_options.add_argument("--disable-infobars")
    # chrome_options.add_argument("--disable-extensions")
    # service = Service(ChromeDriverManager().install())
    # driver = webdriver.Chrome(service=service, options=chrome_options)
    #
    # try:
    #     # Step 2: Skip login using saved cookies
    #     driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com")
    #
    #     # Load cookies from the file
    #     with open("cookies.pkl", "rb") as file:
    #         cookies = pickle.load(file)
    #
    #     # Add cookies to the browser session
    #     for cookie in cookies:
    #         cookie.pop('expiry', None)  # Remove 'expiry' to avoid issues
    #         driver.add_cookie(cookie)
    #
    #     # Now navigate to the desired page after adding cookies
    #     driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/project")
    #
    #     # Wait for the page to load
    #     time.sleep(5)
    #
    #     # Confirm bypass login
    #     print("Bypassed login. Page Title:", driver.title)
    #     try:
    #         wait = WebDriverWait(driver, 50)
    #         element = wait.until(EC.visibility_of_element_located(
    #             (By.XPATH, "(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")))
    #         display_name = element.text
    #         messages.append(f"Login Person Name: {display_name}")
    #     except Exception as e:
    #         messages.append(f"Person Name Verification Failed: {str(e)}")
    #         time.sleep(50)
    # finally:
    #     driver.quit()
    #
    # return messages
