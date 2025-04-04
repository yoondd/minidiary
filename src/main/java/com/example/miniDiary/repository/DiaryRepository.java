package com.example.miniDiary.repository;

import com.example.miniDiary.entity.Diary;
import org.springframework.data.repository.CrudRepository;


public interface DiaryRepository extends CrudRepository<Diary, Long> {

}
