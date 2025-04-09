package com.example.miniDiary.entity;

import com.example.miniDiary.type.Mood;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Diary {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private Mood mood;

    @Column
    private String title;

    @Column
    private String weather;

    @Column
    private String body;




}
