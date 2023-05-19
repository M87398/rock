package rockwell.application;

import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.NumbersWithDivisorsMapped;

public interface IMapping {
    NumbersWithDivisorsMapped process(CategoryWithNumbers categoryWithNumbers);
}
