package com.spring.practice.chatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chatting")
public class ChatController {


	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping("/chatMain")
	public void chatMain() {
	
	}
	
	
	@RequestMapping("/chatRoom")
	public void chatBot() {
	
	}
	
	@RequestMapping("/chatBot")
	public void chatRoom() {
	
	}
	
	
}