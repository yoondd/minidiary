package com.example.miniDiary.service;

import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public List<Diary> list() {
        return diaryRepository.findAll();
    }

}
