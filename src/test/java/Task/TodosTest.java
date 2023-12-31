package Task;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.findAll();
        Task[] expected = { simpleTask, epic, meeting };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProperlyFindOneTask() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expectedTasks = { meeting };

        Assertions.assertArrayEquals(expectedTasks, todos.search(meeting.getTopic()));
    }

    @Test
    public void shouldProperlySearchMultipleTasks() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        SimpleTask simpleTask = new SimpleTask(5, "Выкатка приложения");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expectedTasks = { meeting, simpleTask };

        Assertions.assertArrayEquals(expectedTasks, todos.search("Выкатка"));
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchDidntFindAnything() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expectedTasks = {};

        Assertions.assertArrayEquals(expectedTasks, todos.search("Работа"));
    }
}