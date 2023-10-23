package com.rkumar0206.mymemailandnotificationservice.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConfirmationToken {

    private String id;
    private String emailId;
    private String confirmationToken;
    private long createdDate;
}
