
# from flask import Flask, render_template, request
# import importlib
# import os
#
# app = Flask(__name__, template_folder='Template')
#
# @app.route('/')
# def index():
#     return render_template('index2.html')
#
# @app.route('/automation', methods=['POST'])
# def run_automation():
#     if request.method == 'POST':
#         search_key = request.form.get('script_name')
#         if not search_key:
#             return 'No script name provided', 400
#
#         # Validate the search_key to ensure it's a safe script name
#         if not search_key.isidentifier():
#             return 'Invalid script name', 400
#
#         # Construct the module name and function name
#         module_name = f'scripts.{search_key}'
#         func_name = f'selenium_code_{search_key}'
#
#         try:
#             # Dynamically import the module
#             script_module = importlib.import_module(module_name)
#
#             # Check if the function exists and call it
#             if hasattr(script_module, func_name):
#                 func = getattr(script_module, func_name)
#                 result = func()
#             else:
#                 result = 'Function not found in script'
#
#         except ModuleNotFoundError:
#             result = 'Script not found'
#         except Exception as e:
#             result = f'An error occurred: {str(e)}'
#
#         # Returning result as plain text
#         return result
#
#     return 'Method not allowed', 405
#
# if __name__ == '__main__':
#     app.run(debug=True)

# from flask import Flask, render_template, request
# import importlib
# import os
# import sys
#
# # Handle different environments (PyInstaller bundle or normal)
# if getattr(sys, 'frozen', False) and hasattr(sys, '_MEIPASS'):
#     # If running as a PyInstaller bundle, use _MEIPASS to locate templates and static folders
#     template_dir = os.path.join(sys._MEIPASS, 'templates')
#     static_dir = os.path.join(sys._MEIPASS, 'static')
#     app = Flask(__name__, template_folder=template_dir, static_folder=static_dir)
# else:
#     # Normal environment, default template and static folder
#     app = Flask(__name__, template_folder='Template')
#
# @app.route('/')
# def index():
#     return render_template('index2.html')
#
# @app.route('/automation', methods=['POST'])
# def run_automation():
#     if request.method == 'POST':
#         search_key = request.form.get('script_name')
#         if not search_key:
#             return 'No script name provided', 400
#
#         # Validate the search_key to ensure it's a safe script name
#         if not search_key.isidentifier():
#             return 'Invalid script name', 400
#
#         # Construct the module name and function name
#         module_name = f'scripts.{search_key}'
#         func_name = f'selenium_code_{search_key}'
#
#         try:
#             # Dynamically import the module
#             script_module = importlib.import_module(module_name)
#
#             # Check if the function exists and call it
#             if hasattr(script_module, func_name):
#                 func = getattr(script_module, func_name)
#                 result = func()
#             else:
#                 result = 'Function not found in script'
#
#         except ModuleNotFoundError:
#             result = 'Script not found'
#         except Exception as e:
#             result = f'An error occurred: {str(e)}'
#
#         # Returning result as plain text
#         return result
#
#     return 'Method not allowed', 405
#
# if __name__ == '__main__':
#     # app.run(debug=True)
#      app.run(host='0.0.0.0', port=5000, debug=True)






from flask import Flask, render_template, request
import importlib
import os
import sys

# Handle different environments (PyInstaller bundle or normal)
if getattr(sys, 'frozen', False) and hasattr(sys, '_MEIPASS'):
    # If running as a PyInstaller bundle, use _MEIPASS to locate templates and static folders
    template_dir = os.path.join(sys._MEIPASS, 'templates')
    static_dir = os.path.join(sys._MEIPASS, 'static')
    app = Flask(__name__, template_folder=template_dir, static_folder=static_dir)
else:
    # Normal environment, default template and static folder
    app = Flask(__name__, template_folder='Template')

@app.route('/')
def index():
    return render_template('index2.html')

@app.route('/automation', methods=['POST'])
def run_automation():
    if request.method == 'POST':
        search_key = request.form.get('script_name')
        if not search_key:
            return 'No script name provided', 400

        # Validate the search_key to ensure it's a safe script name
        if not search_key.isidentifier():
            return 'Invalid script name', 400

        # Construct the module name and function name
        module_name = f'scripts.{search_key}'
        func_name = f'selenium_code_{search_key}'

        try:
            # Dynamically import the module
            print(f"Attempting to import module: {module_name}")  # Debug statement
            script_module = importlib.import_module(module_name)

            # Check if the function exists and call it
            if hasattr(script_module, func_name):
                func = getattr(script_module, func_name)
                print(f"Calling function: {func_name}")  # Debug statement
                result = func()
            else:
                result = 'Function not found in script'

        except ModuleNotFoundError as e:
            result = f'Script not found: {e}'
        except Exception as e:
            result = f'An error occurred: {str(e)}'

        # Returning result as plain text
        return result

    return 'Method not allowed', 405

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)




