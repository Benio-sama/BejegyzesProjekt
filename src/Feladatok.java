import java.io.*;
import java.util.*;

public class Feladatok {
    private final List<Bejegyzes> bejegyzesek = new ArrayList<Bejegyzes>();

    public List<Bejegyzes> getBejegyzesek() {
        return bejegyzesek;
    }

    public void feladat1a() {
        Bejegyzes b1 = new Bejegyzes("asd", "asdasdasd");
        Bejegyzes b2 = new Bejegyzes("asd2", "asdasdasdasdf");

        bejegyzesek.add(b1);
        bejegyzesek.add(b2);
    }

    public void feladat1b() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("kerek egy egesz szamot: ");
            int szam = input.nextInt();
            for (int i = 0; i < szam; i++) {
                System.out.print("Kerem a szerzot: ");
                String szerzot = input.nextLine();
                input.nextLine();
                System.out.print("Kerem a tartalmat: ");
                String tartalom = input.nextLine();
                bejegyzesek.add(new Bejegyzes(szerzot ,tartalom));
            }
        } catch (InputMismatchException e) {
            throw new Error("Egesz szamnak kell lennie.");
        }

    }

    public void feladat1c(String fajl) {
        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null && !sor.isEmpty()) {
                String[] sorok = sor.split(";");
                bejegyzesek.add(new Bejegyzes(sorok[0], sorok[1]));
                sor = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void feladat1d() {
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            Random r = new Random();
            int hossz = bejegyzesek.size();
            bejegyzesek.get(r.nextInt(0, hossz)).like();
        }
    }

    public void feladat1e() {
        Scanner input = new Scanner(System.in);
        System.out.println("kerek egy szoveget: ");
        String szoveg = input.nextLine();
        bejegyzesek.get(1).setTartalom(szoveg);
    }

    public void feladat1f() {
        for (Bejegyzes b : bejegyzesek) {
            System.out.println(b);
        }
    }

    public int feladat2a() {
        int max = bejegyzesek.getFirst().getLikeok();
        for (Bejegyzes b : bejegyzesek) {
            if (b.getLikeok() > max) {
                max = b.getLikeok();
            }
        }
        return max;
    }

    public String feladat2b() {
        for (Bejegyzes b : bejegyzesek) {
            if (b.getLikeok() > 35) {
                return "igen";
            }
        }
        return "nem";
    }

    public int feladat2c() {
        int seged = 0;
        for (Bejegyzes b : bejegyzesek) {
            if (b.getLikeok() < 15) {
                seged++;
            }
        }
        return seged;
    }

    public void feladat2d() {
        Collections.sort(bejegyzesek, new Bejegyzescomparator());
        System.out.println(bejegyzesek.reversed());
        try {
            FileWriter wr = new FileWriter("bejegyzesek_rendezett.txt");
            BufferedWriter bw = new BufferedWriter(wr);
            for (Bejegyzes b : bejegyzesek) {
                bw.write(b.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
