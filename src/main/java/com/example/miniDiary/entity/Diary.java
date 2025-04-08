package com.example.miniDiary.entity;

import com.example.miniDiary.type.Mood;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Diary {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
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
