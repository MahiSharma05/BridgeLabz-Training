package inheritance;

public class RestaurantManagementSystem {

    // Superclass
    static class Person {
        String name;
        int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void displayPerson() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
        }
    }

    // Interface
    interface Worker {
        void performDuties();
    }

    // Chef subclass
    static class Chef extends Person implements Worker {

        Chef(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Role: Chef");
            System.out.println("Duties: Cooking food and managing kitchen.");
        }
    }

    // Waiter subclass
    static class Waiter extends Person implements Worker {

        Waiter(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Role: Waiter");
            System.out.println("Duties: Serving food and assisting customers.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Person chef = new Chef("Mahi", 101);
        Person waiter = new Waiter("Mansi", 102);

        chef.displayPerson();
        ((Worker) chef).performDuties();

        System.out.println();

        waiter.displayPerson();
        ((Worker) waiter).performDuties();
    }
}

