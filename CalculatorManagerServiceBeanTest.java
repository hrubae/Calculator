package cz.unicorn.tga.tractor.CalculatorAll;

import cz.unicorn.tga.tractor.calculatorAll.CalculatorForm;
import cz.unicorn.tga.tractor.calculatorAll.CalculatorManagerServiceBean;
import cz.unicorn.tga.tractor.calculatorAll.CalculatorService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Eliška Chadimová
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CalculatorManagerServiceBean.class)
public class CalculatorManagerServiceBeanTest {

    CalculatorForm numberTest = new CalculatorForm("43256791");
    CalculatorForm numberIsNull = new CalculatorForm();
    CalculatorForm numberWithoutAnEvenNumber = new CalculatorForm("135");
    CalculatorForm numberIsEmpty = new CalculatorForm("");
    CalculatorForm numberIsTooLong = new CalculatorForm("36666669876");
    CalculatorForm numberIsWrong = new CalculatorForm("456yuj");


    @Autowired
    private CalculatorService service;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCountNumber() {
        assertEquals("43256791",numberTest.getNumber());
    }

    @Test
    public void testCountNumber1(){
        assertEquals("11331545",service.countNumber(numberTest));
    }

    @Test
    public void testCountNumberDivideZero(){
        assertEquals("",service.countNumber(numberWithoutAnEvenNumber));
    }

    @Test
    public void testCountNumberIsEmpty(){
        assertEquals("",service.countNumber(numberIsEmpty));
    }

    @Test(expected = NullPointerException.class)
    public void testCountNumberIsNull(){
        service.countNumber(numberIsNull);
    }

    @Test(expected = NumberFormatException.class)
    public void countNumberIsTooLongTest(){
        assertEquals("Number was entered incorrectly",service.countNumber(numberIsTooLong));
    }
    @Test(expected = NumberFormatException.class)
    public void countNumberIsWrong(){
        assertEquals("Number was entered incorrectly",service.countNumber(numberIsWrong));
    }


}
