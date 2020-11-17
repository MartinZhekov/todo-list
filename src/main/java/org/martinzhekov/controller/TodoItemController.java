package org.martinzhekov.controller;

import org.martinzhekov.model.TodoData;
import org.martinzhekov.util.MappingConstantContainer;
import org.martinzhekov.util.ViewNameConstantContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
    //== model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return new TodoData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(MappingConstantContainer.ITEMS)
    public String items(){
        return ViewNameConstantContainer.ITEMS_LIST;
    }
}
