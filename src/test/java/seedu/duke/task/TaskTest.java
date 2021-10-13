package seedu.duke.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
    Task task = new Task("buy hand phone casing");

    @Test
    void getListComplete() {
        task.markAsDone();
        assertEquals(List.of("1", "buy hand phone casing"), task.getList());
    }
}