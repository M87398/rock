package rockwell.application.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import rockwell.application.IMapping;
import rockwell.application.MappingService;
import rockwell.application.exceptions.IncorrectCategoryException;
import rockwell.application.exceptions.IncorrectMapperKeyException;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.NumbersWithDivisorsMapped;

@RestController
public class NumbersController {

    private final IMapping mappingService;

    public NumbersController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @GetMapping("/divisors")
    public NumbersWithDivisorsMapped getDivisors(@RequestBody CategoryWithNumbers categoryWithNumbers) {
        try {
            return mappingService.process(categoryWithNumbers);
        } catch (IncorrectCategoryException | IncorrectMapperKeyException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
    }
}
