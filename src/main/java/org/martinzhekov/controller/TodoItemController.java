package org.martinzhekov.controller;

import org.martinzhekov.model.TodoData;
import org.martinzhekov.service.TodoItemService;
import org.martinzhekov.util.MappingConstantContainer;
import org.martinzhekov.util.ViewNameConstantContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //== model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(MappingConstantContainer.ITEMS)
    public String items(){
        return ViewNameConstantContainer.ITEMS_LIST;
    }
}
