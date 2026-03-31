package Annotations;

import java.util.ArrayList;

public class SuppressWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // ArrayList created WITHOUT generics
        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(100);      // mixed data types
        list.add(3.14);

        // Printing elements
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

