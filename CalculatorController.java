package cz.unicorn.tga.tractor.calculatorAll;

import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CalculatorController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)


public class CalculatorController {
    public static final String BASE_URL = CommonConstants.SLASH + "calculator";


    @Autowired
    private CalculatorService service;

    @PostMapping(path = "/number")
    public String countNumber (@RequestBody CalculatorForm calculatorForm){return service.countNumber(calculatorForm);

    }
}
