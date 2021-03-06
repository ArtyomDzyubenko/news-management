package com.epam.newsmanagement.dtoConverter;

import com.epam.newsmanagement.dto.NewsDTO;
import com.epam.newsmanagement.entity.News;
import org.springframework.security.core.context.SecurityContextHolder;
import java.sql.Date;

public class NewsDTOConverter {
    public static NewsDTO Entity2DTO(News entity) {
        NewsDTO dto = new NewsDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDate(entity.getDate().toString());
        dto.setBrief(entity.getBrief());
        dto.setContent(entity.getContent());
        dto.setUsername(entity.getUsername());

        return dto;
    }

    public static News DTO2Entity(NewsDTO dto) {
        String userName = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        News entity = new News();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDate(Date.valueOf(dto.getDate()));
        entity.setBrief(dto.getBrief());
        entity.setContent(dto.getContent());
        entity.setUsername(userName);

        return entity;
    }
}
