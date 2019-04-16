package by.bsuir.ios.pokertrainer.dao;

import by.bsuir.ios.pokertrainer.entity.User;
import by.bsuir.ios.pokertrainer.exception.DAOException;

public interface UserDAO extends BaseDAO<Integer, User> {
    User getUser(String login, String password) throws DAOException;
    User getUser(String login) throws DAOException;
}
