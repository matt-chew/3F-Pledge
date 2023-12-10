package Database;

import java.util.*;
import java.io.*;

class Data {

    static File  file = new File("usersData.dat");

    static void storeDataToFile (String username, String password, String name, String lastname){

        File studentPaymentData = new File(username + "-" + lastname + ".dat");

        try{
           FileWriter writer = new FileWriter(file, true);

           writer.write("1" + "," + username + "," + password + "," + name + "," + lastname + "," + username + "-" + lastname + ".dat" + "\n");

            studentPaymentData.createNewFile();

           writer.close();

        }catch ( IOException ignored ){}

    }

    static void inputPayment(String filename ,String name, String lastname, String amount, String date) {

        try{
            FileWriter writer  = new FileWriter (filename, true);

            writer.write(name + "," + lastname + "," + amount + "," + date + "\n");

            writer.close();

        }catch (Exception ignored) {}

    }

    static boolean isExistUser (String username) {

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username)) return true;

            }


        }catch (Exception ignored){}

        return false;
    }

    static boolean isExistUser (String username, String password) {

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username) && parts[2].equals(password)) return true;

            }


        }catch (Exception ignored){}

        return false;
    }

    static String getFileName (String username) {

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username)) return parts[5];

            }


        }catch (Exception ignored){}

        return "admin";
    }

    static List<List<String>> readDataFromFile(String filename) {

        List<List<String>> data = new ArrayList<>();

        try {
            // Open the file for reading
            BufferedReader br = new BufferedReader(new FileReader(filename));

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

    static double getTotalAmountPledge(String filename) {
        double sum = 0.00;

        File file = new File(filename);

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String getData = scan.nextLine();
                String[] parts = getData.split(",");

                // Check if the array has at least three elements
                if (parts.length >= 3) {
                    // Check if the third element is not empty
                    if (!parts[2].isEmpty()) {
                        double amount = Double.parseDouble(parts[2]);
                        sum += amount;
                    }
                }
            }
        } catch (Exception ignored) {}

        return sum;
    }

    static String getUserFullName (String username) {

        try{
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[1].equals(username)) return parts[3] + " " + parts[4];

            }


        }catch (Exception ignored){}

        return "admin";
    }

}
