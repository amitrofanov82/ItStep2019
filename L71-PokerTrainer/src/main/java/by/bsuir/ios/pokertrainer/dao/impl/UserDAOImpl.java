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

import by.bsuir.ios.pokertrainer.dao.UserDAO;
import by.bsuir.ios.pokertrainer.entity.User;
import by.bsuir.ios.pokertrainer.exception.DAOException;

public class UserDAOImpl implements UserDAO {

	private static final String SQL_CREATE_USER = "INSERT INTO students(s_name, s_pass, lvl) VALUES(?,?,?)";
	private static final String SQL_SELECT_USER_BY_ID = "SELECT s_name, s_pass, lvl FROM students WHERE s_id=?";
	private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD = "SELECT s_id, lvl FROM students WHERE s_name=? AND s_pass=?";
	private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT s_id, s_pass, lvl FROM students WHERE s_name=?";
	private static final String SQL_SELECT_ALL_USERS = "SELECT s_id, s_name, s_pass, lvl FROM students";
	private static final String SQL_UPDATE_USER = "UPDATE students SET s_name=?, s_pass=?, lvl=? WHERE s_id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM students WHERE s_id=?";

	private static final String USER_ID = "s_id";
	private static final String NAME = "s_name";
	private static final String PASSWORD = "s_pass";
	private static final String LEVEL = "lvl";

	@Autowired
	private DataSource dataSource;

	@Override
	public void create(User user) throws DAOException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_CREATE_USER);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, String.valueOf(user.getLevel()));
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while insert new user.", e);
		}
	}

	@Override
	public User retrieve(Integer userId) throws DAOException {
		User user = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_BY_ID);) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String name = rs.getString(NAME);
					String password = rs.getString(PASSWORD);
					char level = rs.getString(LEVEL).charAt(0);
					user = new User();
					user.setUserId(userId);
					user.setName(name);
					user.setPassword(password);
					user.setLevel(level);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrieve user from db.", e);
		}
		return user;
	}

	@Override
	public List<User> retrieveAll() throws DAOException {
		List<User> users = new ArrayList<>();
		User user = null;

		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_ALL_USERS);) {
			while (rs.next()) {
				int userId = rs.getInt(USER_ID);
				String name = rs.getString(NAME);
				String password = rs.getString(PASSWORD);
				char level = rs.getString(LEVEL).charAt(0);
				user = new User();
				user.setUserId(userId);
				user.setName(name);
				user.setPassword(password);
				user.setLevel(level);
				users.add(user);

			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrive list of users from db.", e);
		}

		return users;
	}

	@Override
	public void update(User user) throws DAOException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE_USER);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, String.valueOf(user.getLevel()));
			ps.setInt(4, user.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while update user.", e);
		}
	}

	@Override
	public void delete(Integer userId) throws DAOException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE_USER);) {
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while delete user.", e);
		}
	}

	@Override
	public User getUser(String name, String password) throws DAOException {
		User user = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD);) {
			ps.setString(1, name);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int userId = rs.getInt(USER_ID);
					char level = rs.getString(LEVEL).charAt(0);
					user = new User();
					user.setUserId(userId);
					user.setName(name);
					user.setPassword(password);
					user.setLevel(level);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrieve user from db.", e);
		}
		return user;
	}

	@Override
	public User getUser(String name) throws DAOException {
		User user = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_BY_LOGIN);) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int userId = rs.getInt(USER_ID);
					String password = rs.getString(PASSWORD);
					char level = rs.getString(LEVEL).charAt(0);
					user = new User();
					user.setUserId(userId);
					user.setName(name);
					user.setPassword(password);
					user.setLevel(level);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while retrieve user from db.", e);
		}
		return user;
	}
}
