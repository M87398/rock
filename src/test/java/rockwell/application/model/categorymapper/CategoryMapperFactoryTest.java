package rockwell.application.model.categorymapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import rockwell.application.exceptions.IncorrectCategoryException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryMapperFactoryTest {
    private static Stream<Arguments> mappers() {
        return Stream.of(
                Arguments.of("Animals", MapperType.ANIMALS.getCategoryMapper()),
                Arguments.of("Furniture", MapperType.FURNITURE.getCategoryMapper())
        );
    }

    @ParameterizedTest
    @MethodSource("mappers")
    void shouldGetMapper(String category, ICategoryMapper expected) {
        //given
        //when
        ICategoryMapper result = CategoryMapperFactory.getMapper(category);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldGetMapperThrowException() {
        //given
        String category = "notExistingCategory";

        //when
        Exception exception = assertThrows(IncorrectCategoryException.class, () -> {
            CategoryMapperFactory.getMapper(category);
        });
        String actualMessage = exception.getMessage();

        //then
        assertThat(actualMessage).isEqualTo("incorrect category: notExistingCategory");
    }
}