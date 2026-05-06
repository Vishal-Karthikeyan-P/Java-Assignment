
class CloneDemo implements Cloneable {
    // 1. Immutable 
    String name = "Test String"; 

    // 2. Final Field
    final int id = 101; 

    // 3. Transient Field 
    transient String temporaryKey = "SECRET_123"; 

    // 4. Static Variable (Shared at the class level)
    static int globalCounter = 0;

    @Override
    public Object clone() throws CloneNotSupportedException {
        globalCounter++; 
        return super.clone();
    }
}

 class Main_types {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo original = new CloneDemo();
        CloneDemo copy = (CloneDemo) original.clone();

        // Check 1: Immutable String
        System.out.println("Copy Name: " + copy.name);
        // Check 2: Final Field 
        //copy.id = 102; // COMPILER ERROR: Cannot assign a value to final variable

        // Check 3: Transient Field
        System.out.println("Copy Transient Key: " + copy.temporaryKey);
        // Check 4: Static Variable
        System.out.println("Global Counter: " + CloneDemo.globalCounter);
        CloneDemo copy2 = (CloneDemo) original.clone();
        System.out.println("Global Counter: " + CloneDemo.globalCounter);
    }
}
