package by.bsuir.ios.pokertrainer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import by.bsuir.ios.pokertrainer.dao.AnswerDAO;
import by.bsuir.ios.pokertrainer.entity.Answer;
import by.bsuir.ios.pokertrainer.exception.DAOException;

public class AnswerDAOImpl implements AnswerDAO {

	private static final String SQL_SELECT_ANSWERS_BY_QUESTION_ID = "select a_id, a_text, is_true from answers where q_id = ?";
	private static final String SQL_SELECT_ALL_ANSWERS = "select * from answers";
	private static final String SQL_SELECT_CORRECT_ANSWER_COUNT = "select count(*) as count from answers where a_id in (";
	private static final String SQL_SELECT_USER_LEVEL = "select case when cond.p1 * a.p1 / (cond.p1 * a.p1 + cond.p2 * a.p2) > cond.p2 * a.p2/ (cond.p1 * a.p1 + cond.p2 * a.p2)"
			+ " then 'A' else 'N' end from (select a.c/b.c as p1, c.c/b.c as p2 from (select count(*) as c  from results) b,"
			+ " (select count(*) as c from results where lvl = 'A') a, (select count(*) as c from results where lvl = 'N') c) a, (select a.c/d.c  as p1, c.c/b.c as p2 from (select count(*) as c  from results where lvl = 'N') b,"
			+ " (select count(*) as c  from results where lvl = 'A') d, (select count(*) as c from results where cor_ans <= ? and lvl = 'A')"
			+ " a, (select count(*) as c from results where cor_ans <= ? and lvl = 'N') c) cond";

	@Autowired
	private DataSource dataSource;

	@Override
	public void create(Answer entity) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Answer retrieve(Integer key) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Answer> retrieveAll() throws DAOException {
		List<Answer> answers = new ArrayList<>();
		Answer answer = null;

		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ANSWERS);) {
			while (rs.next()) {
				int answerId = rs.getInt("a_id");
				int questionId = rs.getInt("q_id");
				String text = rs.getString("a_text");
				boolean isTrue = rs.getBoolean("is_true");
				answer = new Answer();
				answer.setAnswerId(answerId);
				answer.setQuestionId(questionId);
				answer.setText(text);
				answer.setTrue(isTrue);
				answers.add(answer);

			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrive list of answers from db.", e);
		}

		return answers;
	}

	@Override
	public void update(Answer entity) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Integer key) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Answer> getAnswersByQuestionId(Integer questionId) throws DAOException {
		List<Answer> answers = new ArrayList<>();
		Answer answer = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ANSWERS_BY_QUESTION_ID);) {
			ps.setInt(1, questionId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int answerId = rs.getInt("a_id");
					String text = rs.getString("a_text");
					boolean isTrue = rs.getBoolean("isTrue");
					answer = new Answer();
					answer.setAnswerId(answerId);
					answer.setQuestionId(questionId);
					answer.setText(text);
					answer.setTrue(isTrue);
					answers.add(answer);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrive list of answers from db.", e);
		}

		return answers;
	}

	@Override
	public Integer getCorrectAnswerCount(List<Integer> answerIds) throws DAOException {
		int correctAnswerCount = 0;

		StringBuilder builder = new StringBuilder(SQL_SELECT_CORRECT_ANSWER_COUNT);
		for (Integer integer : answerIds) {
			builder.append(integer + ",");
		}
		builder.setLength(builder.length() - 1);
		builder.append(") and is_true=true");
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(builder.toString());) {
			while (rs.next()) {
				correctAnswerCount = rs.getInt("count");
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrieve user from db.", e);
		}
		return correctAnswerCount;
	}

	@Override
	public String getLevel(int correctAnswerCount) throws DAOException {
		String level = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_LEVEL);) {
			ps.setInt(1, correctAnswerCount);
			ps.setInt(2, correctAnswerCount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					level = rs.getString(1);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrive list of answers from db.", e);
		}

		return level;
	}

}
