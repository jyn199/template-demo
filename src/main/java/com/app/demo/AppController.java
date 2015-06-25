package com.app.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping("/hello")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        map.addAttribute("name", " World!");
        return "hello";
    }
	
	@RequestMapping(value="app")
	public ModelAndView appIndex(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/app/index");
		return mav;
	}
	
	@RequestMapping(value="velocity")
	public void velocityIndex(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("name", "VelocityDemo");
		try {
			request.getRequestDispatcher("/WEB-INF/vm/velocity/index.vm").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
}
