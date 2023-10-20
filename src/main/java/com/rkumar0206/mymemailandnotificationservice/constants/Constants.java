package com.rkumar0206.mymemailandnotificationservice.constants;

public class Constants {


    public static final String ACCOUNT_VERIFY_MAIL_SUBJECT = "ManageYourMoney: Verify your email-id";
    public static final String EMAIL_UPDATE_MAIL_SUBJECT = "ManageYourMoney: OTP for email update";
    public static final String ACCOUNT_VERIFY_MAIL_TEXT = "<html>\n" +
            "<head>\n" +
            "    <title>Email Verification</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <p>To verify your email, please click on the button below:</p>\n" +
            "    <a href=\"%s\">\n" +
            "        <button>Click to verify</button>\n" +
            "    </a>\n" +
            "</body>\n" +
            "</html>";

    public static final String LOG_MESSAGE_STRUCTURE = "%s: %s";  // correlation-id: message
    public static final String CORRELATION_ID = "correlation-id";
}
