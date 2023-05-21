package rockwell.application.model.categorymapper.mappers;

import rockwell.application.model.categorymapper.ICategoryMapper;

import java.util.Map;

public class AnimalsMapper implements ICategoryMapper {
    @Override
    public Map<Integer, String> getMap() {
        return Map.of(1, "Mouse",
                2, "Cat",
                3, "Dog",
                4, "Elephant");
    }

}
