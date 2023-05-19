package rockwell.application;

import org.springframework.stereotype.Component;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.MappedDivisor;
import rockwell.application.model.NumbersWithDivisorsMapped;
import rockwell.application.model.categorymapper.CategoryMapperFactory;
import rockwell.application.util.DivisorsUtil;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MappingService implements IMapping{
    ICategoryMapper categoryMapper;
    @Override
    public NumbersWithDivisorsMapped process(CategoryWithNumbers categoryWithNumbers) {
        categoryMapper = CategoryMapperFactory.getMapper(categoryWithNumbers.getCategory());
        NumbersWithDivisorsMapped numbersWithDivisorsMapped= new NumbersWithDivisorsMapped();

        categoryWithNumbers.getNumbers().forEach(nr -> {

            List<Integer> allDivisors=DivisorsUtil.getAllDivsors(nr);
            List<String>  mappedDivisors=allDivisors.stream()
                    .map( divisor->categoryMapper.getMap().get(divisor))
                    .collect(Collectors.toList());
            MappedDivisor map = new MappedDivisor(nr,mappedDivisors);
            numbersWithDivisorsMapped.addMap(map);
        });

        return numbersWithDivisorsMapped;
    }
}
