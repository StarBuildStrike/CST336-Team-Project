import java.io.*;
import java.util.*;

public class patients {
     public static void main(String[] args) {

     ArrayList<String> firstNames = new ArrayList<String>();
     ArrayList<String> lastNames = new ArrayList<String>();
     ArrayList<String> cities = new ArrayList<String>();
     ArrayList<Integer> id = new ArrayList<Integer>();
     Scanner in = new Scanner(System.in);
     BufferedReader br = null;
     int i = 0;
     int c = 0;
     int age = 0;     
     int numberOfNames = 100;
     int f = 0;
     int m = 0;
     int l = 0;
     int idpos = 0;
     Random rand = new Random(System.nanoTime());

     
     if (args.length > 0) {
         try {
             numberOfNames = Integer.parseInt(args[0]);
         }catch (NumberFormatException e) {
             System.err.println("Argument" + args[0] + " must be an integer.");
             System.exit(1);
         }
     }


     try {
          String line;
          br = new BufferedReader(new FileReader("firstnames.txt"));
                     
          while((line = br.readLine()) != null) {
                firstNames.add(line);
          }
      } catch(IOException e) {
              System.out.println("File not found");
      }  
     try {
          String line;
          br = new BufferedReader(new FileReader("lastnames.txt"));
                     
          while((line = br.readLine()) != null) {
                lastNames.add(line);
          }
      } catch(IOException e) {
              System.out.println("File not found");
      }
      
     try {
          String line;
          br = new BufferedReader(new FileReader("cities.txt"));
                     
          while((line = br.readLine()) != null) {
                cities.add(line);
          }
      } catch(IOException e) {
              System.out.println("File not found");
      }
      
      //We need unique 8 digit patient IDs 
      for(int j = 0; j < (numberOfNames * 2); j++) {
          int tempId = j + rand.nextInt(80000000);
          tempId = tempId + 10000000;
          id.add(tempId);
      }

      Collections.shuffle(firstNames, new Random(System.nanoTime()));
      Collections.shuffle(lastNames, new Random(System.nanoTime()));
      Collections.shuffle(id, new Random(System.nanoTime()));
      
      System.out.println("CREATE TABLE patients(");
      System.out.println("   patient_id VARCHAR(8) NOT NULL PRIMARY KEY");
      System.out.println("  ,lastname   VARCHAR(30) NOT NULL");
      System.out.println("  ,firstname  VARCHAR(30) NOT NULL");
      System.out.println("  ,age        INTEGER  NOT NULL");
      System.out.println("  ,address    VARCHAR(100) NOT NULL");
      System.out.println(");");
            while(i < numberOfNames) {
           if(f >= firstNames.size()) {
                Collections.shuffle(firstNames, new Random(System.nanoTime()));
                f = 0;
           }
           if(l >= lastNames.size()) {
                Collections.shuffle(lastNames, new Random(System.nanoTime()));
                l = 0;
           }
           if(idpos >= id.size()) {
                Collections.shuffle(id, new Random(System.nanoTime()));
                idpos = 0;
           }
          
           age = rand.nextInt(98);
           age++; //We want an age from 1 - 99, not 0 - 98
           c = rand.nextInt(cities.size());
           System.out.println("INSERT INTO patients(patient_id,lastname,firstname,age,address) VALUES ('" + id.get(idpos) + "','" + lastNames.get(l) + "','" + firstNames.get(f) + "'," + age + ",'" + cities.get(c) + "');"); 
           //System.out.println(id.get(idpos) + " || " + lastNames.get(l) + " || " + firstNames.get(f) + " || " + age + " || " + cities.get(c));
           i++;
           idpos++;
           l++;
           f++;
      }
     }
 }