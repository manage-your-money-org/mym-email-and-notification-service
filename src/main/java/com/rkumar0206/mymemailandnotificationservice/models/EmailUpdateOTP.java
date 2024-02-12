package com.rkumar0206.mymemailandnotificationservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailUpdateOTP {

    private String id;
    private String oldEmailId;
    private String newEmailId;
    private String otp;
    private String token;
}
