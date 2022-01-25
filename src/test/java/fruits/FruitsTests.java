package fruits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FruitsTests {

    @Test
    public void shouldSegregateApples(){
        //1. Arrange
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Banana banana1 = new Banana();
        Banana banana2 = new Banana();

        Bowl mixedFruitBowl = new Bowl();
        mixedFruitBowl.addFruit(apple1, apple2, orange1, orange2, banana1, banana2);

        //2. Act
        Bowl bowlOfApples = mixedFruitBowl.getAllApplesBowl();

        //3. Assert
        Assert.assertEquals(bowlOfApples.getCount(), 2 );
    }
}
