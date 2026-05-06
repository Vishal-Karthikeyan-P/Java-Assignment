class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Student implements Cloneable {
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Method to demonstrate Shallow Copy
    public Student shallowCopy() throws CloneNotSupportedException {
        return (Student) super.clone(); 
    }

    // Method to demonstrate Deep Copy
    public Student deepCopy() {
        // Manually creating a new Student AND a new Address
        return new Student(this.name, new Address(this.address.city));
    }
}

class Main_shallow_deep {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address sharedAddr = new Address("New York");
        Student original = new Student("Alice", sharedAddr);

        // 1. PERFORM SHALLOW COPY
        Student shallowClone = original.shallowCopy();
        
        // 2. PERFORM DEEP COPY
        Student deepClone = original.deepCopy();

        // CHANGE THE ORIGINAL CITY
        original.address.city = "Los Angeles";

        System.out.println("--- AFTER CHANGING ORIGINAL CITY TO LA ---");
        System.out.println("Shallow Clone City: " + shallowClone.address.city); // Changes to LA!
        System.out.println("Deep Clone City:    " + deepClone.address.city);    // Stays New York!
    }
}
