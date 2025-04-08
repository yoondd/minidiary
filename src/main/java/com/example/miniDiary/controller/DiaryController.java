package com.example.miniDiary.controller;

import com.example.miniDiary.dto.DiaryDto;
import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.repository.DiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/list")
    public String diaryList(Model model){
        model.addAttribute("username", "혜경");
        List<Diary> contents = diaryRepository.findAll();
        model.addAttribute("contents", contents);
        return "diarylist";
    }

    @GetMapping("/diary/{id}")
    public String diaryRead(@PathVariable Long id, Model model){
        log.info("id= "+id);
        model.addAttribute("username", "혜경");
        Diary diaryEntity = diaryRepository.findById(id).orElse(null);
        model.addAttribute("diary", diaryEntity);
        return "diaryview";
    }
    @GetMapping("/write")
    public String diaryWrite(Model model){
        model.addAttribute("username", "혜경");
        return "write";
    }

    @PostMapping("/write_process")
    public String writeProcess(@ModelAttribute  DiaryDto form){
        System.out.println(form.toString());
        //엔티티로 변환
        Diary diary = form.toEntity();

        //리파지토리에게 저장하도록 시킴
        Diary saved = diaryRepository.save(diary);
        System.out.println(saved);
        return "redirect:/diary/"+diary.getId();
    }

    @GetMapping("/diary/{id}/delete")
    public String diaryDelete(@PathVariable Long id){
        Diary deleted = diaryRepository.findById(id).orElse(null);
        if(deleted != null){
            diaryRepository.delete(deleted);
        }
        return "redirect:/list";
    }




}
