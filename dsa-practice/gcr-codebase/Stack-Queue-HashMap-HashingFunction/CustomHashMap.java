package DsaProblems;

public class CustomHashMap {

    static class HashMap {

        // Linked List Node
        static class Entry {
            int key;
            int value;
            Entry next;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        private final int CAPACITY = 10;
        private Entry[] table;

        // Constructor
        public HashMap() {
            table = new Entry[CAPACITY];
        }

        // Hash function
        private int hash(int key) {
            return Math.abs(key) % CAPACITY;
        }

        //Insert 
        public void put(int key, int value) {
            int index = hash(key);
            Entry head = table[index];

            Entry current = head;
            while (current != null) {
                if (current.key == key) {
                    current.value = value; 
                    return;
                }
                current = current.next;
            }

            // Insert at beginning
            Entry newNode = new Entry(key, value);
            newNode.next = head;
            table[index] = newNode;
        }

        // retrieve
        public Integer get(int key) {
            int index = hash(key);
            Entry current = table[index];

            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }

        // remove
        public void remove(int key) {
            int index = hash(key);
            Entry current = table[index];
            Entry prev = null;

            while (current != null) {
                if (current.key == key) {
                    if (prev == null) {
                        table[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        HashMap map = new HashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 120); 

        System.out.println("Key 1: " + map.get(1));   
        System.out.println("Key 2: " + map.get(2));   
        System.out.println("Key 12: " + map.get(12)); 

        map.remove(2);
        System.out.println("Key 2 after removal: " + map.get(2)); // null
    }
}
