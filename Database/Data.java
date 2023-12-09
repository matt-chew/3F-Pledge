package Database;

import java.util.*;
import java.io.*;

class Data {

    static File  file = new File("usersData.dat");

    static void storeDataToFile (String username,  String password, String name, String lastname){

        File studentPaymentData = new File(username + " by " + lastname + ".txt");

        try{
           FileWriter writer = new FileWriter(file, true);

           writer.write("1" + "," + username + "," + password + "," + name + "," + lastname + "," + username + " by " + lastname + ".txt" + "\n");

            studentPaymentData.createNewFile();

           writer.close();

        }catch ( IOException ignored ){}

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



}
