package com.rkumar0206.mymemailandnotificationservice.constants;

public class PasswordResetHtmlText {

    public static final String PASSWORD_RESET_EMAIL_TEXT =
            "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>ManageYourMoney - Password Reset</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #f4f4f4;\n" +
                    "            text-align: center;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        .container {\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 0 auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #fff;\n" +
                    "            border-radius: 5px;\n" +
                    "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                    "        }\n" +
                    "\n" +
                    "        h1 {\n" +
                    "            color: #333;\n" +
                    "        }\n" +
                    "\n" +
                    "        p {\n" +
                    "            color: #666;\n" +
                    "        }\n" +
                    "\n" +
                    "        .button-container {\n" +
                    "            margin: 20px 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        .button {\n" +
                    "            display: inline-block;\n" +
                    "            padding: 10px 20px;\n" +
                    "            background-color: #007BFF;\n" +
                    "            color: #fff;\n" +
                    "            text-decoration: none;\n" +
                    "            border-radius: 5px;\n" +
                    "            transition: background-color 0.3s ease;\n" +
                    "        }\n" +
                    "\n" +
                    "        .button:hover {\n" +
                    "            background-color: #0056b3;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h1>Password Reset</h1>\n" +
                    "        <p>Please click on below button to reset your password. Please note, the link is valid for only 10 minutes.</p>\n" +
                    "        <div class=\"button-container\">\n" +
                    "            <a class=\"button\" href=\"%s\">Reset Password</a>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>\n";
}
