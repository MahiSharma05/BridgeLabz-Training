package Regex;

public class IPAddressValidate {

    // validate IPv4 address
    public static boolean isValidIPv4(String ip) {

        String regex ="^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +"(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        return ip.matches(regex);
    }

    public static void main(String[] args) {

        String[] testIPs = {"192.168.1.1", "255.255.255.255", "0.0.0.0", "256.10.10.10","192.168.1"};

        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
