package by.bsuir.ios.pokertrainer.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import by.bsuir.ios.pokertrainer.dao.AnswerDAO;
import by.bsuir.ios.pokertrainer.dao.QuestionDAO;
import by.bsuir.ios.pokertrainer.dao.UserDAO;
import by.bsuir.ios.pokertrainer.entity.ResultBean;
import by.bsuir.ios.pokertrainer.entity.User;
import by.bsuir.ios.pokertrainer.exception.DAOException;

@Controller
public class BaseController {
	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected QuestionDAO questionDAO;

	@Autowired
	protected AnswerDAO answerDAO;

	protected void addCookie(String cookieName, HttpServletResponse resp) {
		Cookie cookie = new Cookie("login", cookieName);
		cookie.setMaxAge(1000000);
		cookie.setPath("/");
		resp.addCookie(cookie);
	}

	protected void removeCookie(String cookieName, HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return;
		}
		for (Cookie cookie : cookies) {
			if ("login".equals(cookie.getName())) {
				cookie.setMaxAge(0);
				break;
			}
		}
	}

	public String manageRequests(HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			User user = getCurrentUser(req);
			if (user == null) {
				return "index";
			}
			model.addAttribute("currentuser", user.getName());
			ResultBean resultBean = new ResultBean();
			resultBean.setAnswers(answerDAO.retrieveAll());
			resultBean.setQuestions(questionDAO.retrieveAll());
			resultBean.setAnswerId(new ArrayList<Integer>());
			model.addAttribute("result", resultBean);
			return "index";
		} catch (DAOException exception) {
			return "error";
		}
	}

	protected User getCurrentUser(HttpServletRequest req) throws DAOException {
		Cookie[] cookies = req.getCookies();
		String login = "";
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if ("login".equals(cookie.getName())) {
				login = cookie.getValue();
				break;
			}
		}
		User userDb = userDAO.getUser(login);
		return userDb;
	}
}
