package com.rkumar0206.mymemailandnotificationservice.services;

import com.rkumar0206.mymemailandnotificationservice.models.ConfirmationToken;
import com.rkumar0206.mymemailandnotificationservice.models.EmailUpdateOTP;
import com.rkumar0206.mymemailandnotificationservice.models.PasswordReset;
import jakarta.mail.internet.MimeMessage;

public interface EmailService {

    void handleConfirmationTokenMessage(ConfirmationToken confirmationToken, String correlation_id);

    void handleEmailUpdateOtpMessage(EmailUpdateOTP emailUpdateOTP, String correlationId);

    void handlePasswordResetUrl(PasswordReset passwordReset, String correlationId);

    void sendMail(MimeMessage mimeMessage, String correlation_id);
}
