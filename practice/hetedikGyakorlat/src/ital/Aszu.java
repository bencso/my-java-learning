package ital;

public class Aszu extends Bor {
    private Integer puttony;

    public Aszu(String puttony, String evjarat) throws Exception {
        super("aszu",evjarat);
        setPuttony(Integer.parseInt(puttony));
    }

    @Override
    public String toString(){
        return String.format("Ez egy aszú, melynek évjárata: %s és %d puttonyos", getEvjarat(), puttony);
    }

    public Integer getPuttony() {
        return puttony;
    }

    public void setPuttony(Integer puttony) {
        this.puttony = puttony;
    }
}
