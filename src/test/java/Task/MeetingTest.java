package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {
    private Meeting meeting;

    @BeforeEach
    public void init() {
        meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
    }

    @Test
    public void shouldContainProperId() {
        Assertions.assertEquals(555, meeting.getId());
    }

    @Test
    public void shouldContainProperTopic() {
        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }

    @Test
    public void shouldContainProperProject() {
        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
    }

    @Test
    public void shouldContainProperStartPoint() {
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());
    }

    @Test
    public void shouldFindTopicAndProjectWhenExists() {
        Assertions.assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        Assertions.assertTrue(meeting.matches("Приложение НетоБанка"));
    }
}
