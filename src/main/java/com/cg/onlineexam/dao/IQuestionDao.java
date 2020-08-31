package com.cg.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexam.entity.Questions;


@Repository
public interface IQuestionDao extends JpaRepository<Questions,String>{

}
