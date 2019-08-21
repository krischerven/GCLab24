package com.grandcircus.SpringDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;

@Controller
public class HomeController {
	@Autowired
	Database database;
	public ModelAndView getDefaultModelAndView(String page, String name, Object object) {
		ModelAndView m = new ModelAndView(page, name, object);
		m.addObject("copyright", Utility.copyright());
		m.addObject("items", database.getAllItems());
		return m;
	}
	@RequestMapping("/")
	public ModelAndView home() {
		return getDefaultModelAndView("index", "modelName", "Hello World!");
	}
	@RequestMapping("/shop")
	public ModelAndView gotoShop() {
		return getDefaultModelAndView("shop", "modelName", "Hello World!");
	}
	@RequestMapping("/registration")
	public ModelAndView gotoRegistration() {
		return getDefaultModelAndView("registration", "modelName", "Hello World!");
	}
	
	@RequestMapping("/post_registration")
	public ModelAndView gotoPostRegistration(@RequestParam("name1") String a, @RequestParam("name2") String b, 
			@RequestParam("city") String c, @RequestParam("address") String d, @RequestParam("phone") String e, @RequestParam("email") String f) {
		e = e.replace(" ", ""); // phone # must be exactly 10 chars as per DB specifications
		Account acc = new Account(a, b, c, d, e, f);
		database.addAccount(acc);
		return getDefaultModelAndView("post_registration", "user", acc);
	}
}