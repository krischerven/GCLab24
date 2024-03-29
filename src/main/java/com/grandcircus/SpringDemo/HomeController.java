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
		ModelAndView m = new ModelAndView(page, name != null ? name : "", object != null ? object : "");
		m.addObject("footer", Utility.footer());
		m.addObject("items", database.getAllItems());
		return m;
	}
	@RequestMapping("/")
	public ModelAndView home() {
		return getDefaultModelAndView("index", null, null);
	}
	@RequestMapping("home")
	public ModelAndView _home() {
		return getDefaultModelAndView("index", null, null);
	}
	@RequestMapping("/shop")
	public ModelAndView gotoShop() {
		return getDefaultModelAndView("shop", null, null);
	}
	@RequestMapping("/registration")
	public ModelAndView gotoRegistration() {
		return getDefaultModelAndView("registration", null, null);
	}
	@RequestMapping("/post_registration")
	public ModelAndView gotoPostRegistration(@RequestParam("name1") String a, @RequestParam("name2") String b, 
			@RequestParam("city") String c, @RequestParam("address") String d, @RequestParam("phone") String e, @RequestParam("email") String f) {
		e = e.replace(" ", ""); // phone # must be exactly 10 chars as per DB specifications
		Account acc = new Account(a, b, c, d, e, f);
		database.addAccount(acc);
		return getDefaultModelAndView("post_registration", "user", acc);
	}
	@RequestMapping("/purchase_item")
	public ModelAndView purchaseItem(@RequestParam("name") String a, @RequestParam("desc") String b, @RequestParam("quantity") int c, @RequestParam("price") int d) {
		database.remOneItem(new Item(a, b, c, d));
		return getDefaultModelAndView("index", null, null);
	}
	@RequestMapping("/filter")
	public ModelAndView filter(@RequestParam("filter") String str) {
		ModelAndView m = new ModelAndView("index", "", "");
		m.addObject("footer", Utility.footer());
		m.addObject("items", database.getAllItems(str));
		m.addObject("no_items", database.getAllItems(str).size() > 0 ? "" : "No items were found that matched your filter.");
		return m;
	}
}