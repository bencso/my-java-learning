import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    /*
     * Feladat 1:
     * Készíts egy programot, ami eltárol 5 nevet, majd kiírja őket.
     * A sorrend pontosan úgy jelenjen meg, ahogy felvetted az adatokat.
     */
    static void firstFunction() {
        // Pontosan úgy kell ahogy felvettem, szóval linked lesz
        ArrayList<String> nameList = new ArrayList<String>();
        String[] names = { "Béla", "Pista", "Jakab", "Dorina", "Ferenc" };
        for (String name : names) {
            nameList.add(name);
        }
        ;

        System.out.println(nameList);
    };

    /*
     * Feladat 2
     * Készíts egy programot, ami eltárol 5 számot, de a felhasználó tetszőleges
     * sorrendben adja meg őket.
     * A számokat növekvő sorrendben kell kiírnod.
     */

    static void secondFunction(Scanner scanner) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true && numbers.size() < 5) {
            try {
                System.out.print("Adjon meg egy számot: ");
                int number = scanner.nextInt();
                numbers.add(number);
            } catch (InputMismatchException e) {
                System.out.println("Kérem csak számot adjon meg!");
                scanner.nextLine();
            }
        }
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    /*
     * Feladat 3
     * Készíts egy programot, ami eltárol több szót.
     * A kiírásnál ne jelenjen meg kétszer ugyanaz a szó, még akkor sem, ha a
     * felhasználó többször adta meg.
     */
    static void thirdFunction(Scanner scanner) {
        HashSet<String> words = new HashSet<>();
        System.out.println("Kérem adjon meg szavakat, addig tudja megadni a szvakat míg nem irja be, hogy vége!");
        while (true) {
            String input = scanner.nextLine();
            // a toLowerCase().contains() helyett jobb a equalsIgnoreCase();
            if (input.equalsIgnoreCase("vége"))
                break;
            words.add(input);
        }
        System.out.println(words);
    }

    /*
     * 2. szint
     * Feladat 1 — Sorrend megőrzése és duplikátumok kizárása
     * 
     * Készíts egy programot, ami:
     * Több szót tárol be a felhasználótól.
     * Ne jelenjen meg kétszer ugyanaz a szó, még ha többször beírják.
     * A kiírás pontosan abban a sorrendben történjen, ahogy a felhasználó beírta a
     * szavakat.
     */

    static void two_oneFunction(Scanner scanner) {
        LinkedHashSet<String> words = new LinkedHashSet<>();
        System.out.println("Kérem adjon meg szavakat, addig tudja megadni a szvakat míg nem irja be, hogy vége!");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("vége"))
                break;
            words.add(input);
        }
        System.out.println(words);
    }

    /*
     * Feladat 2 — Automatikusan rendezett tárolás
     * Készíts egy programot, ami:
     * Több számot tárol.
     * A kiírás mindig növekvő sorrendben történjen, függetlenül attól, milyen
     * sorrendben adta meg a felhasználó a számokat.
     * Duplikált számokat ne engedjen.
     */

    static void two_twoFunction(Scanner scanner) {
        TreeSet<Short> numbers = new TreeSet<>();
        System.out.println("Kérem adjon meg számokat! (-32,768 és 32,767 között), a -1 tud kilépni.");
        while (true) {
            try {
                Short input = scanner.nextShort();
                if (input == -1)
                    break;
                numbers.add(input);
            } catch (InputMismatchException e) {
                System.out.println("Csak számot adjon meg!");
                scanner.nextLine();
            }
        }
        System.out.println(numbers);
    }

    /*
     * Feladat 3 — Kulcs-érték párosítás sorrendben
     * Készíts egy programot, ami:
     * Nevekhez pontszámokat tárol.
     * A program írja ki:
     * Az összes nevet abban a sorrendben, ahogy felvetted.
     * Az összes pontszámot növekvő sorrendben.
     */
    static void two_threeFunction() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Jakab");
        names.add("Pista");
        names.add("Tigris");
        ArrayList<Integer> points = new ArrayList<>();
        points.add(30);
        points.add(5);
        points.add(4130);
        LinkedHashMap<String, Integer> name_point = new LinkedHashMap<>();
        Iterator<String> namesIterator = names.iterator();
        Iterator<Integer> pointsIterator = points.iterator();

        while (namesIterator.hasNext() && pointsIterator.hasNext()) {
            name_point.put(namesIterator.next(), pointsIterator.next());
        }

        System.out.println(name_point.keySet());
        ArrayList<Integer> numbers_sorted = new ArrayList<>(name_point.values());
        Collections.sort(numbers_sorted);
        System.out.println(numbers_sorted);
    }

    /*
     * 3. szint — Haladó feladatok
     * Feladat 1 — Iterátor és törlés
     * Készíts egy programot, ami:
     * Több számot tárol be a felhasználótól.
     * Ha a szám páros, töröld a listából.
     * Használd az iterátort, ne sima for-ciklust a törléshez.
     * Írd ki a maradék számot.
     */

    static void three_oneFunction(Scanner scanner) {
        ArrayList<Short> numbers = new ArrayList<>();

        while (true) {
            System.out.println("Kérem adjon meg számokat! (-32,768 és 32,767 között), a -1 tud kilépni.");
            try {
                Short number = scanner.nextShort();
                if (number == -1)
                    break;
                numbers.add(number);
            } catch (InputMismatchException e) {
                System.out.println("Kérem csak számot adjon meg");
                scanner.nextLine();
            }
        }

        Iterator<Short> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if ((int) iterator.next() % 2 != 0) {
                iterator.remove();
                ;
            }
        }
        System.out.println(numbers);
    }

    /*
     * Feladat 2 — Saját rendezés
     * 
     * Készíts egy programot, ami:
     * Több nevet tárol.
     * Írd ki a neveket hossz szerint növekvő sorrendben.
     * Ha két név hossza azonos, ábécé sorrendben rendezze őket.
     * Gondolkodj azon, milyen Comparator vagy struktúra a legjobb erre.
     */

    // ! A Comparator az egy interface, amivel egyedi rendezési szabályt tudunk
    // írni.
    static class SortLength implements Comparator<Object> {
        public int compare(Object obj1, Object obj2) {
            String name = (String) obj1;
            String name2 = (String) obj2;

            // Elsőnek igy csináltam, aztán ellenőrzés miatt bedobtam a chatGPT-nek és az
            // ezután következőt ajánlotta! Csak nem ugy hogy külön implemenátlom a változót
            /*
             * if (name.length() == name2.length()) {
             * if (name.compareTo(name2) == 1)
             * return 1;
             * else
             * return -1;
             * } else {
             * if (name.length() > name2.length())
             * return 1;
             * if (name2.length() > name.length())
             * return -1;
             * }
             */

            Integer nameLength = name.length();
            Integer name2Length = name2.length();

            if (nameLength != name2Length) {
                return Integer.compare(nameLength, name2Length);
            } else {
                return name.compareTo(name2);
            }
        }
    }

    static void three_twoFunction() {
        ArrayList<String> names = new ArrayList<String>(List.of("János", "Béla", "Kristóf", "Bence"));
        // Egyébként lehetne lambda verzióval is csinálni, csak kiváncsi voltam már erre a Comparatorra (w3schoolsról olvastam ezt is)
        /*
         * names.sort((a, b) -> {
         * int lenghtCompare = Integer.compare(a.length(), b.length());
         * return lenghtCompare != 0 ? lenghtCompare : a.compareTo(b);
         * });
         */
        Collections.sort(names, new SortLength());
        System.out.println(names);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        three_twoFunction();
        scanner.close();
    }
}