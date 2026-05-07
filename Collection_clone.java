import java.util.ArrayList;

class Player implements Cloneable {
    String name;
    Player(String name) { this.name = name; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Main_Collection_Copy {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1. Create and Pre-populate the Original List
        ArrayList<Player> originalList = new ArrayList<>();
        originalList.add(new Player("Messi"));
        originalList.add(new Player("Ronaldo"));

        // 2. SHALLOW COPY: New list, but shares the same Player objects
        ArrayList<Player> shallowList = new ArrayList<>(originalList);

        // 3. DEEP COPY: New list AND brand new Player objects
        ArrayList<Player> deepList = new ArrayList<>();
        for (Player p : originalList) {
            deepList.add((Player) p.clone());
        }

        // 4. THE TEST: Change a player's name in the original list
        System.out.println("Changing 'Messi' to 'Pele' in originalList...\n");
        originalList.get(0).name = "Pele";

        // 5. PRINT RESULTS
        System.out.print("Original: ");
        printNames(originalList); // [Pele] [Ronaldo]

        System.out.print("Shallow:  ");
        printNames(shallowList);  // [Pele] [Ronaldo] -> Affected because Messi/Pele is shared
        
        System.out.print("Deep:     ");
        printNames(deepList);     // [Messi] [Ronaldo] -> Safe because it's a new object
    }

    public static void printNames(ArrayList<Player> list) {
        for (Player p : list) {
            System.out.print("[" + p.name + "] ");
        }
        System.out.println();
    }
}