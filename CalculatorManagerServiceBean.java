package cz.unicorn.tga.tractor.calculatorAll;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author Eliška Chadimová
 */

@Service
@Transactional
public class CalculatorManagerServiceBean implements CalculatorService {

    public final static String REPLACE_8 = "16";
    public final static String REPLACE_9 = "18";

    /**
     * For cycle:
     * when String contains the numbers 0,1,2,3, => it moves one position to the right =>
     * the last number in the string does not move
     * when String contains a number 8 =>replace it with a number 16
     * when String contains a number 9 =>replace it with a number 18
     * when String contains a number 7 => delete a number 7
     * foreach:
     * counts event numbers => number from while cycle divide numberOfEvenNumbers
     *
     * @param calculatorForm of the CalculatorForm
     * @return String of number
     */

    public String countNumber(CalculatorForm calculatorForm) {
        String number = calculatorForm.getNumber().trim();
        String numberResult = "";
        int numberOfEvenNumbers = 0;
        int i;
        char valueOfChar;

        if(number==null){
            throw new NullPointerException ("Number is null");
        }

        for (i = number.toCharArray().length - 1; i > 0; i--) {
            valueOfChar = number.toCharArray()[i];

            if ((Character.getNumericValue(valueOfChar) <= 3) & (i != number.toCharArray().length - 1)) {
                number = number.substring(0, i) + number.substring((i + 1));
                number = number.substring(0, i + 1) + valueOfChar + number.substring(i + 1);
            }
            if (Character.getNumericValue(valueOfChar) == 7) {
                number = number.substring(0, i) + number.substring((i + 1));
            }
            if (Character.getNumericValue(valueOfChar) == 8) {
                number = number.substring(0, i) + REPLACE_8 + number.substring(i + 1);
            }
            if (Character.getNumericValue(valueOfChar) == 9) {
                number = number.substring(0, i) + REPLACE_9 + number.substring(i + 1);
            }
        }
        try {
            for (char c : number.toCharArray()) {
                if (calculatorForm.getEvenNumber().contains(String.valueOf(c))) {
                    numberOfEvenNumbers++;
                    int numberParse = Integer.parseInt(number.trim());
                    numberResult = String.valueOf(numberParse / numberOfEvenNumbers);
                }
            }
        } catch (NumberFormatException e) {
          throw new NumberFormatException("Number was entered incorrectly");
        }
        return numberResult;
    }
}
