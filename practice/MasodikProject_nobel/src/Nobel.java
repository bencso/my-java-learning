import java.time.Year;
enum NobelType {
    FIZIKAI,
    KEMIAI,
    ORVOSI,
    IRODALMI,
    BEKE,
    KOZGADASAGTANI
}

public class Nobel {
    private Year evszam;
    private NobelType nobelType;
    private String lastName;
    private  String firstName;

    public Nobel(String row){
        String[] rowPieces = row.split(";");
        setEvszam(Year.parse(rowPieces[0]));
        setNobelType(nobelTypeSetter(rowPieces[1]));
        setLastName(rowPieces[2]);
        setFirstName(rowPieces[3]);
    }

    protected NobelType nobelTypeSetter(String type){
        NobelType returnValue;
        switch (type.toLowerCase()){
            case "irodalmi": returnValue = NobelType.IRODALMI;
            case "fizikai": returnValue = NobelType.FIZIKAI;
            case "kémiai": returnValue = NobelType.KEMIAI;
            case "orvosi": returnValue = NobelType.ORVOSI;
            case "béke": returnValue = NobelType.BEKE;
            case "közgazdaságtani": returnValue = NobelType.KOZGADASAGTANI;
            default: returnValue = NobelType.IRODALMI;
        };
        return  returnValue;
    }

    public Year getEvszam() {
        return evszam;
    }

    public void setEvszam(Year evszam) {
        this.evszam = evszam;
    }

    public NobelType getNobelType() {
        return nobelType;
    }

    public void setNobelType(NobelType nobelType) {
        this.nobelType = nobelType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
