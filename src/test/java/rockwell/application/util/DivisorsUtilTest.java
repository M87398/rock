package rockwell.application.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DivisorsUtilTest {

    private static Stream<Arguments> divsors() {
        return Stream.of(
                Arguments.of(1, List.of(1)),
                Arguments.of(2, List.of(1, 2)),
                Arguments.of(3, List.of(1, 3)),
                Arguments.of(4, List.of(1, 2, 4)),
                Arguments.of(9, List.of(1, 3, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("divsors")
    void getAllDivisors(Integer nr, List<Integer> expected) {
        //given
        //when
        var result = DivisorsUtil.getAllDivsors(nr);

        //then
        assertThat(result).isEqualTo(expected);

    }
}