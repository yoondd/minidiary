package com.example.miniDiary.repository;

import com.example.miniDiary.entity.Diary;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface DiaryRepository extends CrudRepository<Diary, Long> {
    @Override
    ArrayList<Diary> findAll();
}
