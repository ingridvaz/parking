package com.api.rest.parking.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestUserDTO {

    private String username;
    private String password;

}
