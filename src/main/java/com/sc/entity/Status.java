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
    private long id; // Done

    @Column(name="title")
    private String title; //title

    @Column(name = "description")
    private String description; //description

    @Column(name = "privacy")
    private String privacy; //privacy

    @Column(name="isdelete")
    private boolean isdelete; //done

    @Column(name="created_at")
    private Date createdAt; // done

    @Column(name = "updated_at")
    private Date updatedAt; // done



    @ManyToOne(fetch = FetchType.LAZY) // done
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY) // done
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;


    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "status_attachment",
                   joinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")},
                   inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "at_id")})
    private List<Attachment> statusAttachmentList;




    /*
    *
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "status_attachments",
            joinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "id")})
    private List<Attachment> statusAttachmentList;
    *

    @OneToMany(fetch=FetchType.LAZY, orphanRemoval = true) // not done
    @JoinTable(name = "status_attachment",
            joinColumns={@JoinColumn(name = "status_id", referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name="attachment_id", referencedColumnName = "at_id")})
    private List<Attachment> statusAttachmentList;
*/


}
