package com.vini.mysite.core.ec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionId")
	private Long questionId;

	@Column(name="category", nullable=false)
	private String category;

	@Column(name="question", nullable=false)
	private String question;

	@Column(name="answer")
	private String answer;

	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Question [" 
		+ " Id = " + questionId 
		+ ", Category = " + category 
		+ ", Question = " + question 
		+ ", Answer = " + answer
		+ ", " + super.toString() + "]";
	}




}
