package rockwell.application.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rockwell.application.IMapping;
import rockwell.application.MappingService;
import rockwell.application.model.CategoryWithNumbers;
import rockwell.application.model.NumbersWithDivisorsMapped;

@RestController
public class NumbersController {

    private final IMapping mappingService;

    public NumbersController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @GetMapping("/divisors")
    public NumbersWithDivisorsMapped getDivisors(@RequestBody CategoryWithNumbers categoryWithNumbers){

        return mappingService.process(categoryWithNumbers);
    }
}
