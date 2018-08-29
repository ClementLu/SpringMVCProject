package mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.entity.Academy;
import mvc.entity.Colleage;
import mvc.entity.UserException;
import mvc.service.AcademyService;
import mvc.service.ColleageService;

@Controller
@RequestMapping(value = "academy/")
public class AcademyController {
	int idForColleage;

	@Resource(name = "colleageService")
	private ColleageService colleageService;

	@Resource(name = "academyService")
	private AcademyService academyService;

	@RequestMapping(value = "{id}/addAcademy", method = RequestMethod.GET)
	public String jumpToAdd(@PathVariable int id) {
		idForColleage = id;
		return "CACS/addNewAcademy";
	}

	@RequestMapping(value = "addAcademy", method = RequestMethod.POST)
	public String addAcademy(String name ) {
		Colleage colleage = colleageService.findById(idForColleage);

		Academy academy = new Academy();
		academy.setName(name);
		academy.setColleage(colleage);
		System.out.println(academy);
		try {
			academyService.addAcademy(academy);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/user/users";
	}

	@RequestMapping(value = "delete/{id01}/{id02}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id01, @PathVariable int id02) {// 通过地址传过来
		Academy deleteAcademy = academyService.findById(id02);
		academyService.deleteAcademy(deleteAcademy);
		return "redirect:/user/users";
	}

}
