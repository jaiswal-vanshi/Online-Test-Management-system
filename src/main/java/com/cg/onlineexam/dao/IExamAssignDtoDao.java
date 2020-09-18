package com.cg.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.entity.ExamUserAssign;
@Repository
public interface IExamAssignDtoDao extends JpaRepository<ExamUserAssign,Integer> {

	}
