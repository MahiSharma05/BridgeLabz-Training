package browserbuddy;

import java.util.Stack;

public class ClosedTabStack {

    private Stack<String> closedTabs = new Stack<>();

    // Close tab
    public void closeTab(String url) {
        closedTabs.push(url);
        System.out.println("Tab closed: " + url);
    }

    // Restore tab
    public String restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore.");
            return null;
        }
        return closedTabs.pop();
    }
}
