package EvilTester.POJOs;

import java.util.List;

public class TodoItem {
    private List<TodosItem> todos;

    public void setTodos(List<TodosItem> todos) {
        this.todos = todos;
    }

    public List<TodosItem> getTodos() {
        return todos;
    }

    @Override
    public String toString() {
        return
                "TodoItem{" +
                        "todos = '" + todos + '\'' +
                        "}";
    }
}