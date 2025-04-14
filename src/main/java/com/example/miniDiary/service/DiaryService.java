package com.example.miniDiary.service;

import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    // 전체 모든 일기를 조회한다
    public List<Diary> list() {
        return diaryRepository.findAll();
    }

    // list/202504로 접근해서
    public List<Diary> viewMonth(String yearMonth) {
        // yearMonth를 파싱하여 연도와 월을 분리
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));
        return diaryRepository.findByYearAndMonth(year, month);
    }


    public Diary create(Diary form) {
        Diary diary = form.toEntity();
        if(diary.getId() != null){
            return null;
        }
        return diaryRepository.save(diary);
    }

    public Diary update(Long id, Diary form) {
        Diary diary = form.toEntity();
        Diary target = diaryRepository.findById(id).orElse(null);
        if(target==null||id != diary.getId()){
            return null;
        }
        target.patch(diary);
        return diaryRepository.save(target);
    }


    public Diary delete(Long id) {
        Diary target = diaryRepository.findById(id).orElse(null);
        if(target==null) return null;
        diaryRepository.delete(target);
        return target;
    }
}
