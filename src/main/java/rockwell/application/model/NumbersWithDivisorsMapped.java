package rockwell.application.model;

import java.util.LinkedList;
import java.util.List;

public class NumbersWithDivisorsMapped {
    private List<MappedDivisor> numbersWithDivisors;

    public NumbersWithDivisorsMapped(){
        numbersWithDivisors = new LinkedList<>();
    }
    public void addMap(MappedDivisor mappedDivisor) {
        numbersWithDivisors.add(mappedDivisor);
    }

    public List<MappedDivisor> getNumbersWithDivisors() {
        return numbersWithDivisors;
    }

    public void setNumbersWithDivisors(List<MappedDivisor> numbersWithDivisors) {
        this.numbersWithDivisors = numbersWithDivisors;
    }
}
