package com.epam.newsmanagement.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

public class NewsDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    /*@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;*/

    @NotBlank
    private String date;

    @NotBlank
    @Size(min = 3, max = 500)
    private String brief;

    @NotBlank
    @Size(min = 3, max = 2048)
    private String content;

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
}
