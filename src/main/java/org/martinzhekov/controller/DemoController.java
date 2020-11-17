package org.martinzhekov.controller;

import lombok.extern.slf4j.Slf4j;
import org.martinzhekov.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by martinzhekov on 14.11.20
 */

@Slf4j
@Controller
public class DemoController {
    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==

    // http://localhost:8080/todo-list/test
    @ResponseBody
    @GetMapping("/demo")
    public String demo(){
        return "This is a test";
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=Martin
    // http://localhost:8080/todo-list/welcome?user=Martin&age=31
    @GetMapping("welcome")
    public String demoView(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model= {}", model);
        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
