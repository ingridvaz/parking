package com.api.rest.parking.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPasswordDTO {

    private String actualPassword;
    private String newPassword;
    private String confirmPassword;
}
