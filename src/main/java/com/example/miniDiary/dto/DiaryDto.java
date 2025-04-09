package com.example.miniDiary.dto;


import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.type.Mood;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.datatype.Duration;
import java.time.LocalDate;

@Getter
@Setter
public class DiaryDto {

    private Long id;
    private Mood mood;
    private LocalDate date;
    private String title;
    private String weather;
    private String body;


    public DiaryDto(Long id, Mood mood, LocalDate date, String title, String weather, String body) {
        this.id = id;
        this.mood = mood;
        this.date = date;
        this.title = title;
        this.weather = weather;
        this.body = body;
    }

    @Override
    public String toString() {
        return "DiaryDto{" +
                "id=" + id +
                ", mood=" + mood +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", weather='" + weather + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Diary toEntity() {
        return new Diary(id, date, mood, title, weather, body);
    }
}
