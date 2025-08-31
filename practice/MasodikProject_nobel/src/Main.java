import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Nobel> nobels = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void FileReader() {
        File file = new File("nobel.csv");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Nem található a megadott fájl!");
        }

    }
}
