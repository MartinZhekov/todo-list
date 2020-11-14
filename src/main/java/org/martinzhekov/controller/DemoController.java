package org.martinzhekov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by martinzhekov on 14.11.20
 */

@Controller
public class DemoController {

    // http://localhost:8080/todo-list/test
    @ResponseBody
    @GetMapping("/demo")
    public String demo(){
        return "This is a test";
    }
}
