package com.sc.entity;


import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tbstatus")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name="title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "privacy")
    private String privacy;
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name="isdelete")
    private boolean isdelete;



    @OneToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "status_attachment",
            joinColumns={@JoinColumn(name = "status_id", referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name="attachment_id", referencedColumnName = "id")})
    private List<Attachment> statusAttachmentList;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

}
