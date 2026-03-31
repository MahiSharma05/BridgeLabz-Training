package SmartWarehouseManagement;
import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();
	
	// Add items
	public void addItems(T item) {
		items.add(item);
		System.out.println("Item Added: " + item.getName());
	}
	
	// Get all Items
	public List<T> getItems() {
		return items;
	}
	
	//  Wildcard method
	public static void displayAll(List< ? extends WarehouseItem> list) {
		for(WarehouseItem item : list) {
			item.displayInfo();
		}
	}

}
