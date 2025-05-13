package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.model.CreateQuiz;

public interface CreateQuizRepository extends JpaRepository<CreateQuiz, Integer> {

}
