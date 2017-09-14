package com.niit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
		@RequestMapping("/")
	public ModelAndView showHome()
	{
		 ModelAndView mv=new ModelAndView("mainpage");
		 
		return mv; 
	}
	@RequestMapping("/Login")
	public ModelAndView showLogin()
	{
		 ModelAndView mv=new ModelAndView("AdminHome");
		 
		return mv; 
	}
	@RequestMapping("/Register")
	public ModelAndView showRegister()
	{
		 ModelAndView mv=new ModelAndView("Register");
		 
		return mv; 
	}
	@RequestMapping("/Index")
	public ModelAndView showIndex()
	{
		 ModelAndView mv=new ModelAndView("Index");
		 
		return mv; 
	}
	@RequestMapping("/mainpage")
	public ModelAndView showMainpage()
	{
		 ModelAndView mv=new ModelAndView("mainpage");
		 
		return mv; 
	}
	@RequestMapping("/Contactus")
	public ModelAndView showContactus()
	{
		 ModelAndView mv=new ModelAndView("Contactus");
		 
		return mv; 
	}
	@RequestMapping("/Cart")
	public ModelAndView showCart()
	{
		 ModelAndView mv=new ModelAndView("Cart");
		 
		return mv; 
	}
	@RequestMapping("/AddtoCart")
	public ModelAndView showAddtoCart()
	{
		 ModelAndView mv=new ModelAndView("AddtoCart");
		 
		return mv; 
	}
	@RequestMapping("/Welcome")
	public ModelAndView showWelcome()
	{
		 ModelAndView mv=new ModelAndView("Welcome");
		 
		return mv; 
	}
	@RequestMapping("/chkLogin")
	public ModelAndView chkLogin(@RequestParam("txtemail")String mail,@RequestParam("txtpass")String pass)
	{
		 ModelAndView mv;
		 if(mail.equals("user@gmail.com")&&pass.equals("user1"))
				 {
			      mv=new ModelAndView("Welcome");
			      mv.addObject("loggedInUser","user");
			      return mv;
				 }
		 else if(mail.equals("admin@gmail.com")&&pass.equals("admin"))
		 {
			 mv=new ModelAndView("AdminHome");
			 mv.addObject("loggedInUser","admin");
			 return mv;
				 }
		 else
		 {
			 mv=new ModelAndView("Login");
			 return mv;
		 }
	}
}

