package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizservice;

	@GetMapping("/getallquestions")
	public ResponseEntity<List<Question>> getQuestions() {
		return quizservice.getAllQuestions();
	}
	
	@GetMapping("/getquestionsbycategory/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return quizservice.getQuestionsByCategory(category);
	}
	
	@PostMapping("/addquestion")
	public String addQuestion(@RequestBody Question question) {
		return quizservice.addQuestion(question);
	}
}
