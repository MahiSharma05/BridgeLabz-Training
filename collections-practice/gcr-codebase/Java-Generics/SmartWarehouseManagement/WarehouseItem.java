package SmartWarehouseManagement;

public abstract class WarehouseItem {
	private String name;
	
public WarehouseItem(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public abstract void displayInfo();

}
