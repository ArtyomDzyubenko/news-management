package com.epam.newsmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NEWS")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsSequence")
    @SequenceGenerator(name = "newsSequence", sequenceName = "NEWS_SEQUENCE")
    @Column(name = "NEWS_ID")*/
    private Long id;

    /*@Column(name = "NEWS_TITLE")*/
    private String title;

    /*@Column(name = "NEWS_CREATE_DATE")*/
    private Date date;

   /* @Column(name = "NEWS_BRIEF")*/
    private String brief;

    /*@Column(name = "NEWS_CONTENT")*/
    private String content;

    /*@Column(name = "NEWS_USERNAME")*/
    private String username;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getBrief() {
        return brief;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
