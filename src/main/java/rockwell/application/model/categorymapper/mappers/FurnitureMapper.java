package rockwell.application.model.categorymapper.mappers;

import rockwell.application.model.categorymapper.ICategoryMapper;

import java.util.Map;

public class FurnitureMapper implements ICategoryMapper {
    @Override
    public Map<Integer, String> getMap() {
        return Map.of(1, "Chair",
                2, "Table",
                3, "Cabinet",
                4, "Bed");
    }

}
