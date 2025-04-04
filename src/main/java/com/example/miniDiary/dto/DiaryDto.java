package com.example.miniDiary.dto;


import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.type.Mood;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.datatype.Duration;

@Getter
@Setter
public class DiaryDto {

    private Mood mood;
    private String title;
    private String weather;
    private String body;


    public DiaryDto(Mood mood, String title, String weather, String body) {
        this.mood = mood;
        this.title = title;
        this.weather = weather;
        this.body = body;
    }

    @Override
    public String toString() {
        return "DiaryDto{" +
                "mood=" + mood +
                ", title='" + title + '\'' +
                ", weather='" + weather + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Diary toEntity() {
        return new Diary(null, mood, title, weather, body);
    }
}
