package com.rkumar0206.mymemailandnotificationservice.services;

import com.rkumar0206.mymemailandnotificationservice.config.ConnectionConfig;
import com.rkumar0206.mymemailandnotificationservice.config.EmailConfig;
import com.rkumar0206.mymemailandnotificationservice.constants.Constants;
import com.rkumar0206.mymemailandnotificationservice.constants.EmailUpdateOTPHtmlText;
import com.rkumar0206.mymemailandnotificationservice.constants.EmailVerificationHtmlText;
import com.rkumar0206.mymemailandnotificationservice.constants.PasswordResetHtmlText;
import com.rkumar0206.mymemailandnotificationservice.models.ConfirmationToken;
import com.rkumar0206.mymemailandnotificationservice.models.EmailUpdateOTP;
import com.rkumar0206.mymemailandnotificationservice.models.PasswordReset;
import com.rkumar0206.mymemailandnotificationservice.utility.MymUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailConfig emailConfig;
    private final ConnectionConfig connectionConfig;
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(EmailConfig emailConfig, ConnectionConfig connectionConfig, JavaMailSender javaMailSender) {
        this.emailConfig = emailConfig;
        this.connectionConfig = connectionConfig;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void handleConfirmationTokenMessage(ConfirmationToken confirmationToken, String correlation_id) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        String confirmationUrl = connectionConfig.getAppHostUrl() + connectionConfig.getPort() + "/mym/api/users/account/verify?token=" + confirmationToken.getConfirmationToken();

        try {

            mimeMessageHelper.setTo(confirmationToken.getEmailId());
            mimeMessageHelper.setSubject(Constants.ACCOUNT_VERIFY_MAIL_SUBJECT);
            mimeMessageHelper.setFrom(emailConfig.getUsername());
            mimeMessageHelper.setText(String.format(EmailVerificationHtmlText.EMAIL_VERIFICATION_HTML_TEXT, confirmationUrl), true);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        sendMail(mimeMessage, correlation_id);
    }

    @Override
    public void handleEmailUpdateOtpMessage(EmailUpdateOTP emailUpdateOTP, String correlationId) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {

            mimeMessageHelper.setTo(emailUpdateOTP.getNewEmailId());
            mimeMessageHelper.setSubject(Constants.EMAIL_UPDATE_MAIL_SUBJECT);
            mimeMessageHelper.setFrom(emailConfig.getUsername());
            mimeMessageHelper.setText(String.format(EmailUpdateOTPHtmlText.EMAIL_UPDATE_OTP_VERIFICATION, "OTP - " + emailUpdateOTP.getOtp()), true);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        sendMail(mimeMessage, correlationId);
    }

    @Override
    public void handlePasswordResetUrl(PasswordReset passwordReset, String correlationId) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {

            mimeMessageHelper.setTo(passwordReset.getEmail());
            mimeMessageHelper.setSubject(Constants.PASSWORD_RESET_MAIL_SUBJECT);
            mimeMessageHelper.setFrom(emailConfig.getUsername());

            String passwordResetUrl = connectionConfig.getAppHostUrl() + "8846" + "/mym/api/users/password/reset/form?email=" + passwordReset.getEmail() + "&token=" + passwordReset.getToken();

            mimeMessageHelper.setText(String.format(PasswordResetHtmlText.PASSWORD_RESET_EMAIL_TEXT, passwordResetUrl), true);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        sendMail(mimeMessage, correlationId);
    }

    @Override
    public void sendMail(MimeMessage mimeMessage, String correlation_id) {

        try {

            new Thread(() -> {

                log.info(MymUtil.createLog(correlation_id, "Sending mail..."));
                javaMailSender.send(mimeMessage);
                log.info(MymUtil.createLog(correlation_id, "Mail sent successfully..."));
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Mail not sent!!");
            throw e;
        }

    }


}
