package cz.unicorn.tga.tractor.calculatorAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CalculatorForm {
    private String number;
    private final String evenNumber = "02468";

    public CalculatorForm(String number) {
        this.number= number;
    }
    public CalculatorForm(){};


}
