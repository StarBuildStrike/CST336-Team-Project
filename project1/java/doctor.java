import java.io.*;
import java.util.*;

public class doctor {
     public static void main(String[] args) {

     ArrayList<String> firstNames = new ArrayList<String>();
     ArrayList<String> lastNames = new ArrayList<String>();
     ArrayList<String> specialties = new ArrayList<String>();
     ArrayList<Integer> id = new ArrayList<Integer>();
     Scanner in = new Scanner(System.in);
     BufferedReader br = null;
     int i = 0;
     int s = 0;
     int exp = 0;     
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
          br = new BufferedReader(new FileReader("specialties.txt"));
                     
          while((line = br.readLine()) != null) {
                specialties.add(line);
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
      
      System.out.println("CREATE TABLE doctors(");
      System.out.println("   doctor_id VARCHAR(8) NOT NULL PRIMARY KEY");
      System.out.println("  ,lastname   VARCHAR(30) NOT NULL");
      System.out.println("  ,firstname  VARCHAR(30) NOT NULL");
      System.out.println("  ,years_of_exp numeric(4,0) check (years_of_exp>0 and Years_of_exp<100)");
      System.out.println("  ,specialty    VARCHAR(100) NOT NULL");
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
          
           exp = rand.nextInt(98);
           exp++; //We want an age from 1 - 99, not 0 - 98
           s = rand.nextInt(specialties.size());
           System.out.println("INSERT INTO doctors(doctor_id,lastname,firstname,years_of_exp,specialty) VALUES ('" + id.get(idpos) + "','" + lastNames.get(l) + "','" + firstNames.get(f) + "'," + exp + ",'" + specialties.get(s) + "');"); 
           //System.out.println(id.get(idpos) + " || " + lastNames.get(l) + " || " + firstNames.get(f) + " || " + age + " || " + cities.get(c));
           i++;
           idpos++;
           l++;
           f++;
      }
     }
 }