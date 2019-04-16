package by.bsuir.ios.pokertrainer.entity;

import java.util.List;

public class ResultBean {

	private List<Question> questions;
	private List<Answer> answers;
	private List<Integer> resultAnswerId;

	public List<Integer> getAnswerId() {
		return resultAnswerId;
	}

	public void setAnswerId(List<Integer> answerId) {
		this.resultAnswerId = answerId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Integer> getResultAnswerId() {
		return resultAnswerId;
	}

	public void setResultAnswerId(List<Integer> resultAnswerId) {
		this.resultAnswerId = resultAnswerId;
	}

}
