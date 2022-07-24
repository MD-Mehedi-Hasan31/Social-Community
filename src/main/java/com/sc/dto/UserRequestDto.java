package com.sc.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    
    //private Long id;
    private String username;
    private String email;
    private String password;
    private Long locationId;
}
