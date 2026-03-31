// LeetCode 1108 – Defanging an IP Address.

package leetCode;

public class DefangIPAddress {

	public static void main(String[] args) {
		String ip = "1.1.1.1";

        String defangedIP = defangIPaddr(ip);

        System.out.println("Original IP Address: " + ip);
        System.out.println("Defanged IP Address: " + defangedIP);

	}
	public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
