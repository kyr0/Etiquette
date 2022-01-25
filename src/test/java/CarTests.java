import org.testng.annotations.Test;

public class CarTests {

    @Test
    public void shouldStartCar(){
        new Car().start();
    }
}
