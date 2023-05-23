package rockwell.application;

import org.junit.jupiter.api.Test;
import rockwell.application.exceptions.IncorrectMapperKeyException;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.MappedDivisor;
import rockwell.application.model.NumbersWithDivisorsMapped;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MappingServiceTest {

    @Test
    void shouldProcess() {
        //given
        MappingService mappingService = new MappingService();
        CategoryWithNumbers categoryWithNumbers = new CategoryWithNumbers();
        categoryWithNumbers.setCategory("Animals");
        categoryWithNumbers.setNumbers(List.of(1, 4));
        List<MappedDivisor> mappedDivisorList = List.of(new MappedDivisor(1, List.of("Mouse")),
                new MappedDivisor(4, List.of("Mouse", "Cat", "Elephant")));

        //when
        NumbersWithDivisorsMapped result = mappingService.process(categoryWithNumbers);

        //then
        assertThat(result.getNumbersWithDivisors()).hasSameElementsAs(mappedDivisorList);
    }

    @Test
    void shouldThrowExceptionWhenIncorrectMapperKey() {
        //given
        MappingService mappingService = new MappingService();
        CategoryWithNumbers categoryWithNumbers = new CategoryWithNumbers();
        categoryWithNumbers.setCategory("Animals");
        categoryWithNumbers.setNumbers(List.of(-1));
        List<MappedDivisor> mappedDivisorList = List.of(new MappedDivisor(1, List.of("Mouse")),
                new MappedDivisor(4, List.of("Mouse", "Cat", "Elephant")));

        //when
        Exception exception = assertThrows(IncorrectMapperKeyException.class, () -> {
            mappingService.process(categoryWithNumbers);
        });
        String actualMessage = exception.getMessage();

        //then
        assertThat(actualMessage).isEqualTo("The mapper does not contain key -1");
    }
}