package by.bsuir.ios.pokertrainer.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.ios.pokertrainer.entity.User;
import by.bsuir.ios.pokertrainer.exception.DAOException;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(HttpServletRequest req, HttpServletResponse resp, Model model) {
		return manageRequests(req, resp, model);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getResult(HttpServletRequest req, HttpServletResponse resp, Model model) throws DAOException {
		User user = getCurrentUser(req);
		if (user == null) {
			return "index";
		}
		model.addAttribute("currentuser", user.getName());
		List<Integer> values = new ArrayList<Integer>();
		Enumeration<String> enumeration = req.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String parameterName = (String) enumeration.nextElement();
			if (parameterName.startsWith("answer_")) {
				values.add(Integer.valueOf(req.getParameter(parameterName)));
			}
		}
		try {
			model.addAttribute("level", answerDAO.getLevel(answerDAO.getCorrectAnswerCount(values)));
		} catch (DAOException e) {
			return "error";
		}
		return "index";
	}

	@RequestMapping(value = "/learn", method = RequestMethod.GET)
	public String learn(HttpServletRequest req, HttpServletResponse resp, Model model) throws DAOException {
		User user = getCurrentUser(req);
		if (user == null) {
			return "index";
		}
		model.addAttribute("currentuser", user.getName());
		return "learn";
	}
}
