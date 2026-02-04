package FunctionalInterfaces;

interface ReportExporter {

    // Existing abstract methods
    void exportToCSV();
    void exportToPDF();

    // New feature added later
    default void exportToJSON() {
        System.out.println("Exporting report in JSON format (default implementation).");
    }
}

// Existing implementation (no change needed)
class SalesReportExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Sales report exported as CSV.");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Sales report exported as PDF.");
    }
}

// Another implementation
class InventoryReportExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Inventory report exported as CSV.");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Inventory report exported as PDF.");
    }
}

public class ReportExportApp {

    public static void main(String[] args) {

        ReportExporter sales = new SalesReportExporter();
        sales.exportToCSV();
        sales.exportToPDF();
        sales.exportToJSON();   

        ReportExporter inventory = new InventoryReportExporter();
        inventory.exportToCSV();
        inventory.exportToPDF();
        inventory.exportToJSON();
    }
}
