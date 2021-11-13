package seedu.duke;

import category.Category;
import exception.ErrorHandler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    private final Category category = new Category();

    @Test
    public void addCategory() throws ErrorHandler {
        category.addCategory("fishes");
        assertEquals("fishes", category.getCategory(0));
    }

    @Test
    public void addAnotherCategory() throws ErrorHandler {
        category.addCategory("shrimps");
        assertEquals("shrimps", category.getCategory(1));
    }

    @Test
    public void getCategorySize() throws ErrorHandler {
        assertEquals(2, category.size());
    }
}
