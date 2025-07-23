package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class WebPageController {

    @GetMapping(value = "/")
    public RedirectView redirectToLogin() {
        return new RedirectView("/login");
    }

    @GetMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public String login() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/login.html");

        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @GetMapping(value = "/dashboard", produces = MediaType.TEXT_HTML_VALUE)
    public String dashboard() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/dashboard_adm.html");

        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @GetMapping(value = "/logout", produces = MediaType.TEXT_HTML_VALUE)
    public String logout() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/dashboard_adm.html");

        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
