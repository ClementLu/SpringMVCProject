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

@Controller
@RequestMapping(value = "colleage/")
public class ColleageController {
	@Resource(name = "colleageService")
	private ColleageService colleageService;

	@Resource(name = "academyService")
	private AcademyService academyService;

	@RequestMapping(value = "{id}/addNewAcademy", method = RequestMethod.GET)
	public String jumpToAdd(@PathVariable int id) {
		return "redirect:/academy/" + id + "/addAcademy";
	}

	@RequestMapping(value = "{id}/jump", method = RequestMethod.GET)
	public String getColleage(@PathVariable int id, HttpSession session) {
		Colleage c = colleageService.findById(id);
		session.setAttribute("chosenColleage", c);
		return "CACS/colleage";
	}

	@RequestMapping(value = "addColleage", method = RequestMethod.POST)
	public String addColleage(String name, String address) {
		System.out.println("ColleageController Line 27" + name + " " + address);
		Colleage colleage = new Colleage();
		colleage.setName(name);
		colleage.setAddress(address);

		try {
			colleageService.addcolleage(colleage);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/user/users";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteColleage(@PathVariable int id) {// 通过地址传过来
		Colleage deleteColleage = colleageService.findById(id);
		colleageService.deleteColleage(deleteColleage);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "colleages", method = RequestMethod.GET)
	public String index(Model m) {
		List<Academy> academies = academyService.listAllAcademy();
		m.addAttribute("academies", academies);
		return "CACS/colleage";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addColleage() {
		return "CACS/addNewColleage";
	}

	@RequestMapping(value = "{id01}/academy/{id02}/delete", method = RequestMethod.GET)
	public String deleteColleage(@PathVariable int id01, @PathVariable int id02) {
		return "redirect:/academy/delete/" + id01 + "/" + id02;
	}
}
