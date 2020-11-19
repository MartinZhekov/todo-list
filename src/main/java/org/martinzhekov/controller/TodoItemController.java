package org.martinzhekov.controller;

import lombok.extern.slf4j.Slf4j;
import org.martinzhekov.model.TodoData;
import org.martinzhekov.model.TodoItem;
import org.martinzhekov.service.TodoItemService;
import org.martinzhekov.util.AttributeNameContainer;
import org.martinzhekov.util.MappingConstantContainer;
import org.martinzhekov.util.ViewNameConstantContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(MappingConstantContainer.ITEMS)
    public String items() {
        return ViewNameConstantContainer.ITEMS_LIST;
    }

    @GetMapping(MappingConstantContainer.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("editing id={}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNameContainer.TODO_ITEM, todoItem);
        return ViewNameConstantContainer.ADD_ITEM;
    }

    @PostMapping(MappingConstantContainer.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNameContainer.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from from = {}", todoItem);

        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + MappingConstantContainer.ITEMS;
    }

    @GetMapping(MappingConstantContainer.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with id={}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + MappingConstantContainer.ITEMS;
    }

    @GetMapping(MappingConstantContainer.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNameContainer.TODO_ITEM, todoItem);
        return ViewNameConstantContainer.VIEW_ITEM;
    }
}
