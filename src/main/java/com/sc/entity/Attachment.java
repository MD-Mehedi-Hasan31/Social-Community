package com.sc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbattachment")
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "at_id", nullable=false)
    private Long id;

    @Column(name="attachment_name", length=1024)
    private String attachmentName;

    @Column(name = "attachment_path", length=1024)
    private  String attachmentPath;

    @Column(name = "attachment_type", length=1024)
    private String attachmentType;


}
