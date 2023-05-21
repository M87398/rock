package rockwell.application.model.categorymapper;

import rockwell.application.exceptions.IncorrectCategoryException;

public class CategoryMapperFactory {
    private CategoryMapperFactory(){
        throw new IllegalStateException();
    }

    public static ICategoryMapper getMapper(String category) {
        try {
            return MapperType.valueOf(category.toUpperCase()).getCategoryMapper();
        }catch (IllegalArgumentException ex){
            throw new IncorrectCategoryException("incorrect category: " + category);
        }
    }
}
