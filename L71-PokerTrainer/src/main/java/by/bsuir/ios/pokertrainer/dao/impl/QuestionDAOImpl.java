package by.bsuir.ios.pokertrainer.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import by.bsuir.ios.pokertrainer.dao.QuestionDAO;
import by.bsuir.ios.pokertrainer.entity.Question;
import by.bsuir.ios.pokertrainer.exception.DAOException;

public class QuestionDAOImpl implements QuestionDAO {

	private static final String SQL_SELECT_ALL_QUESTIONS = "SELECT q_id, q_text FROM questions";

	private static final String QUESTION_ID = "q_id";
	private static final String NAME = "q_text";

	@Autowired
	private DataSource dataSource;

	@Override
	public void create(Question entity) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Question retrieve(Integer key) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Question> retrieveAll() throws DAOException {
		List<Question> questions = new ArrayList<>();
		Question question = null;

		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_ALL_QUESTIONS);) {
			while (rs.next()) {
				int questionId = rs.getInt(QUESTION_ID);
				String name = rs.getString(NAME);
				question = new Question();
				question.setQuestionId(questionId);
				question.setText(name);
				questions.add(question);

			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrive list of questions from db.", e);
		}

		return questions;
	}

	@Override
	public void update(Question entity) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Integer key) throws DAOException {
		throw new UnsupportedOperationException();
	}

}
