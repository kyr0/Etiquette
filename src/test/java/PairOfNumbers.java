import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PairOfNumbers {

    int arr[]= {1, 2, -1, -2, 4, 5, -9, 0, 10, 40};
    int key = 4;

    @Test
    public void findPairOfNumbers() {

        //Arrange
        int[] arr = {1, 2, -1, -2, 4, 5, -9, 0, 10, 40};
        int key = 4;
        List<String> suggestedOutput = new ArrayList<>();
        suggestedOutput.add("{1,4}");
        suggestedOutput.add("{2,-2}");
        suggestedOutput.add("{-1,5}");
        suggestedOutput.add("{4,0}");
        suggestedOutput.add("{10,40}");


        //Act
        List<Integer> actualResult = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int[] arr1 = new int[]{i, j};
                if(new CalculatorAbstract().getSum(arr[i],arr[j]) == key){
                    actualResult.add();
                }
                else if(new CalculatorAbstract().getSubtraction(arr[i],arr[j]) == key){
                    actualResult.add();
                }
                else if(new CalculatorAbstract().getMultiplyresult(arr[i],arr[j]) == key){
                    actualResult.add();
                }
                else if(new CalculatorAbstract().getDivision(arr[i],arr[j]) == (float)key){
                    actualResult.add();
                }
            }

        }
        //Assert
        int i=0;
        for (String expected : suggestedOutput){
            System.out.println(expected);
            Assert.assertEquals(actualResult.get(i++),expected);

}

