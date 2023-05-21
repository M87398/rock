package rockwell.application.model;

import java.util.List;

public class CategoryWithNumbers {
    private String category;
    private List<Integer> numbers;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
