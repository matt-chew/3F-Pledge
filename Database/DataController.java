package Database;

public class DataController {

    public static void inputDataToFile (String username,  String password, String name, String lastname){

        Data.storeDatatoFile(username, password, name, lastname);

    }

    public static boolean isExistUser (String username) {

        return Data.isExistUser(username);

    }

    public static boolean isExistUser (String username, String password) {

        return Data.isExistUser(username, password);

    }

}
