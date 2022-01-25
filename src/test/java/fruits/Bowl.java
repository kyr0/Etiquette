package fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bowl {
    private List<Fruit> fruitsList;
    private ShapeOfBowl shape;

    public Bowl() {
        fruitsList = new ArrayList<>( );
    }

//    public void addFruit(Fruit fruit) {
//        fruits.add(fruit);
//    }
    public void addFruit(Fruit... fruit) {
        for (Fruit fruit1 : fruit) {
            fruitsList.add(fruit1);
        }
    }
    

    public Bowl getAllApplesBowl() {
        //1. Need to go thru all fruits
        //2. Segregate all apples
        //3. Create a new bowl and add all apples from step 2
        //4. Return the new apple bowl

        Bowl bowlOfApples = new Bowl();

        for (Fruit fruit : fruitsList) {
            if (fruit instanceof Apple){
                bowlOfApples.addFruit(fruit);
            }
        }
        return bowlOfApples;
    }

    public int getCount() {
        return fruitsList.size();
    }

//    private Bowl getAllOrangesBowl() {
//    }
//
//    private Bowl getAllBananasBowl() {
//    }


}
