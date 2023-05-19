package rockwell.application.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappedDivisor implements Serializable {
    private Map<Integer, List<String>> mappedDivisor;

    public MappedDivisor() {
    }
    public MappedDivisor(Integer key, List<String> mappings) {
        mappedDivisor = new HashMap<>();
        mappedDivisor.put(key,mappings);
    }

    public Map<Integer, List<String>> getMappedDivisor() {
        return mappedDivisor;
    }

    public void setMappedDivisor(Map<Integer, List<String>> mappedDivisor) {
        this.mappedDivisor = mappedDivisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MappedDivisor)) return false;

        MappedDivisor that = (MappedDivisor) o;

        return getMappedDivisor().equals(that.getMappedDivisor());
    }

    @Override
    public int hashCode() {
        return getMappedDivisor().hashCode();
    }
}
