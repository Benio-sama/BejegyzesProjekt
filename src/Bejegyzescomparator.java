import java.util.Comparator;

public class Bejegyzescomparator implements Comparator<Bejegyzes> {
    @Override
    public int compare(Bejegyzes b1, Bejegyzes b2) {
        return b1.getLikeok() - b2.getLikeok();
    }
}
