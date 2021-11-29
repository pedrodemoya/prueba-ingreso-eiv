package com.eiv.pruebaingreso.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/login")
	public String login(HttpSession session, Authentication usuario, ModelMap model,
			@RequestParam(required = false) String error) {
		try {
			if (usuario.getName() != null) {
				return "redirect:/";
			} else {
				if (error != null && !error.isEmpty())
					model.addAttribute("error", "El usuario o la contraseña que ingresó son incorrectos.");

				return "login.html";
			}
		} catch (Exception e) {
			if (error != null && !error.isEmpty())
				model.addAttribute("error", "El usuario o la contraseña que ingresó son incorrectos.");

			return "login";
		}
	}

	@GetMapping("/loginsuccess")
	public String loginresolver(ModelMap model, Authentication usuario) throws Exception {
		try {

			return "index.html";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "login.html";
		}
	}
}
