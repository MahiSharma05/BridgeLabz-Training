package browserbuddy;

public class BrowserTab {

    private HistoryNode head;
    private HistoryNode current;

    // Visit new page
    public void visitPage(String url) {

        HistoryNode newNode = new HistoryNode(url);

        if (head == null) {
            head = current = newNode;
            return;
        }

        // Clear forward history
        current.next = null;

        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }

    // Go back
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    // Go forward
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    // Display current page
    public void displayCurrentPage() {
        if (current == null) {
            System.out.println("No page opened.");
        } else {
            System.out.println("Current Page: " + current.url);
        }
    }
}
