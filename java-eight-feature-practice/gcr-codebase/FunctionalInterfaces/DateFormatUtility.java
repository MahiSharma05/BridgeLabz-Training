package FunctionalInterfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateFormatUtility {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = input.nextLine();

        // convert String to LocalDate
        LocalDate invoiceDate = LocalDate.parse(dateInput);

        // Format date in multiple formats
        System.out.println("dd-MM-yyyy : " + DateUtils.formatDate(invoiceDate, "dd-MM-yyyy"));

        System.out.println("MM/dd/yyyy : " + DateUtils.formatDate(invoiceDate, "MM/dd/yyyy"));

        System.out.println("yyyy MMM dd : " +DateUtils.formatDate(invoiceDate, "yyyy MMM dd"));

        input.close();
    }
}
