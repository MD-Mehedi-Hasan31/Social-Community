package com.sc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tbuser")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String  username;

    @Column(name="email")
    private String  email;

    @Column(name="password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    // We use "Cascade"  When we perform some action on the target entity,
    // the same action will be applied to the associated entity.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id", referencedColumnName = "at_id")
    private Attachment attachment;


    @OneToMany(orphanRemoval = true, mappedBy = "user")
    private List<Status> statusList;
}
