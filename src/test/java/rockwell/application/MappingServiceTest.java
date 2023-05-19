package rockwell.application;

import org.junit.jupiter.api.Test;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.MappedDivisor;
import rockwell.application.model.NumbersWithDivisorsMapped;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MappingServiceTest {

    @Test
    void shoudProcess() {
        //given
        MappingService mappingService=new MappingService();
        CategoryWithNumbers categoryWithNumbers = new CategoryWithNumbers();
        categoryWithNumbers.setCategory("Animals");
        categoryWithNumbers.setNumbers(List.of(1,4));
        List<MappedDivisor> mappedDivisorList = List.of( new MappedDivisor(1, List.of("Mouse")),
                new MappedDivisor(4, List.of("Mouse","Cat","Elephant")));

        //when
        NumbersWithDivisorsMapped result=mappingService.process(categoryWithNumbers);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getNumbersWithDivisors()).hasSameElementsAs(mappedDivisorList);
    }
}