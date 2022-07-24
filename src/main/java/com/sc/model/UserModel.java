package com.sc.model;


import com.sc.entity.Attachment;
import com.sc.entity.Location;
import lombok.Data;

@Data
public class UserModel {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Location location;
    private Attachment attachment;
}
