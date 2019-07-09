package com.epam.newsmanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NewsDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    private String date;

    @NotBlank
    @Size(min = 3, max = 500)
    private String brief;

    @NotBlank
    @Size(min = 3, max = 2048)
    private String content;

    @Size(min = 3, max = 20)
    private String username;

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

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }
}
