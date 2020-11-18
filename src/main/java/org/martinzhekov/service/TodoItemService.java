package org.martinzhekov.service;

import org.martinzhekov.model.TodoData;
import org.martinzhekov.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
