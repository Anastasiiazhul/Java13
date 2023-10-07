package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    private final String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
    private Epic epic;

    @BeforeEach
    public void init() {
        epic = new Epic(55, subtasks);
    }

    @Test
    public void shouldContainAddedSubTasks() {
        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void shouldProperlyFindAddedSubTask() {
        Assertions.assertTrue(epic.matches("Молоко"));
    }

    @Test
    public void shouldNotMatchWhenSubtaskMissing() {
        Assertions.assertFalse(epic.matches("Кефир"));
    }
}