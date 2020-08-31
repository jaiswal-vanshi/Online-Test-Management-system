package com.cg.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineexam.entity.Exam;

@Repository
public interface IExamDao extends JpaRepository<Exam, Integer>{
	/*@Query(value="select max(examId) from Exam")
	public Integer getMaxId();*/

}
