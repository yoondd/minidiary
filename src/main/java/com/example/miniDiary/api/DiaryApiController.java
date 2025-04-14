package com.example.miniDiary.api;

import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaryApiController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/api/list")
    public List<Diary> diarylist() {
        return diaryService.list();
    }

    @GetMapping("/api/list/{yearMonth}")
    public List<Diary> diaryMonth(@PathVariable String yearMonth) {
        return diaryService.viewMonth(yearMonth);
    }

    //create
    @PostMapping("/api/create")
    public ResponseEntity<Diary> createDiary(@RequestBody Diary form){
        Diary created = diaryService.create(form);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //patch
    @PatchMapping("/api/diary/{id}")
    public ResponseEntity<Diary> update(@PathVariable Long id, @RequestBody Diary form){
        Diary updated = diaryService.update(id, form);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //delete
    @DeleteMapping("/api/diary/{id}")
    public ResponseEntity<Diary> delete(@PathVariable Long id){
        Diary deleted = diaryService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
