package com.davi.shop.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public interface RedirectController {

    
    public RedirectView redirectWithUsingRedirectView(
	    RedirectAttributes attributes);

}
