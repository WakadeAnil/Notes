package com.gotprint.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Note {

    @Id
    private int id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 1000)
    private String note;
    @Column
    private Date createTime;
    @Column
    private Date lastUpdateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email_id")
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
