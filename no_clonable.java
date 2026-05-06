class SecretDocument {
    String content = "Top Secret Data";
    // We are overriding the clone method to make it accessible
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // But it will throw an exception because the class is not 'Cloneable'
        return super.clone(); 
    }
}
class Main_no_cloneable {
    public static void main(String[] args) {
        SecretDocument doc1 = new SecretDocument();
        
        try {
            System.out.println("Attempting to clone the document...");
            SecretDocument doc2 = (SecretDocument) doc1.clone();
            System.out.println("Clone successful!");
        } catch (CloneNotSupportedException e) {
            System.out.println("\n--- ERROR DETECTED ---");
            System.out.println("Reason: " + e.toString());
            System.out.println("Fix: You must add 'implements Cloneable' to the class.");
        }
    }
}
