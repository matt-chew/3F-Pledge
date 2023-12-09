package Database;

import java.util.*;
import java.io.*;

class Data {

    static File  file = new File("usersData.txt");

    static void storeDatatoFile (String username,  String password, String name, String lastname){

        try{
           FileWriter writer = new FileWriter(file, true);

           writer.write("1" + "," + username + "," + password + "," + name + "," + lastname + "\n");

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
