package rockwell.application.model.categorymapper;

import rockwell.application.ICategoryMapper;

import java.util.Map;

public class CategoryMapperFactory {//todo zamienic na bazę H2 i wczytać sql'a
    private CategoryMapperFactory(){
        throw new IllegalStateException();
    }

    public static ICategoryMapper getAnimals() {
        return () -> Map.of(1, "Mouse",
                2, "Cat",
                3, "Dog",
                4, "Elephant");
    }

    public static ICategoryMapper getFurniture() {
        return () -> Map.of(1, "Chair",
                2, "Table",
                3, "Cabinet",
                4, "Bed");
    }

    public static ICategoryMapper getMapper(String category) {
        return switch (category.toLowerCase()) {
            case "animals" -> getAnimals();
            case "furniture" -> getFurniture();
            default -> throw new IncorrectCategoryException("incorrect category: " + category);
        };
    }
}
