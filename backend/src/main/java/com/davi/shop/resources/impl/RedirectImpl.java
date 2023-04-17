package com.davi.shop.resources.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.davi.shop.resources.RedirectControllerAPI;

@Controller
@RequestMapping("/")
public class RedirectImpl implements RedirectControllerAPI {

    @GetMapping
    public RedirectView redirectWithUsingRedirectView(
	    RedirectAttributes attributes) {
	return new RedirectView("https://ecommerce-as.vercel.app/");
    }

}
