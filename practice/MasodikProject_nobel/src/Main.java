import java.io.*;
import java.time.Year;
import java.util.*;

public class Main {
    public static ArrayList<Nobel> nobels = new ArrayList<>();

    public static void main(String[] args) {
        FileReader();
        GETArthuMcDonald();
        GETLiteratureNobel();
        GETOrganizitaionsNobel();
        GETCurieFamilyNobels();
        GETNobelCounts();
        CreateFileDoctorsNobel();
    }

    public static  class YearSort implements Comparator<Nobel>{
        @Override
        public int compare(Nobel o1, Nobel o2) {
            return o1.getEvszam().compareTo(o2.getEvszam());
        }
    }

    public static void CreateFileDoctorsNobel(){
        File file = new File("orvosi.txt");
        try {
            boolean newFile = file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("");
                Comparator<Nobel> yearSorting = new YearSort();
                nobels.sort(yearSorting);
                for (Nobel nobel: nobels){
                    if(nobel.getNobelType().equals("orvosi")){
                        writer.append(nobel.getDoctorNobels());
                    }
                }
                writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  static  void GETNobelCounts(){
        System.out.println("7. feladat: ");
        TreeMap<String, Integer> nobelCounts = new TreeMap<>();

        for (Nobel nobel: nobels){
            if(!nobelCounts.containsKey(nobel.getNobelType())){
                nobelCounts.put(nobel.getNobelType(),1);
            } else nobelCounts.put(nobel.getNobelType(), nobelCounts.get(nobel.getNobelType())+1);
        }

        for (String title : nobelCounts.keySet()){
            System.out.println("\t"+title+": "+nobelCounts.get(title)+" db");
        }
    }

    public  static  void GETCurieFamilyNobels(){
        System.out.println("6. feladat: ");
        for(Nobel nobel: nobels){
            if(nobel.getFirstName().equalsIgnoreCase("curie") || nobel.getFirstName().contains("Curie")){
                String output = nobel.getEvszam()+": "+ nobel.getLastName()+" "+nobel.getFirstName()+" ("+nobel.getNobelType()+")";
                System.out.println("\t"+output);
            }
        }
    }

    public  static void GETOrganizitaionsNobel(){
        TreeMap<Year,String> yearOrganization = new TreeMap<>();
        System.out.println("5. feladat: ");
        for(Nobel nobel: nobels){
            if(nobel.getEvszam().isAfter(Year.of(1990)) &&
                    nobel.getEvszam().isBefore(Year.now()) &&
                    nobel.getFirstName().isEmpty()
            ){
                yearOrganization.put(nobel.getEvszam(),nobel.getLastName());
            }
        }

      for (Year year : yearOrganization.keySet()){
          System.out.println("\t"+year+": "+yearOrganization.get(year));
      }
    }

    public static void GETLiteratureNobel(){
        TreeSet<String> nobelReceiver = new TreeSet<>();
        for (Nobel nobel: nobels){
            if(nobel.getNobelType().equals("irodalmi") &&
                    nobel.getEvszam().equals(Year.of(2017))
            ){
                nobelReceiver.add(nobel.getLastName()+" "+nobel.getFirstName());
            }
        }

        Iterator<String> it = nobelReceiver.iterator();
            System.out.print("4. feladat: ");
        while(it.hasNext()){
            System.out.print(it.next()+"\n");
        }
    }

    public static void GETArthuMcDonald() {
        String nobelType = "";
        for (Nobel nobel: nobels){
            if(nobel.getFirstName().equals("McDonald") &&
            nobel.getLastName().equals("Arthur B.")){
                nobelType=nobel.getNobelType();
            }
        }
        if(!nobelType.isEmpty()){
            System.out.println("3. feladat: " +nobelType);
        } else {
            System.out.println("Nem kapott Arthur B. McDonald-nak díjat!");
        }
    }

    public static void FileReader() {
        File file = new File("nobel.csv");
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                nobels.add(new Nobel(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Nem található a megadott fájl!");
        }

    }
}
