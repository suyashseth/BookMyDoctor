package com.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.beans.Doctor;
import com.booking.dao.DAOJPAImpl;

@Controller
@RequestMapping("/lc")
public class LoginController {

	@RequestMapping(value = "/dlogin",method = RequestMethod.POST)
	public String doctorLogin(
			@RequestParam("email")String id,
			@RequestParam("password")String password,
			Model model
			)
	{
		DAOJPAImpl impl = new DAOJPAImpl();
		Doctor d = impl.doctorLogin(id, password);
		model.addAttribute("d",d);
		return "";
	}
}
