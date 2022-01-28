import org.testng.annotations.Test;

public class CalculatorAbstract {

    public int getMultiplyresult(int number1, int number2) {
        int multiplyresult= number1 * number2;
        return multiplyresult;
    }

    public int getSum(int number1, int number2) {
        int sum= number1 + number2;
        return sum;
    }
    public int getSubtraction(int number1, int number2) {
        int subtractionresult= number1 - number2;
        return subtractionresult;
    }

    public float getDivision(int number1, int number2) {
        int divisionresult= number1 / number2;
        return divisionresult;
    }

    public String getPair(int a, int b){
        String pair= "{"  a  ","  b  "}"
        return "{"  a  ","  b  "}";
    }

    @Test
    public void test(){
        System.out.println(getPair(1,2));
    }


}
