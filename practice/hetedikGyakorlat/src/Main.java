import ital.Bor;
import ital.Aszu;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Milyen fajta bor?");
        Scanner scanner = new Scanner(System.in);
        String fajta = scanner.nextLine();
        HashMap<String, String> parameterek = new HashMap<>();
        if(fajta.equals("aszu")){
            parameterek.put("évjárat","");
            parameterek.put("puttony","");
        }else {
            parameterek.put("évjárat","");
        }
            for (String parameter : parameterek.keySet()){
                System.out.print(parameter+": ");
                parameterek.put(parameter, scanner.nextLine());
            }

        try {
            Bor bor;
            if (fajta.equals("aszu")) {
                bor = new Aszu(parameterek.get("puttony"), parameterek.get("évjárat"));
            } else {
                bor = new Bor(fajta, parameterek.get("évjárat"));
            }

            System.out.println(bor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
