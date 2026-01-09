package linkedList;
import java.util.Scanner;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// User Node 
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

// Social Media Linked List 
class SocialMediaList {
    private UserNode head;

    // Add user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);

        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added successfully");
    }

    // Search user by ID
    private UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by name
    public void searchUserByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found");
    }

    // Add friend connection
    public void addFriend(int userId, int friendId) {
        UserNode user = findUserById(userId);
        UserNode friend = findUserById(friendId);

        if (user == null || friend == null) {
            System.out.println("User not found");
            return;
        }

        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;

        System.out.println("Friend added successfully");
    }

    // Remove friend connection
    public void removeFriend(int userId, int friendId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        FriendNode temp = user.friendHead;
        FriendNode prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Friend not found");
            return;
        }

        if (prev == null)
            user.friendHead = temp.next;
        else
            prev.next = temp.next;

        System.out.println("Friend removed successfully");
    }

    // Display friends of a user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendHead;

        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // Find mutual friends
    public void findMutualFriends(int user1, int user2) {
        UserNode u1 = findUserById(user1);
        UserNode u2 = findUserById(user2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");
        FriendNode f1 = u1.friendHead;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friendHead;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Friend ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends");
    }

    // Count friends for each user
    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;

            while (f != null) {
                count++;
                f = f.next;
            }

            System.out.println("User: " + temp.name + " | Friends: " + count);
            temp = temp.next;
        }
    }

    private void displayUser(UserNode u) {
        System.out.println("-----------------------");
        System.out.println("User ID: " + u.userId);
        System.out.println("Name: " + u.name);
        System.out.println("Age: " + u.age);
    }
}

public class SocialMediaFriend{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SocialMediaList list = new SocialMediaList();

        while (true) {
            System.out.println("\nSocial Media Friend System");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Display Friends");
            System.out.println("5. Search User by Name");
            System.out.println("6. Find Mutual Friends");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Age: ");
                    int age = input.nextInt();
                    list.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("User ID: ");
                    int u1 = input.nextInt();
                    System.out.print("Friend ID: ");
                    int f1 = input.nextInt();
                    list.addFriend(u1, f1);
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int u2 = input.nextInt();
                    System.out.print("Friend ID: ");
                    int f2 = input.nextInt();
                    list.removeFriend(u2, f2);
                    break;

                case 4:
                    System.out.print("User ID: ");
                    list.displayFriends(input.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Name: ");
                    list.searchUserByName(input.nextLine());
                    break;

                case 6:
                    System.out.print("First User ID: ");
                    int a = input.nextInt();
                    System.out.print("Second User ID: ");
                    int b = input.nextInt();
                    list.findMutualFriends(a, b);
                    break;

                case 7:
                    list.countFriends();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
