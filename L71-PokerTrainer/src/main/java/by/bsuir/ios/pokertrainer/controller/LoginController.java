package by.bsuir.ios.pokertrainer.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.ios.pokertrainer.entity.ResultBean;
import by.bsuir.ios.pokertrainer.entity.User;
import by.bsuir.ios.pokertrainer.entity.UserModel;
import by.bsuir.ios.pokertrainer.exception.DAOException;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(HttpServletRequest req, HttpServletResponse resp, Model model) {
		removeCookie("login", req, resp);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			User userDb = userDAO.getUser(user.getName());
			if (userDb == null || !passwordEncoder.matches(user.getPassword(), userDb.getPassword())) {
				result.rejectValue("password", "wrongPassword", "Login or password is incorrect!");
			}
			if (result.hasErrors()) {
				return "login";
			} else {
				addCookie(userDb.getName(), resp);
			}
			model.addAttribute("currentuser", userDb.getName());
			ResultBean resultBean = new ResultBean();
			resultBean.setAnswers(answerDAO.retrieveAll());
			resultBean.setQuestions(questionDAO.retrieveAll());
			resultBean.setAnswerId(new ArrayList<Integer>());
			model.addAttribute("result", resultBean);
			return "redirect:/";
		} catch (DAOException exception) {
			return "error";
		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView processRegister() {
		return new ModelAndView("registration", "person", new UserModel());

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("person") UserModel person, HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			User user = new User();
			user.setName(person.getName());
			user.setPassword(passwordEncoder.encode(person.getPassword()));
			userDAO.create(user);
			model.addAttribute("currentuser", user.getName());
			ResultBean resultBean = new ResultBean();
			resultBean.setAnswers(answerDAO.retrieveAll());
			resultBean.setQuestions(questionDAO.retrieveAll());
			resultBean.setAnswerId(new ArrayList<Integer>());
			model.addAttribute("result", resultBean);
			return "redirect:/";
		} catch (DAOException exception) {
			return "error";
		}
	}
}
