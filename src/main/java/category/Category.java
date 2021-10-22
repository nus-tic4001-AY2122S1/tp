package category;

import java.util.ArrayList;

/**
 * Serve as a store for saving user command.
 */
public class Category {
    private static final ArrayList<String> list = new ArrayList<>();
    private static Category category = null;

    public static Category getInstance() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }

    /**
     * Returns a Singleton for categories.
     *
     */
    public ArrayList<String> getList() {
        return list;
    }

    /**
     * Add a category to the list.
     * @param category is a String that can be any String value.
     */
    public void addCategory(String category) {
        list.add(category);
    }

    /**
     * Deletes a category from the category list.
     *
     * @param num The index of a category that is required to be removed from the category list.
     */
    public void deleteCategory(int num) {
        list.remove(num);
    }

    /**
     * Returns the category from the specified index from the category list.
     *
     * @param num The index the category.
     * @return int The category at the specified index.
     */
    public String getCategory(int num) {
        return list.get(num);
    }

    /**
     * Returns the size of the current category list.
     *
     * @return int The size of the current category list.
     */
    public int size() {
        return list.size();
    }
}

