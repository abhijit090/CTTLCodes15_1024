from flask import Flask, render_template, request
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
import time
import pickle



def selenium_code_script1():
    messages = []
    
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    chrome_options.add_argument("--disable-infobars")
    chrome_options.add_argument("--disable-extensions")
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    
    try:
        
        
        # # Test 1: Login and enter details
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
        
        # Test 2: Verify login person name
        try:
            wait = WebDriverWait(driver, 50)
            element = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")))
            display_name = element.text
            messages.append(f"Login Person Name: {display_name}")
        except Exception as e:
            messages.append(f"Person Name Verification Failed: {str(e)}")

        # test_open_specific_project():
        try:
            wait = WebDriverWait(driver, 90)
    
            # Open specific project
            element11 = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[contains(text(),'NewProjectTset')])[2]")))
            element11.click()
            time.sleep(8)
    
            # Switch to iframe
            iframe1z1 = driver.find_element(By.XPATH, "(//iframe[@id='iframeD3'])[1]")
            driver.switch_to.frame(iframe1z1)
            time.sleep(8)
    
            # Click on node text
            node_text_element1 = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[contains(text(), 'Controls & Electrical Components')]")))
            time.sleep(4)
            node_text_element1.click()
            time.sleep(2)
    
            # Click on the info pop button and other actions
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
            driver.find_element(By.XPATH, "//*[@id='infoPop']").click()
            time.sleep(1)
    
            # Click on the node
            rootnode11 = driver.find_element(By.XPATH, "(//*[contains(text(),'Batteries')])[1]")
            actions1s = ActionChains(driver)
            actions1s.move_to_element(rootnode11).perform()
            time.sleep(1)
            driver.switch_to.default_content()
            time.sleep(2)
    
            # Maximize screen
            node_text_element11 = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[@aria-label='maximize'])[1]")))
            node_text_element11.click()
            time.sleep(2)

            messages.append("Opened specific project and performed actions successfully.")
        except Exception as e:
            messages.append(f"Failed to open specific project: {str(e)}")

        # test_verify_data_not_available_in_awr_database():
        try:
            wait = WebDriverWait(driver, 50)
    
            # Right-click on cell
            tralaing1 = driver.find_element(By.XPATH, "(//div[@role='gridcell'][normalize-space()='M140025'])[1]")
            actions1q1 = ActionChains(driver)
            actions1q1.context_click(tralaing1).perform()
            time.sleep(1)
    
            # Click on SKU Search
            abc1 = driver.find_element(By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")
            abc1.click()
            time.sleep(2)
    
            # Select Attributes screen
            select_attributes_header = wait.until(EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]")))
    
            # Check if the "Select Attributes" screen is displayed
            if select_attributes_header.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
            time.sleep(1)
    
            # Click on DB Search
            awr_search_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//span[normalize-space()='DB Search'])[1]")))
            awr_search_button.click()
    
            # Attribute select
            driver.find_element(By.XPATH, "(//button[@title='Open'])[1]").click()
            time.sleep(2)
    
            # Select attribute
            select_atta = wait.until(EC.element_to_be_clickable((By.XPATH, "//ul/li[contains(text(), 'PROD NO')]")))
            select_atta.click()
            time.sleep(2)
    
            # Enter value
            abcd1 = driver.find_element(By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")
            actions1qt1 = ActionChains(driver)
            actions1qt1.move_to_element(abcd1).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            abcd1.send_keys("Testabcd143")
            time.sleep(2)
    
            # Click on search
            driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]").click()
            time.sleep(2)
    
            # Wait for the success message
            success_message11 = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            text11 = success_message11.text
            messages.append(f"Search completed successfully: {text11}")
            time.sleep(3)
    
            # Click on cancel
            driver.find_element(By.XPATH, "(//button[normalize-space()='Cancel'])[1]").click()
            time.sleep(2)

        except Exception as e:
            messages.append(f"Failed to verify data not available in database: {str(e)}")

            # Return the page title for display
            
            # Select a cell and right-click
        try:
            # Select a cell and right-click
            tralaing1 = driver.find_element(By.XPATH, "(//div[@role='gridcell'][normalize-space()='M140025'])[1]")
            actions = ActionChains(driver)
            actions.context_click(tralaing1).perform()
            time.sleep(1)
        
            # Single SKU search
            sku_search = driver.find_element(By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")
            sku_search.click()
            time.sleep(2)
        
            # Wait for 'Select Attributes' screen to appear
            select_attributes_header = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]")))
        
            if select_attributes_header.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
        
            # Select DB Search
            db_search_button = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "(//span[normalize-space()='DB Search'])[1]")))
            db_search_button.click()
        
            # Open Attribute Selection
            driver.find_element(By.XPATH, "(//button[@title='Open'])[1]").click()
            time.sleep(2)
        
            # Select attribute
            select_att = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "//ul//li[contains(text(), 'PROD NO')]")))
            select_att.click()
            time.sleep(2)
        
            # Enter value
            abcd = driver.find_element(By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")
            actions.move_to_element(abcd).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            abcd.send_keys("SNT200CL")
            time.sleep(2)
        
            # Click on search
            driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]").click()
            time.sleep(2)
        
            # Capture and print popup message
            success_message = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(success_message.text)
            time.sleep(3)
        
            # Select a checkbox
            checkbox = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")))
            checkbox.click()
            time.sleep(2)
        
            # Click on the 'Next' button
            next_button = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "(//button[normalize-space()='Next'])[1]")))
            next_button.click()
            time.sleep(2)
        
            # Wait for 'Attribute List' screen
            attribute_list_screen = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//h2[normalize-space()='Attribute List'])[1]")))
        
            if attribute_list_screen.is_displayed():
                messages.append("Attribute List screen is open.")
            else:
                messages.append("Attribute List screen is NOT open.")
            time.sleep(2)
        
            # Continue with double click, dropdown selections, and saving the changes
            # Double-click example:
            cell = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "((//*[contains(text(),'Body_Color')])[1]//parent::div//parent::div//following-sibling::div)[3]")))
            cell.click()
            time.sleep(2)
        
            dbclick = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'Body_Color')])[1]//parent::div//parent::div//following-sibling::div)[5]")))
            actions.double_click(dbclick).perform()
            time.sleep(1)
        
            # Interact with dropdown
            dropdown = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")))
            dropdown.click()
            time.sleep(2)
        
            # Select an attribute from the dropdown
            select_att = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "(//ul//li[contains(text(), 'Quantity')])[1]")))
            select_att.click()
            time.sleep(2)
        
            # Save the selections and capture final success messages
            driver.find_element(By.XPATH, "(//button[normalize-space()='Save'])[1]").click()
            time.sleep(3)
        
            # Scroll to view the last column and verify 'Collected Description'
            scroll_element = driver.find_element(By.XPATH, "(//div[@class='ag-body-horizontal-scroll-viewport'])[1]")
            driver.execute_script("arguments[0].scrollLeft = arguments[0].scrollWidth", scroll_element)
            time.sleep(2)
        
            # Verify column visibility
            column_header = driver.find_element(By.XPATH, "(//*[@class='ag-header-cell-resize'])[4]")
            driver.execute_script("arguments[0].scrollIntoView(true);", column_header)
            time.sleep(2)
        
            if column_header.is_displayed():
                messages.append("The 'Collected Description' column is now visible.")
            else:
                messages.append("The 'Collected Description' column is NOT visible.")
        
        except Exception as e:
            messages.append(f"Error occurred: {str(e)}")   
            
            
            #Through_the_database_Update

        try:
            # Select any one cell and Right click
            tralaing1 = driver.find_element(By.XPATH, "(//div[@role='gridcell'][normalize-space()='M140025'])[1]")
            ActionChains(driver).context_click(tralaing1).perform()
            time.sleep(1)
        
            # SKU search
            sku_search = driver.find_element(By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")
            sku_search.click()
            time.sleep(2)
        
            # Verify "Select Attributes" screen
            select_attributes_header = wait.until(
                EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]"))
            )
            if select_attributes_header.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
        
            # Select DB search
            db_search_button = wait.until(
                EC.element_to_be_clickable((By.XPATH, "(//span[normalize-space()='DB Search'])[1]"))
            )
            db_search_button.click()
        
            # Open attribute selection
            driver.find_element(By.XPATH, "(//button[@title='Open'])[1]").click()
            time.sleep(2)
        
            # Select PROD NO attribute
            prod_no = wait.until(EC.element_to_be_clickable((By.XPATH, "//ul//li[contains(text(), 'PROD NO')]")))
            prod_no.click()
            time.sleep(2)
        
            # Enter value and search
            input_field = driver.find_element(By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")
            ActionChains(driver).move_to_element(input_field).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            input_field.send_keys("SNT200CL")
            time.sleep(2)
        
            # Click on search
            driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]").click()
            time.sleep(2)
        
            # Capture success message
            success_message = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(success_message.text)
        
            # Select checkbox
            checkbox = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")
            ))
            checkbox.click()
            time.sleep(2)
        
            # Click 'Next' button
            next_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[normalize-space()='Next'])[1]")))
            next_button.click()
            time.sleep(2)
        
            # Verify 'Attribute List' screen
            attribute_list_screen = wait.until(EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Attribute List'])[1]")))
            if attribute_list_screen.is_displayed():
                messages.append("Attribute List screen is open.")
            else:
                messages.append("Attribute List screen is NOT open.")
            time.sleep(2)
        
            # Select and double-click on cells, perform attribute mapping
            first_cell = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[3]")
            ))
            first_cell.click()
            time.sleep(2)
            
            dbclick_cell = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[5]")
            ))
            ActionChains(driver).double_click(dbclick_cell).perform()
            time.sleep(1)
        
            dropdown = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")
            ))
            dropdown.click()
            time.sleep(2)
        
            # Select attribute
            select_attr = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "(//ul//li[contains(text(), 'Quantity')])[1]")
            ))
            select_attr.click()
            time.sleep(2)
        
            # Repeat steps for the second cell
            second_cell = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[3]")
            ))
            second_cell.click()
            time.sleep(2)
            
            dbclick_cell2 = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[5]")
            ))
            ActionChains(driver).double_click(dbclick_cell2).perform()
            time.sleep(1)
        
            dropdown2 = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")
            ))
            dropdown2.click()
            time.sleep(2)
        
            select_attr2 = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "(//ul//li[contains(text(), 'Short Description => Collected Description')])[1]")
            ))
            select_attr2.click()
            time.sleep(2)
        
            # Save the changes
            driver.find_element(By.XPATH, "(//button[normalize-space()='Save'])[1]").click()
            time.sleep(3)
        
            # Scroll to the end and save again
            scroll_element = driver.find_element(By.XPATH, "(//div[@class='ag-body-horizontal-scroll-viewport'])[1]")
            driver.execute_script("arguments[0].scrollLeft = arguments[0].scrollWidth", scroll_element)
            time.sleep(2)
        
            save_button = driver.find_element(By.XPATH, "(//button[@aria-label='save'])[1]")
            driver.execute_script("arguments[0].click();", save_button)
        
            success_message_final = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(success_message_final.text)
        
            # Verify the 'Collected Description' column
            collected_desc_column = driver.find_element(By.XPATH, "(//*[@class='ag-header-cell-resize'])[4]")
            driver.execute_script("arguments[0].scrollIntoView(true);", collected_desc_column)
            time.sleep(2)
        
            if collected_desc_column.is_displayed():
                messages.append("The 'Collected Description' column is now visible.")
            else:
                messages.append("The 'Collected Description' column is NOT visible.")

        except Exception as e:
                messages.append(f"Test failed: {str(e)}")
    
        
        #Verify through AI Mapping
        try:
            # Select any one cell and right-click
            cell = driver.find_element(By.XPATH, "(//div[@role='gridcell'][normalize-space()='M140025'])[1]")
            actions = ActionChains(driver)
            actions.context_click(cell).perform()
            time.sleep(1)
    
            # Click SKU Search
            sku_search = driver.find_element(By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")
            sku_search.click()
            time.sleep(2)
    
            # Wait for "Select Attributes" screen
            select_attributes_header = wait.until(EC.visibility_of_element_located(
                (By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]")))
            
            if select_attributes_header.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
            
            # Click DB Search
            db_search = wait.until(EC.element_to_be_clickable((By.XPATH, "(//span[normalize-space()='DB Search'])[1]")))
            db_search.click()
    
            # Open attribute selection
            driver.find_element(By.XPATH, "(//button[@title='Open'])[1]").click()
            time.sleep(2)
    
            # Select attribute
            select_att = wait.until(EC.element_to_be_clickable(By.XPATH, "//ul//li[contains(text(), 'PROD NO')]"))
            select_att.click()
            time.sleep(2)
    
            # Enter value
            input_field = driver.find_element(By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")
            actions.move_to_element(input_field).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            input_field.send_keys("SNT200CL")
            time.sleep(2)
    
            # Click search
            driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]").click()
            time.sleep(2)
    
            # Capture pop-up message
            success_message = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(success_message.text)
            time.sleep(3)
    
            # Select checkbox
            checkbox = wait.until(EC.element_to_be_clickable(
                (By.XPATH, "((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")))
            checkbox.click()
            time.sleep(2)
    
            # Click Next
            next_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[normalize-space()='Next'])[1]")))
            next_button.click()
            time.sleep(2)
    
            # Wait for Attribute List screen
            attribute_list_header = wait.until(EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Attribute List'])[1]")))
            
            if attribute_list_header.is_displayed():
                messages.append("Attribute List screen is open.")
            else:
                messages.append("Attribute List screen is NOT open.")
            
            time.sleep(2)
    
            # Select and double-click cell for mapping
            select_cell = wait.until(EC.visibility_of_element_located(By.XPATH, 
                "((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[3]"))
            select_cell.click()
            time.sleep(2)
            
            double_click_cell = wait.until(EC.element_to_be_clickable(By.XPATH, 
                "((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[5]"))
            actions.double_click(double_click_cell).perform()
            time.sleep(1)
    
            # Click dropdown and select attribute
            dropdown = wait.until(EC.visibility_of_element_located((By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")))
            dropdown.click()
            time.sleep(2)
            
            select_attribute = wait.until(EC.element_to_be_clickable(By.XPATH, "(//ul//li[contains(text(), 'Product Type')])[1]"))
            select_attribute.click()
            time.sleep(2)
    
            # AI Mapping process
            ai_mapping_button = wait.until(EC.element_to_be_clickable(By.XPATH, "(//button[normalize-space()='AI MAPPING'])[1]"))
            ai_mapping_button.click()
            time.sleep(2)
    
            # Capture AI Mapping success message
            ai_mapping_success = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(),'Mapping fetched successfully')][1]")))
            messages.append(ai_mapping_success.text)
            time.sleep(2)
    
            # Click Save and finalize
            save_button = driver.find_element(By.XPATH, "(//button[normalize-space()='Save'])[1]")
            save_button.click()
            time.sleep(3)
    
            # Final success message
            final_success_message = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(final_success_message.text)

        except Exception as e:
            messages.append(f"AI Mapping Verification Failed: {str(e)}")
            
         #Verify through AWR   
        try:
            wait = WebDriverWait(driver, 50)
            time.sleep(1)
        
            # Switch to iframe
            iframe = wait.until(EC.presence_of_element_located((By.XPATH, "(//iframe[@id='iframeD3'])[1]")))
            driver.switch_to.frame(iframe)
            time.sleep(2)
        
            # Wait for Batteries text
            rootnode11e = wait.until(EC.visibility_of_element_located((By.XPATH, "(//*[contains(text(),'Batteries')])[1]")))
            actions = ActionChains(driver)
            actions.move_to_element(rootnode11e).perform()
            time.sleep(2)
            
            # Switch back to main content
            driver.switch_to.default_content()
            time.sleep(2)
        
            # Maximize screen
            nodeTextElement11 = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[@aria-label='maximize'])[1]")))
            nodeTextElement11.click()
            time.sleep(2)
        
            # Right-click on a cell
            tralaing1 = driver.find_element(By.XPATH, "(//div[@role='gridcell'][normalize-space()='VS10066'])[1]")
            actions.context_click(tralaing1).perform()
            time.sleep(1)
        
            # SKU Search
            abc1 = driver.find_element(By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")
            abc1.click()
            time.sleep(2)
        
            # Verify 'Select Attributes' screen
            selectAttributesHeader = wait.until(EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]")))
            if selectAttributesHeader.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
            time.sleep(1)
        
            # Select AWR Search
            inputElement = wait.until(EC.element_to_be_clickable((By.XPATH, "(//span[normalize-space()='AWR Search'])[1]")))
            inputElement.click()
            time.sleep(1)
        
            # Attribute selection
            driver.find_element(By.XPATH, "(//button[@title='Open'])[1]").click()
            time.sleep(2)
        
            selectATT = wait.until(EC.element_to_be_clickable((By.XPATH, "//ul/li[contains(text(), 'Brand')]")))
            selectATT.click()
            time.sleep(2)
        
            # Enter value
            abcd = wait.until(EC.element_to_be_clickable((By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")))
            actions.move_to_element(abcd).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            abcd.send_keys("Lifts")
            time.sleep(2)
        
            # Click on search
            driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]").click()
            time.sleep(2)
        
            # Capture success message
            successMessage146 = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(successMessage146.text)
            time.sleep(3)
        
            # Further success message capture
            successMessage1461 = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(),'URLs Fetched Succesfully')][1]")))
            messages.append(successMessage1461.text)
            time.sleep(3)
        
            # Select radio button and extract attributes
            radioButton = driver.find_element(By.XPATH, "(//input[@type='radio'])[5]")
            driver.execute_script("arguments[0].click();", radioButton)
            time.sleep(2)
        
            # Extract attributes
            driver.find_element(By.XPATH, "(//button[normalize-space()='Extract Attributes'])[1]").click()
            time.sleep(2)
        
            # Capture success message
            successMessage = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(successMessage.text)
            time.sleep(3)
        
            # Mapping success message
            successMessage121 = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(),'Mapping fetched successfully')][1]")))
            messages.append(successMessage121.text)
            time.sleep(3)
        
            # AI Mapping
            aimapping = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[normalize-space()='AI MAPPING'])[1]")))
            aimapping.click()
            time.sleep(2)
        
            # Verify AI Mapping message
            successMessage12 = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(successMessage12.text)
            time.sleep(3)
        
            # Final mapping fetched
            # wait = WebDriverWait(driver, 10)

            # Wait until the element with the specific text is visible
            success_message1 = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(),'Mapping fetched successfully')][1]")))
            # Get the text of the element
            text = success_message1.text
            print(text)
            messages.append(success_message1.text)
            time.sleep(3)
        
            # Select and double-click cell
            driver.find_element(By.XPATH, "((//*[contains(text(),'LIFTS')])[2]//parent::div//parent::div)[5]").click()
            time.sleep(2)
        
            dbclick = wait.until(EC.element_to_be_clickable((By.XPATH, "(//*[contains(text(),'LIFTS')])[2]//parent::div/div[3]")))
            actions.double_click(dbclick).perform()
            time.sleep(1)
        
            # Select dropdown attribute
            dropdown = wait.until(EC.visibility_of_element_located((By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[14]")))
            dropdown.click()
            time.sleep(2)
        
            selectATT1 = wait.until(EC.element_to_be_clickable((By.XPATH, "(//ul//li[contains(text(), 'Product Type')])[1]")))
            selectATT1.click()
            time.sleep(2)
        
            # Click on save button
            driver.find_element(By.XPATH, "(//button[normalize-space()='Save'])[1]").click()
            time.sleep(3)
        
            # Scroll to the right and click the main save button
            element123 = driver.find_element(By.XPATH, "(//div[@class='ag-body-horizontal-scroll-viewport'])[1]")
            driver.execute_script("arguments[0].scrollLeft = arguments[0].scrollWidth", element123)
            time.sleep(2)
        
            element1 = driver.find_element(By.XPATH, "(//button[@aria-label='save'])[1]")
            driver.execute_script("arguments[0].click();", element1)
        
        except Exception as e:
            messages.append(f"An error occurred: {str(e)}")
        
        # AWR update DAta
        try:
            wait = WebDriverWait(driver, 50)
            time.sleep(2)
        # Switch to iframe
            iframe = wait.until(EC.presence_of_element_located((By.XPATH, "(//iframe[@id='iframeD3'])[1]")))
            driver.switch_to.frame(iframe)
            time.sleep(3)
        
            # Mouse over the node
            rootnode = wait.until(EC.presence_of_element_located((By.XPATH, "(//*[contains(text(),'Batteries')])[1]")))
            ActionChains(driver).move_to_element(rootnode).perform()
            time.sleep(1)
        
            # Switch back to default content and maximize the screen
            driver.switch_to.default_content()
            time.sleep(2)
            maximize_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[@aria-label='maximize'])[1]")))
            maximize_button.click()
            time.sleep(2)
        
            # Right-click and select 'SKU Search'
            grid_cell = wait.until(EC.presence_of_element_located((By.XPATH, "(//div[@role='gridcell'][normalize-space()='VS10066'])[1]")))
            ActionChains(driver).context_click(grid_cell).perform()
            time.sleep(1)
            sku_search = wait.until(EC.presence_of_element_located((By.XPATH, "(//span[normalize-space()='SKU Search'])[1]")))
            sku_search.click()
            time.sleep(2)
        
            # Verify 'Select Attributes' screen is displayed
            select_attributes_header = wait.until(EC.visibility_of_element_located((By.XPATH, "(//h2[normalize-space()='Select Attributes'])[1]")))
            if select_attributes_header.is_displayed():
                messages.append("The 'Select Attributes' screen is open.")
            else:
                messages.append("The 'Select Attributes' screen is NOT open.")
            time.sleep(1)
        
            # Select AWR Search option
            awr_search = wait.until(EC.element_to_be_clickable((By.XPATH, "(//span[normalize-space()='AWR Search'])[1]")))
            awr_search.click()
            time.sleep(1)
        
            # Select 'Open' attribute
            open_button = driver.find_element(By.XPATH, "(//button[@title='Open'])[1]")
            open_button.click()
            time.sleep(2)
            brand_option = wait.until(EC.element_to_be_clickable((By.XPATH, "//ul/li[contains(text(), 'Brand')]")))
            brand_option.click()
            time.sleep(2)
        
            # Enter value for 'Lifts'
            input_field = wait.until(EC.element_to_be_clickable((By.XPATH, "(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")))
            ActionChains(driver).move_to_element(input_field).click().key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).send_keys(Keys.DELETE).perform()
            time.sleep(2)
            input_field.send_keys("Lifts")
            time.sleep(2)
        
            # Click on search button
            search_button = driver.find_element(By.XPATH, "(//button[normalize-space()='search'])[1]")
            search_button.click()
            time.sleep(2)
        
            # Print pop-up message
            success_message = wait.until(EC.visibility_of_element_located((By.XPATH, "(//div[@role='alert'])[1]")))
            messages.append(success_message.text)
            time.sleep(3)
        
            # Click on Extract Attributes
            radio_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//input[@type='radio'])[5]")))
            driver.execute_script("arguments[0].click();", radio_button)
            time.sleep(2)
            extract_button = driver.find_element(By.XPATH, "(//button[normalize-space()='Extract Attributes'])[1]")
            extract_button.click()
            time.sleep(2)
        
            # Print second success message
            success_message_2 = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(),'Attributes Fetched Successfully')][1]")))
            messages.append(success_message_2.text)
            time.sleep(3)
            
            
        # Select and double-click cell
            driver.find_element(By.XPATH, "((//*[contains(text(),'Service Name')])[1]//parent::div//parent::div//following-sibling::div)[3] ))").click()
            time.sleep(2)
        
            # Double click on cell to edit
            cell_to_edit = wait.until(EC.element_to_be_clickable((By.XPATH, "((//*[contains(text(),'Service Name')])[1]//parent::div//parent::div//following-sibling::div)[5]")))
            ActionChains(driver).double_click(cell_to_edit).perform()
            time.sleep(1)
        
            # Select 'Product Brand => Brand' from dropdown
            dropdown = wait.until(EC.element_to_be_clickable((By.XPATH, "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[14]")))
            dropdown.click()
            time.sleep(2)
            product_brand = wait.until(EC.element_to_be_clickable((By.XPATH, "(//ul//li[contains(text(), 'Product Brand => Brand')])[1]")))
            product_brand.click()
            time.sleep(2)
        
            # Click on save button
            save_button = driver.find_element(By.XPATH, "(//button[normalize-space()='Save'])[1]")
            save_button.click()
            time.sleep(3)
        
            # Scroll to the end of the page
            scroll_view = driver.find_element(By.XPATH, "(//div[@class='ag-body-horizontal-scroll-viewport'])[1]")
            driver.execute_script("arguments[0].scrollLeft = arguments[0].scrollWidth", scroll_view)
            time.sleep(2)
        
            # Final save
            final_save_button = wait.until(EC.element_to_be_clickable((By.XPATH, "(//button[@aria-label='save'])[1]")))
            final_save_button.click()
            time.sleep(3)
        
            # Navigate to home
            home_button = driver.find_element(By.XPATH, "//button[normalize-space()='Home'][1]")
            driver.execute_script("arguments[0].click();", home_button)
            time.sleep(1)
    
        except Exception as e:
            messages.append(f"Test case failed: {str(e)}")


        
    finally:
        driver.quit()

    return messages
