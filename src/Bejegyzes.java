import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Bejegyzes {
    private final String szerzo;
    private String tartalom;
    private int likeok;
    private final LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }
    public String getSzerzo() {
        return szerzo;
    }
    public String getTartalom() {
        return tartalom;
    }
    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }
    public int getLikeok() {
        return likeok;
    }
    public LocalDateTime getLetrejott() {
        return letrejott;
    }
    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like() {
        likeok++;
    }

    @Override
    public String toString() {
        if (letrejott == szerkesztve) {
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott + "\n" +
                    this.tartalom + "\n";
        } else {
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott + "\n" +
                    "Szerkesztve: " + this.szerkesztve + "\n" +
                    this.tartalom + "\n";
        }
    }
}
