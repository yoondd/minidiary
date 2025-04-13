package com.example.miniDiary.api;

import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiaryApiController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/api/list")
    public List<Diary> diary() {
        return diaryService.list();
    }
}
