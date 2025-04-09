package com.example.miniDiary.repository;

import com.example.miniDiary.entity.Diary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;


public interface DiaryRepository extends CrudRepository<Diary, Long> {
    @Override
    ArrayList<Diary> findAll();

    // 특정 연/월의 데이터를 가져오는 메서드
    @Query("SELECT d FROM Diary d WHERE YEAR(d.date) = :year AND MONTH(d.date) = :month")
    List<Diary> findByYearAndMonth(int year, int month);
}
