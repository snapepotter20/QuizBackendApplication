package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.model.Question;
import com.quiz.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizrepository;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(quizrepository.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(quizrepository.findAll(),HttpStatus.BAD_REQUEST);
	}

	public List<Question> getQuestionsByCategory(String category) {
		
		return quizrepository.findByCategory(category);
	}

	public String addQuestion(Question question) {
		 Question saved = quizrepository.save(question);
		    System.out.println("Saved: " + saved);
		return "Question added successfully";
	}

	
	
}
