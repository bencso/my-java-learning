import java.time.Year;


public class Nobel {
    private Year evszam;
    private String nobelType;
    private String lastName;
    private String firstName;

    public Nobel(String row) {
        String[] rowPieces = row.split(";");
        setEvszam(Year.parse(rowPieces[0]));
        setNobelType(rowPieces[1]);
        setLastName(rowPieces[2]);
        if (rowPieces.length == 4) setFirstName(rowPieces[3]);
        else setFirstName("");
    }

    public Year getEvszam() {
        return evszam;
    }

    public void setEvszam(Year evszam) {
        this.evszam = evszam;
    }

    public String getNobelType() {
        return nobelType;
    }

    public void setNobelType(String nobelType) {
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

    public String getDoctorNobels(){
        return this.evszam+": "+this.lastName+" "+this.firstName+"\n";
    }
}
