package com.bootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bootjpa.dao.AlienDao;
import com.bootjpa.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienDao dao;
	
	@RequestMapping("/")
	public String home() {
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("obj", alien);
		//mv.setViewName("home");
		
		return "home.jsp";
	}
	@PostMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("obj", alien);
		//mv.setViewName("home");
		dao.save(alien);
		return "home.jsp";
				
	}
	@RequestMapping("/getAlienById")
	public ModelAndView getAlienById(@RequestParam("aid") int aid) {
		

		ModelAndView mv = new ModelAndView("list.jsp");
		Alien alien = dao.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(@RequestParam("aid") int aid) {
		ModelAndView mv = new ModelAndView("update.jsp");
		Alien alien = dao.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	@RequestMapping("/getAlienByTech")
	public ModelAndView getAlienByTech(String tech) {
		

		ModelAndView mv = new ModelAndView("listTech.jsp");
		//PreDefined methods in JPA
		List<Alien> alien = dao.findByTech(tech);
		mv.addObject("alien", alien);
		System.out.println(alien);
		//Greater/Less than predefined methods in JPA
		System.out.println(dao.findByAidGreaterThan(102));
		System.out.println(dao.findByTechSorted("Java"));
		return mv;
	}
	
	//Implementing webservices using REST
	//@RequestMApping(path="/aliens" produces={"application/xml"}) -->to explicitly mention what client wants
	@RequestMapping("/aliens")
	public List<Alien> getAliens() {
		
		//Convert to string as Spring looks for view name in return and include ResponseBody annot
		return dao.findAll();
		}
	
	//Optional is a java 8 feature which means it returns alien object, if null return optional object
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		//Convert to string as Spring looks for view name in return and include ResponseBody annot
		return dao.findById(aid);
		}
	
	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien addNewAlien(@RequestBody Alien alien) {
		

		dao.save(alien);
		
		return alien;
	}
	
	//PUT updates or if not found creates
	@PutMapping(path="/alien", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
	
		dao.save(alien);
		
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	public void deleteAlien(@PathVariable("aid") int aid) {
		
		dao.deleteById(aid);
		 
		}
	
	
	


	//to get the data in JSON in REST, extend JpaRepo in DAO
	//I RESTController is mentioned, no need to mention ResponseBody
}
