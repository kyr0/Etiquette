import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculator {

    @Test
    public void shouldAdd(){
        int sum = new CalculatorAbstract().getSum(20, 20);

        Assert.assertEquals(40, sum);
    }

    @Test
    public void shouldMultiply(){
        int multiplyresult = new CalculatorAbstract().getMultiplyresult(10, 20);

        Assert.assertEquals(200, multiplyresult);
    }

    @Test
    public void getLengthOfStringMethod(){
        int length = "Hello World".length() ;
        Assert.assertEquals(11, length);
    }

}
