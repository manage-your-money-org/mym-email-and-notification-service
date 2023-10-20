package com.rkumar0206.mymemailandnotificationservice.services;

import com.rkumar0206.mymemailandnotificationservice.models.ConfirmationToken;
import com.rkumar0206.mymemailandnotificationservice.models.EmailUpdateOTP;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void handleConfirmationTokenMessage(ConfirmationToken confirmationToken, String correlation_id);

    void handleEmailUpdateOtpMessage(EmailUpdateOTP emailUpdateOTP, String correlationId);

    void sendMail(MimeMessage mimeMessage, String correlation_id);

}
