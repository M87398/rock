package rockwell.application.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappedDivisor implements Serializable {
    private Map<Integer, List<String>> divisorsMap;

    public MappedDivisor() {
    }
    public MappedDivisor(Integer key, List<String> mappings) {
        divisorsMap = new HashMap<>();
        divisorsMap.put(key,mappings);
    }

    public Map<Integer, List<String>> getDivisorsMap() {
        return divisorsMap;
    }

    public void setDivisorsMap(Map<Integer, List<String>> divisorsMap) {
        this.divisorsMap = divisorsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MappedDivisor)) return false;

        MappedDivisor that = (MappedDivisor) o;

        return getDivisorsMap().equals(that.getDivisorsMap());
    }

    @Override
    public int hashCode() {
        return getDivisorsMap().hashCode();
    }
}
