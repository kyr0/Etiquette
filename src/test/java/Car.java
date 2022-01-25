import java.util.List;

public class Car {
    private Engine engine;
    private List<Wheel> wheels;


    public Car() {
        engine = new Engine();
    }

    public void start(){
        System.out.println("Starting Car");
        engine.start();

    }

    private void stop(){

    }
}

