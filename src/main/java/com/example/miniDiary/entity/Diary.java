package com.example.miniDiary.entity;

import com.example.miniDiary.type.Mood;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Diary {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Mood mood;

    @Column
    private String title;

    @Column
    private String weather;

    @Column
    private String body;

    public Diary(Long id, Mood mood, String title, String weather, String body) {
        this.id = id;
        this.mood = mood;
        this.title = title;
        this.weather = weather;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", mood=" + mood +
                ", title='" + title + '\'' +
                ", weather='" + weather + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
