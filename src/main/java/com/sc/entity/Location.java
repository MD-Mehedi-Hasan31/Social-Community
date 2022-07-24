package com.sc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tblocation")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "location_name")
    private String locationName;


    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private List<User> users = new ArrayList<>();

    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private  List<Status> statuses= new ArrayList<>();

}
