class Coffee implements Cloneable {
    String type;
    Coffee(String type) {
        this.type = type;
    }
    //Must override and change to public to use in main method
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Original object : Order 1
        Coffee Order1 = new Coffee("Latte");
        // Create the clone : Order 2
        Coffee Order2 = (Coffee) Order1.clone();//Typecasted since clone() returns Object object.

        System.out.println("Order 1: " + Order1.type);
        System.out.println("Order 2: " + Order2.type);
        
        // Prove they are independent
        Order2.type = "Mocha";
        System.out.println("\nAfter changing Order 2...");
        System.out.println("Order 1: " + Order1.type);
        System.out.println("Order 2: " + Order2.type);
    }
}
