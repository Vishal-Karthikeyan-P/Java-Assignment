class Food {
    void eat() { System.out.println("Eating generic food..."); }
}

class Pizza extends Food {
    void slice() { System.out.println("Slicing the pizza into 8 pieces!"); }
}

// Parent class
class Chef {
    public Food cook() { return new Food(); }
}

//Child class
class PizzaChef extends Chef {
    //More specific type Pizza, overrides cook() with Pizza return type
    @Override
    public Pizza cook() { 
        return new Pizza();
    }
}

public class Main {
    public static void main(String[] args) {
        PizzaChef chef = new PizzaChef();
        
        // Now it can be assigned to a Pizza object and can be sliced without casting.
        Pizza myPizza = chef.cook(); 
        myPizza.slice();
    }
}
