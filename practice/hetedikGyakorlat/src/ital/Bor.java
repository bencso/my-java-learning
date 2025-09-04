public class Bor {
    private String fajta;
    private Integer evjarat;

    Bor(String fajta, String evjarat) throws Exception {
        setFajta(fajta);
        setEvjarat(Integer.parseInt(evjarat));
    }

    public Integer getEvjarat() {
        return evjarat;
    }

    @Override
    public String toString(){
        return String.format("Ez egy bor, ami%s, melynek évjárata: %d.", this.fajta, this.evjarat);
    }

    public void setEvjarat(Integer inputEvjarat) throws Exception {
        if(0<inputEvjarat){
            this.evjarat = inputEvjarat;
        }
        else{
            throw new Exception("Az évjárat csak pozitív szám lehet!");
        }
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }
}
