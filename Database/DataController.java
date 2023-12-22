package scholarship.Database;

import java.util.List;

public class DataController {

    public static void inputDataToFile (String username,  String password, String name, String lastname){

        Data.storeDataToFile(username, password, name, lastname);

    }

    public static void inputTeachersData (String username, String password, String name, String lastname){

        Data.storeTeachersData(username, password, name, lastname);

    }

    public static void scholarshipApplicants (String username, String name, String lastname, String section, String batch,  String scholarship) {

        Data.scholarshipApplicants(username, name, lastname, section, batch, scholarship);

    }

    public static boolean isExistUser (String username, String file) {

        return Data.isExistUser(username, file);

    }

    public static boolean isExistUser (String username, String password, String file) {

        return Data.isExistUser(username, password, file);

    }

    public static List<List<String>> listOfApplicants(String file) {

        return Data.listOfApplicants(file);

    }

    public static List<List<String>> listOfScholarStudent(String gradeLevel, String section) {

        return Data.listOfScholarStudent(gradeLevel, section);

    }

    public static void acceptedScholars(String name){

        Data.acceptedScholars(name);

    }

    public static void updateFile(List<List<String>> data){

        Data.updateFile(data);

    }




    public static double getTotalAmountPledge (String filename) {

        return Data.getTotalAmountPledge(filename);

    }

    public static String getFileName (String username) {

        return Data.getFileName(username);

    }

}
