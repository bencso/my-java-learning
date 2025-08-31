import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static ArrayList<Grandprix> grandprixes = new ArrayList<>();

    public static void main(String[] args) {
        FileWriter();
        GrandPrixCount();
        HungarianPrix();
        ErrorList();
    }

    public static void ErrorList(){
        System.out.println("5. feladat: Hibastatisztika");
        HashMap<String, Integer> stats = new HashMap<>();
        for(Grandprix grandprix: grandprixes) {
            if(!grandprix.getStatus().isEmpty() && grandprix.getPosition() == 0) {
                if(!stats.containsKey(grandprix.getStatus())){
                    stats.put(grandprix.getStatus(), 1);
                } else {
                    stats.merge(grandprix.getStatus(), 1, Integer::sum);
                }
            }
        }

        for(String error : stats.keySet()){
            if(2 < stats.get(error) ){
                System.out.println(error+": "+stats.get(error));
            }
        }
    }

    public static void HungarianPrix(){
        System.out.println("4. feladat: Magyar nagydíj helyezései");
        for(Grandprix grandprix : grandprixes){
            if(grandprix.getName().equals("Hungarian Grand Prix") && grandprix.getPosition() != 0){
                System.out.print("\t"+grandprix.getDate() + ": " + grandprix.getPosition() + ". hely"+"\n");
            }
        }
    }

    public static void GrandPrixCount() {
        System.out.println("3. feladat: " + grandprixes.size());
    }

    public static void FileWriter() {
        File file = new File("src/schumacher.csv");


        try {
            Scanner fileReader = new Scanner(file);
        fileReader.nextLine();
        while (fileReader.hasNextLine()) grandprixes.add(new Grandprix(fileReader.nextLine()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
