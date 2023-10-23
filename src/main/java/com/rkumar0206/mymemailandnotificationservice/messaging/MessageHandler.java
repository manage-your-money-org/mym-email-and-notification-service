package com.rkumar0206.mymemailandnotificationservice.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkumar0206.mymemailandnotificationservice.config.RoutingKeysConfig;
import com.rkumar0206.mymemailandnotificationservice.constants.Constants;
import com.rkumar0206.mymemailandnotificationservice.constants.ErrorMessageConstants;
import com.rkumar0206.mymemailandnotificationservice.models.ConfirmationToken;
import com.rkumar0206.mymemailandnotificationservice.models.EmailUpdateOTP;
import com.rkumar0206.mymemailandnotificationservice.models.PasswordReset;
import com.rkumar0206.mymemailandnotificationservice.services.EmailService;
import com.rkumar0206.mymemailandnotificationservice.utility.MymUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageHandler {

    private final EmailService emailService;
    private final RoutingKeysConfig routingKeysConfig;

    @RabbitListener(queues = "mym-email-notification-service")
    public void handleEmailMessage(Message message) throws IOException {

        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        String correlationId = message.getMessageProperties().getHeader(Constants.CORRELATION_ID);

        if (MymUtil.isNotValid(routingKey)) {
            throw new RuntimeException(ErrorMessageConstants.ROUTING_KEY_NOT_RECEIVED);
        }

        if (MymUtil.isNotValid(correlationId)) {
            throw new RuntimeException(ErrorMessageConstants.CORRELATION_ID_HEADER_NOT_FOUND);
        }

        log.info(MymUtil.createLog(correlationId, "Received routing key: " + routingKey));

        if (routingKey.equals(routingKeysConfig.getAccountVerification())) {

            ConfirmationToken confirmationToken = new ObjectMapper().readValue(
                    message.getBody(), ConfirmationToken.class
            );

            log.info(MymUtil.createLog(correlationId, "Received confirmationToken: " + confirmationToken.toString()));
            emailService.handleConfirmationTokenMessage(confirmationToken, correlationId);

        } else if (routingKey.equals(routingKeysConfig.getEmailUpdateOtp())) {

            EmailUpdateOTP emailUpdateOTP = new ObjectMapper().readValue(
                    message.getBody(), EmailUpdateOTP.class
            );

            log.info(MymUtil.createLog(correlationId, "Received emailOtp: " + emailUpdateOTP.toString()));
            emailService.handleEmailUpdateOtpMessage(emailUpdateOTP, correlationId);

        } else if (routingKey.equals(routingKeysConfig.getPasswordReset())) {

            PasswordReset passwordReset = new ObjectMapper().readValue(
                    message.getBody(), PasswordReset.class
            );

            log.info(MymUtil.createLog(correlationId, "Received passwordReset: " + passwordReset.toString()));
            emailService.handlePasswordResetUrl(passwordReset, correlationId);
        }

    }

}
