import java.util.Date;

class Employee {
    private int id;
    private String name;
    private Date startDate;

    // Standard Constructor
    public Employee(int id, String name, Date startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    // Copy Constructor
    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        // DEEP COPY: Create a new Date object instead of copying the reference
        this.startDate = new Date(employee.startDate.getTime());
    }
    
    public void setStartDate(long time) { this.startDate.setTime(time); }
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Start Date: " + startDate;
    }
}

class Main_copy {
    public static void main(String[] args) {
        // 1. Create the original employee
        Date initialDate = new Date(); // Current time
        Employee emp1 = new Employee(101, "Alice", initialDate);

        // 2. Create a copy using the Copy Constructor
        Employee emp2 = new Employee(emp1);

        System.out.println("Original: " + emp1);
        System.out.println("Copy:     " + emp2);

        // 3. Prove it's a DEEP COPY
        // Change the date on the original only
        emp1.setStartDate(0); // Sets date to Jan 1, 1970

        System.out.println("\n--- After modifying Original's date ---");
        System.out.println("Original: " + emp1); // Changed
        System.out.println("Copy:     " + emp2); // Still has the original date!
    }
}
