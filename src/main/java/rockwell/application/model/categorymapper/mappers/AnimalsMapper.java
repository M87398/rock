package rockwell.application.model.categorymapper.mappers;

import java.util.Map;

public class AnimalsMapper extends AbstractMapper {
    public AnimalsMapper() {
        map = Map.of(1, "Mouse",
                2, "Cat",
                3, "Dog",
                4, "Elephant");
    }
}
