package SmartWarehouseManagement;

public class WarehouseApp {

	public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        
        // Electronics items added
        electronicsStorage.addItems(new Electronics("Laptop"));
        electronicsStorage.addItems(new Electronics("Tablet"));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        
        // Groceries items added
        groceriesStorage.addItems(new Groceries("Rice"));
        groceriesStorage.addItems(new Groceries("Milk"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        
        // Furniture Items added
        furnitureStorage.addItems(new Furniture("Chair"));
        furnitureStorage.addItems(new Furniture("table"));

        System.out.println(" Electronics Storage ");
        Storage.displayAll(electronicsStorage.getItems());

        System.out.println(" Groceries Storage ");
        Storage.displayAll(groceriesStorage.getItems());

        System.out.println(" Furniture Storage ");
        Storage.displayAll(furnitureStorage.getItems());

	}

}
