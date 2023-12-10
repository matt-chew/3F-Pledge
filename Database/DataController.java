package Database;

import java.util.List;

public class DataController {

    public static void inputDataToFile (String username,  String password, String name, String lastname){

        Data.storeDataToFile(username, password, name, lastname);

    }

    public static boolean isExistUser (String username) {

        return Data.isExistUser(username);

    }

    public static boolean isExistUser (String username, String password) {

        return Data.isExistUser(username, password);

    }

    public static void inputPayment(String filename ,String name, String lastname, String amount, String date) {

        Data.inputPayment(filename, name, lastname, amount, date);

    }

    public static String getFile (String username) {

        return Data.getFileName(username);

    }


    public static List<List<String>> readDataFromFile(String filename) {

        return Data.readDataFromFile( filename );

    }


    public static double getTotalAmountPledge (String filename) {

        return Data.getTotalAmountPledge(filename);

    }

    public static String getUserFullName (String username) {

        return Data.getUserFullName( username );

    }

}
