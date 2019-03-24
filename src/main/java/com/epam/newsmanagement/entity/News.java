package com.epam.newsmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NEWS")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsSequence")
    @SequenceGenerator(name = "newsSequence", sequenceName = "NEWS_SEQUENCE")
    @Column(name = "NEWS_ID")
    private Long id;

    @Column(name = "NEWS_TITLE")
    private String title;

    @Column(name = "NEWS_CREATE_DATE")
    private String date;

    @Column(name = "NEWS_BRIEF")
    private String brief;

    @Column(name = "NEWS_CONTENT")
    private String content;

    @Transient
    private boolean selected;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getBrief() {
        return brief;
    }

    public String getContent() {
        return content;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
