package rockwell.application.model.categorymapper.mappers;

import java.util.Map;

public class FurnitureMapper extends AbstractMapper {

    public FurnitureMapper() {
        map = Map.of(1, "Chair",
                2, "Table",
                3, "Cabinet",
                4, "Bed");
    }
}
