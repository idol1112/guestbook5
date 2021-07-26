package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
public class GuestController {
	
	@Autowired
	private GuestDao guestDao;
	
	// 리스트+등록폼
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("[GuestController.addList]");

		// Dao 사용
		//GuestDao guestDao = new GuestDao();

		// Dao의 메소드로 데이터 가져오기
		List<GuestVo> guestList = guestDao.getGuestList();
		System.out.println(guestList);

		// model에 담기 ->addList로 보냄
		model.addAttribute("gList", guestList);

		return "addList";
	}

	// 등록 ModelAttribute으로 받을 때
	@RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestVo guestVo) {

		// @ModelAttribute --> new PersonVo() // --> 기본생성자 + setter

		//GuestDao guestDao = new GuestDao();

		int count = guestDao.guestInsert(guestVo);
		System.out.println(guestVo);

		System.out.println(count + "건 등록하였습니다");
		return "redirect:/addList";
	}
	
	// 등록2 파라미터로 받을 때
	@RequestMapping(value = "add2", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@RequestParam("name") String name,
			 		  @RequestParam("hp") String hp,
			 		  @RequestParam("content") String content) {
		
		int count = guestDao.guestInsert2(name, hp, content);
		
		return "redirect:/addList";
	}
	// 삭제폼
	@RequestMapping(value = "dform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@RequestParam("no") int no, Model model) {
		System.out.println("[GuestController.dform]");

		model.addAttribute("no", no);
		return "deleteForm";
	}

	// 삭제
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		
		//GuestDao guestDao = new GuestDao();
		
		int count = guestDao.guestDelete(no, password);
		
		System.out.println(count + "건 삭제하였습니다");
		
		return "redirect:/addList";
	}
}
