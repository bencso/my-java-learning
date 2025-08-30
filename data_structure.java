// Adat struktúra
// importálni kell a util-t mindegyikhez!
import java.util.*;

// Tömblista - ArrayList : Átméretezhető tömb
// LIST Interface része: indexük alapján lehet hozzáférni
// Akkor használjuk: ha fontos a sorrend, és lehetnek ismétlődések
// ArrayList: átméretezhető tömb       - adatok tárolása, elérése 
// LinkedList: "konténerekben" tárolja - adatok kezelése
ArrayList<String> cars = new ArrayList<String>();
cars.add("Volvo");
cars.add("BMW");
cars.add(0, "Mazda");
cars.get(0);
cars.set(0, "Opel");
cars.remove(0);
cars.clear();
cars.size();

// Sorba rendezés, ehhez használjuk az import-ot
import java.util.Collections;
Collection.sort(cars);
Collection.sort(cars, Collections.reverseOrder());

// HashSet -  JS: Set() - nem lehet benne kettő azonos adat
HashSet<String> cars = new HashSet<String>();
cars.add("Volvo");
cars.add("BMW");
cars.add("BMW"); // Ez már benne van igy nem fog kétszer benne lenni.


// HashMap - ez C# Dictionary: kulcs-érték
HashMap<String, String> capitalCities = new HashMap<String, String>();
capitalCities.put("England", "London");

// Iterátor
// Végig megy egy adatstruktúrán
Iterator<String> it = cars.iterator();
it.hasNext();       // Van-e még következő elem?
it.next();          // Lekéri a következő elemet
it.remove();        // (Opcionális) eltávolítja az aktuális elemet

while(it.hasNext()){
  System.out.println(it.next()); 
}
