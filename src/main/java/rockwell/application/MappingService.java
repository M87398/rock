package rockwell.application;

import org.springframework.stereotype.Component;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.MappedDivisor;
import rockwell.application.model.NumbersWithDivisorsMapped;
import rockwell.application.model.categorymapper.CategoryMapperCreator;
import rockwell.application.model.categorymapper.ICategoryMapper;
import rockwell.application.util.DivisorsUtil;

import java.util.List;

@Component
public class MappingService implements IMapping{
    ICategoryMapper categoryMapper;
    @Override
    public NumbersWithDivisorsMapped process(CategoryWithNumbers categoryWithNumbers) {
        categoryMapper = CategoryMapperCreator.getMapper(categoryWithNumbers.getCategory());
        NumbersWithDivisorsMapped numbersWithDivisorsMapped= new NumbersWithDivisorsMapped();

        categoryWithNumbers.getNumbers().forEach(nr -> {

            List<Integer> allDivisors=DivisorsUtil.getAllDivsors(nr);
            List<String>  mappedDivisors=allDivisors.stream()
                    .map( divisor->categoryMapper.getMap().get(divisor))
                    .toList();
            MappedDivisor map = new MappedDivisor(nr,mappedDivisors);
            numbersWithDivisorsMapped.addMap(map);
        });

        return numbersWithDivisorsMapped;
    }
}
