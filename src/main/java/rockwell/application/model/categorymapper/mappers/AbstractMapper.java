package rockwell.application.model.categorymapper.mappers;

import rockwell.application.exceptions.IncorrectMapperKeyException;
import rockwell.application.model.categorymapper.ICategoryMapper;

import java.util.Map;

public class AbstractMapper implements ICategoryMapper {
    protected Map<Integer, String> map;

    @Override
    public String getMappedDivisor(Integer divisor) {
        if (!map.containsKey(divisor)) {
            throw new IncorrectMapperKeyException("The mapper does not contain key " + divisor);
        }
        return map.get(divisor);
    }
}
