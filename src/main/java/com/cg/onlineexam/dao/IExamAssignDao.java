package com.cg.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineexam.entity.ExamUserAssign;
@Repository
public interface IExamAssignDao extends JpaRepository<ExamUserAssign,Integer> {

	@Query("select count(examUserAssignId) from ExamUserAssign ea where ea.user.userId=:user and ea.exam.examId=:eid")
	public int getCountOfUserByExam(@Param("user") int userId , @Param("eid") int examId);
}
