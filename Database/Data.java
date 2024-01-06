package scholarship.Database;

import java.util.*;
import java.io.*;

class Data {

    /*
    *                                DATA STORED
    *
    *   file        -> ID. Username. Password. Name. Lastname
    *   teacherFile -> Status. Username. Password. Name. Lastname
    *   applicants  -> ID. Name. Lastname. Section. Batch. Scholarship
    *   scholars <- applicants: If an application is accepted, the applicant's data will be transferred to scholars.
    *
    * */
    static File  file = new File("DATA/usersData.dat");
    static File  teacherFile = new File("DATA/TeacherData.dat");
    static File  applicants = new File("DATA/Scholar-Applicants.dat");
    static File scholars = new File("DATA/Scholars.dat");


    /*
    *   Store Username, Password, Name, Lastname -> file
    *
    *   Create applicant File
    * */
    static void storeDataToFile (String username, String password, String name, String lastname){

        int id = generateRandom();

        try{
           FileWriter writer = new FileWriter(file, true);

           writer.write(id + "," + username + "," + password + "," + name + "," + lastname + "\n");

            applicants.createNewFile();

           writer.close();

        }catch ( IOException ignored ){}

    }

    // Store Username, Password, Name, Lastname -> teacherFile
    static void storeTeachersData (String username, String password, String name, String lastname){

        try{

            FileWriter writer = new FileWriter(teacherFile, true);

            writer.write("Teacher" + "," + username + "," + password + "," + name + "," + lastname + "\n");

            writer.close();

        }catch ( IOException ignored ){}

    }

    /*
    *                               Check filename
    *   student -> file check username if already exist in file return true
    *   teacher -> teacherFile check username if already exist in teacherFile return true
    *
    *   Scan file selected
    *   Store Data <- scan
    *   Data split it by delimiter store -> parts
    *   Check parts if equals username -> True : False
    *
    * */
    static boolean isExistUser (String username, String filename) {

        File files = switch (filename){

            case "student" -> file;
            case "teacher" -> teacherFile;
            default -> null;

        };

        try{
            Scanner scan = new Scanner(files);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username)) return true;

            }


        }catch (Exception ignored){}

        return false;
    }

    static boolean isExistUser (String username, String password, String filename) {

        File files = switch (filename){

            case "student" -> file;
            case "teacher" -> teacherFile;
            default -> null;

        };

        try{
            Scanner scan = new Scanner(files);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username) && parts[2].equals(password)) return true;

            }


        }catch (Exception ignored){}

        return false;
    }

    // Store Username, Name, Lastname, Section, Batch, Scholarship -> applicants
    static void scholarshipApplicants (String username, String name, String lastname, String section, String batch,  String scholarship){

        try{

            FileWriter writer = new FileWriter(applicants, true);

            writer.write(getStudentId(username) + "," + name + "," + lastname + "," + section + "," + batch + "," + scholarship + "\n");

            writer.close();

        }catch (Exception ignored){}

    }

    // Store list -> scholars
    static void acceptedScholars (String list){

        try{

            FileWriter writer = new FileWriter(scholars,true);

            writer.write(list + "\n");

            writer.close();

        }catch (Exception ignored){}

    }

    /*
    *               Update Applicant Data
    *   1. Transfer Data -> Scholar :Accept by Admin
    *   2. Data Deleted -> Decline by admin
    *
    * */
    static void updateFile(List<List<String>> data){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(applicants))) {
            for (List<String> list : data) {
                // Join the list elements without brackets and write to the file
                String line = String.join(",", list);
                writer.write(line + "\n");

            }
        } catch (Exception ignored) {}

    }


    static List<List<String>> listOfApplicants(String filename) {

        File files = switch (filename) {

            case "scholars" -> scholars;
            case "teachers" -> teacherFile;
            case "applicants" -> applicants;
            default -> null;

        };

        List<List<String>> data = new ArrayList<>();

        try {

            scholars.createNewFile();
            teacherFile.createNewFile();
            applicants.createNewFile();
            
            // Open the file for reading
            BufferedReader br = new BufferedReader(new FileReader(files));

            // Read each line from the file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into values using a comma as the delimiter
                String[] values = line.split(",");

                // Convert the array of values to a List and add it to the 2D ArrayList
                data.add(Arrays.asList(values));
            }

            // Close the BufferedReader
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    static List<List<String>> listOfScholarStudent(String gradeLevel, String section) {

        String concatenate = " " + gradeLevel + section;

        List<List<String>> data = new ArrayList<>();

        try {

            scholars.createNewFile();
            teacherFile.createNewFile();

            // Open the file for reading
            BufferedReader br = new BufferedReader(new FileReader(scholars));

            // Read each line from the file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into values using a comma as the delimiter
                String[] values = line.split(",");

                if(values[3].equals(concatenate)) {
                    data.add(Arrays.asList(values));
                }

            }

            // Close the BufferedReader
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    static String getStudentId(String username) {

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username)) return parts[0];

            }


        }catch (Exception ignored){}

        return "admin";

    }

    /*
    *   Generate Unique ID number Student 0 -> 9999
    *   Check ID if Exist generate new ID
    *
    * */
    static int generateRandom (){

        Random random = new Random();

        int id;

        id = random.nextInt(1000);

        if(checkIsExistId(id)) return id;
        else generateRandom();

        return 0;

    }

    static boolean checkIsExistId (int id){

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                String data = scan.nextLine();
                String[] parts = data.split(",");

                int convertString = Integer.parseInt(parts[0]);

                if(convertString == id) return false;

            }

        }catch (Exception ignored){}

        return true;

    }




}
