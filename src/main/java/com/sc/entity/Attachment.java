package com.sc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbattachment")
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable=false)
    private long  id;
    @Column(name="attachment_name", nullable = false)
    private String attachmentName;

    @Column(name = "attachment_path", nullable = false)
    private  String attachmentPath;

    @Column(name = "attachment_type", nullable = false)
    private String attachmentType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachment_name) {
        this.attachmentName = attachment_name;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachment_path) {
        this.attachmentPath = attachment_path;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachment_type) {
        this.attachmentType = attachment_type;
    }
}
