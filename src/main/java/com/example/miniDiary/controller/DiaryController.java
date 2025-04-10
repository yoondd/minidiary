package com.example.miniDiary.controller;

import com.example.miniDiary.dto.DiaryDto;
import com.example.miniDiary.entity.Diary;
import com.example.miniDiary.repository.DiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/list")
    public String diaryList(Model model) {
        // 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();

        return "redirect:/list/" + year + String.format("%02d", month);
    }

    // 특정 연/월의 데이터를 가져오는 메서드
    @GetMapping("/list/{yearMonth}")
    public String diaryListByYearMonth(@PathVariable String yearMonth, Model model) {
        // yearMonth를 파싱하여 연도와 월을 분리
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));


        // 해당 연/월의 데이터 조회
        List<Diary> contents = diaryRepository.findByYearAndMonth(year, month);

        // 현재 연/월을 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        LocalDate currentDate = LocalDate.of(year, month, 1);

        // 이전 달 계산
        LocalDate prevMonthDate = currentDate.minusMonths(1);
        String prevYearMonth = prevMonthDate.format(formatter); // yyyyMM 형식으로 변환

        // 다음 달 계산
        LocalDate nextMonthDate = currentDate.plusMonths(1);
        String nextYearMonth = nextMonthDate.format(formatter); // yyyyMM 형식으로 변환

        // 모델에 데이터 추가
        model.addAttribute("username", "혜경");
        model.addAttribute("contents", contents);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("prevyear", prevYearMonth);
        model.addAttribute("nextyear", nextYearMonth);

        return "diarylist"; // 뷰 이름 반환
    }

//    @GetMapping("/list")
//    public String diaryList(Model model){
//        model.addAttribute("username", "혜경");
//        model.addAttribute("isDarkMode", isDarkMode); // 다크모드 변수 추가
//        List<Diary> contents = diaryRepository.findAll();
//        model.addAttribute("contents", contents);
//        return "diarylist";
//    }

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
        //엔티티로 변환
        Diary diary = form.toEntity();

        //리파지토리에게 저장하도록 시킴
        Diary saved = diaryRepository.save(diary);
        System.out.println(saved);
        return "redirect:/diary/"+diary.getId();
    }

    @GetMapping("/diary/{id}/update")
    public String diaryUpdate(@PathVariable Long id, Model model){
        Diary diary = diaryRepository.findById(id).orElse(null);
        model.addAttribute("diary", diary);
        return "update";
    }

    @PostMapping("/update_process")
    public String updateProcess(@ModelAttribute DiaryDto form){
        Diary diaryEntity = form.toEntity();
        Diary updated = diaryRepository.findById(diaryEntity.getId()).orElse(null);
        if(updated!=null){
            diaryRepository.save(diaryEntity);
        }
        return "redirect:/diary/"+diaryEntity.getId();
    }



    @GetMapping("/diary/{id}/delete_process")
    public String diaryDelete(@PathVariable Long id){
        Diary deleted = diaryRepository.findById(id).orElse(null);
        if(deleted != null){
            diaryRepository.delete(deleted);
        }
        return "redirect:/list";
    }







}
