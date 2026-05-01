import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("testing Hash Table\n");
        testHashTable();
        System.out.println("\ntesting BST\n");
        testBST();
    }
    static void testHashTable() {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(10);
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(1000);
            String name = "person" + rand.nextInt(100);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("student" + i, i);
            table.put(key, value);
        }

        System.out.println("total elements: " + table.getSize());
        System.out.println("\nbucket distribution:");
        table.printBucketSizes();
    }

    static void testBST() {
        BST<Integer, String> tree = new BST<>();

        System.out.println("inserting elements...");
        tree.put(50, "apple");
        tree.put(30, "banana");
        tree.put(70, "cherry");
        tree.put(20, "date");
        tree.put(40, "elderberry");
        tree.put(60, "fig");
        tree.put(80, "grape");

        System.out.println("tree size: " + tree.size());

        System.out.println("\nget key 30: " + tree.get(30));
        System.out.println("get key 100: " + tree.get(100));

        System.out.println("\nin-order traversal");
        for (var entry : tree.iterator()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        System.out.println("\ndeleting key 30...");
        tree.delete(30);
        System.out.println("new size: " + tree.size());

        System.out.println("\nafter deletion");
        for (var entry : tree.iterator()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        System.out.println("\ninserting more elements...");
        tree.put(35, "honeydew");
        tree.put(45, "kiwi");

        System.out.println("final tree (size: " + tree.size() + "):");
        for (var entry : tree.iterator()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }
}