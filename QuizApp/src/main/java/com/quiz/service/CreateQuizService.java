package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.model.CreateQuiz;
import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Response;
import com.quiz.repository.CreateQuizRepository;
import com.quiz.repository.QuizRepository;
import com.quiz.repository.CreateQuizRepository;

@Service
public class CreateQuizService {
	
	@Autowired
	CreateQuizRepository createquizrepository;
	
	@Autowired
	QuizRepository quizrepository;

	public ResponseEntity<String> createQuiz() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>("Hi there",HttpStatus.OK);
	}

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = quizrepository.findRandomQuestionsByCategory(category,numQ);
		
		CreateQuiz createquiz = new CreateQuiz();
		createquiz.setTitle(title);
		createquiz.setQuestions(questions);
		createquizrepository.save(createquiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<CreateQuiz> createquiz = createquizrepository.findById(id);
		List<Question> questionsFromDB = createquiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList();
		for(Question q :questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		CreateQuiz createquiz = createquizrepository.findById(id).get();
		List<Question> questions = createquiz.getQuestions();
		int right = 0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
