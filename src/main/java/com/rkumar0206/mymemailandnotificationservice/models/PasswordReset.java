package com.rkumar0206.mymemailandnotificationservice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PasswordReset {

    private String email;
    private String token;
}
