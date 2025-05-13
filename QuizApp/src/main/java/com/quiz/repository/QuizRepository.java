package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.model.Question;

public interface QuizRepository extends JpaRepository<Question, Integer> {
   
	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT * FROM (SELECT * FROM Quiz_Questions WHERE category = :category ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
