package rockwell.application.model.categorymapper;

import rockwell.application.model.categorymapper.mappers.AnimalsMapper;
import rockwell.application.model.categorymapper.mappers.FurnitureMapper;

public enum MapperType {
    ANIMALS(new AnimalsMapper()),
    FURNITURE(new FurnitureMapper());

    private final ICategoryMapper categoryMapper;

    MapperType(ICategoryMapper mapper) {
        this.categoryMapper = mapper;
    }

    public ICategoryMapper getCategoryMapper() {
        return categoryMapper;
    }
}
