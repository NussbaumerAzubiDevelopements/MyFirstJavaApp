import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * pretty printer / beautify code strg + alt + l
 * intelli sense / help functions strg + space
 * assistances function create method Alt +  Enter
 * */

public class JavaStrings {
    public static void main(String[] args) {
        Persons a = new Persons();
        Persons b = new Persons();
        Persons c = new Persons();
        Persons d = c;
        List<Persons> listPeople = new ArrayList<>();
        listPeople.add(a);
        listPeople.add(b);
        listPeople.add(c);
        listPeople.add(d);
        System.out.println("Hello");
        myFirstMethod();
    }

    private static void myFirstMethod() {
        System.out.println("Hello");
    }
}
