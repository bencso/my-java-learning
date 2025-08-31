import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Grandprix {
    private Date date;
    private String name;
    private Byte position;
    private Byte laps;
    private Byte points;
    private String team;
    private String status;

    public Grandprix(String row) {
        String[] rowPieces = row.split(";");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = simpleDateFormat.parse(rowPieces[0]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        setDate(date1);
        setName(rowPieces[1]);
        setPosition(Byte.valueOf(rowPieces[2]));
        setLaps(Byte.valueOf(rowPieces[3]));
        setPoints(Byte.valueOf(rowPieces[4]));
        setTeam(rowPieces[5]);
        setStatus(rowPieces[6]);
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd.");
        return simpleDateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getPosition() {
        return position;
    }

    public void setPosition(Byte position) {
        this.position = position;
    }

    public Byte getLaps() {
        return laps;
    }

    public void setLaps(Byte laps) {
        this.laps = laps;
    }

    public Byte getPoints() {
        return points;
    }

    public void setPoints(Byte points) {
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}