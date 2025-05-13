package com.quiz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

//@Data
@Entity
@Table(name = "QuizQuestions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
//	@SequenceGenerator(name = "question_seq", sequenceName = "QUESTION_SEQ", allocationSize = 1)
	
	private Integer id;
	@Column(name = "QUESTION_TITLE")
	private String questionTitle;

	@Column(name = "OPTION1")
	private String option1;

	@Column(name = "OPTION2")
	private String option2;

	@Column(name = "OPTION3")
	private String option3;

	@Column(name = "OPTION4")
	private String option4;

	@Column(name = "RIGHT_ANSWER")
	private String rightAnswer;

	@Column(name = "DIFFICULTY_LEVEL")
	private String difficultyLevel;

	@Column(name = "CATEGORY")
	private String category;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer id, String questionTitle, String option1, String option2, String option3, String option4,
			String rightAnswer, String difficultyLevel, String category) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightAnswer = rightAnswer;
		this.difficultyLevel = difficultyLevel;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightAnswer=" + rightAnswer
				+ ", difficultyLevel=" + difficultyLevel + ", category=" + category + "]";
	}
	

}
