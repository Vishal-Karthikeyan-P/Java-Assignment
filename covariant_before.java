// Base classes
class Food {
    void eat() { System.out.println("Eating generic food..."); }
}

class Pizza extends Food {
    void slice() { System.out.println("Slicing the pizza into 8 pieces!"); }
}

// Parent Class
class Chef {

    //cook() method to be overridden
    public Food cook() { return new Food(); }
}

//Child Class
class PizzaChef extends Chef {
    
    // Must return 'Food' and not Pizza
    @Override
    public Food cook() { 
        return new Pizza(); 
    }
}

 class Main {
    public static void main(String[] args) {
        PizzaChef chef = new PizzaChef();
        // The pizzachef returns Food which is a pizza, but the result object is Food
        Food result = chef.cook(); 
        // We HAVE to manually cast it as Pizza inorder to slice it.
        ((Pizza) result).slice(); 
    }
}
