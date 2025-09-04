package ital;

import java.time.LocalDate;
import java.util.Date;

public class Bor {
    private String fajta;
    private Integer evjarat;

    public Bor(String fajta, String evjarat) throws Exception {
        setFajta(fajta);
        setEvjarat(Integer.parseInt(evjarat));
    }

    public Integer getEvjarat() {
        return evjarat;
    }

    @Override
    public String toString(){
        return String.format("Ez egy bor, ami %s, melynek évjárata: %d.", this.fajta, this.evjarat);
    }

    public void setEvjarat(Integer inputEvjarat) throws Exception {
        if(0<inputEvjarat &&  inputEvjarat <= LocalDate.now().getYear()){
            this.evjarat = inputEvjarat;
        }
        else{
            throw new RuntimeException("Csak érvényes dátumot irhat be");
        }
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }
}
