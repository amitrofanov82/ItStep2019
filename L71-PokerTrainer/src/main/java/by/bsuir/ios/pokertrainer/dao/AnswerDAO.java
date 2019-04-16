package by.bsuir.ios.pokertrainer.dao;

import java.util.List;

import by.bsuir.ios.pokertrainer.entity.Answer;
import by.bsuir.ios.pokertrainer.exception.DAOException;

public interface AnswerDAO extends BaseDAO<Integer, Answer> {

	List<Answer> getAnswersByQuestionId(Integer questionId) throws DAOException;

	Integer getCorrectAnswerCount(List<Integer> answerIds) throws DAOException;

	String getLevel(int correctAnswerCount) throws DAOException;
}
