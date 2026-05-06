import java.io.*;
import java.util.Date;

class Employee implements Serializable {
    String name;
    Date startDate;

    Employee(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}

 class Main_serialization {
    // Generic method to deep copy any Serializable object
    public static <T extends Serializable> T deepCopy(T object) {
        try {
            // Write the object out to a byte array (Serialization)
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);

            // Read the object back from the byte array (Deserialization)
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        Employee original = new Employee("Bob", new Date());
        Employee copy = deepCopy(original);

        original.startDate.setTime(0); // Change original
        System.out.println("Original Date: " + original.startDate);
        System.out.println("Copy Date:     " + copy.startDate); // Remains unchanged!
    }
}
