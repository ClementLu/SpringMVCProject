package mvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.entity.Academy;
import mvc.entity.Colleage;
import mvc.entity.User;
import mvc.entity.UserException;
import mvc.service.AcademyService;
import mvc.service.ColleageService;
import mvc.service.UserService;

@Controller
@RequestMapping(value = "user/")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "colleageService")
	private ColleageService colleageService;

	@Resource(name = "academyService")
	private AcademyService academyService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(String username, String password, String nickname, int age) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(age);
		user.setNickname(nickname);

		try {
			userService.addNewUser(user);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		try {
			User loginUser = userService.findByUsernameAndPassword(username, password);
			session.setAttribute("loginUser", loginUser);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/user/users";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("colleages");// 退出时要把之前的对象移除，否则下次登录该页面会在此显示该页面的内容
		return "redirect:/login.jsp";
	}

	// Model是每次请求中都存在的默认参数，
	// 利用其addAttribute()方法即可将服务器的值传递到jsp页面中；
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String index(Model m) {
		List<Colleage> colleages = colleageService.listAllColleage();
		m.addAttribute("colleages", colleages);
		List<Academy> academies = academyService.listAllAcademy();
		m.addAttribute("academies", academies);
		return "index";
	}
}
