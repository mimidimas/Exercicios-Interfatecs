package interfatecs;
import java.util.*;

public class ScoreBoard {
    static class Time {
        String nome, fatec;
        int res, tempo;
        Time(String n, String f, int r, int t) {
            nome = n; fatec = f; res = r; tempo = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Digite o nome da Fatec Sede: ");
        String sede = sc.nextLine().trim();

        System.out.print(" Digite o Total de Vagas e Vagas Extras (ex: 8 2): ");
        int vt = sc.nextInt();
        int ve = sc.nextInt();

        System.out.print(" Quantos times voce vai cadastrar? ");
        int nt = sc.nextInt();
        sc.nextLine();

        List<Time> todos = new ArrayList<Time>();
        List<Time> desc = new ArrayList<Time>();

        System.out.println("--- Dados (Nome|Fatec|Resolvidos|Tempo) ---");
        for (int i = 0; i < nt; i++) {
            System.out.print("Time " + (i + 1) + ": ");
            String[] p = sc.nextLine().split("\\|");
            Time t = new Time(p[0].trim(), p[1].trim(), Integer.parseInt(p[2].trim()), Integer.parseInt(p[3].trim()));
            if (t.res == 0) desc.add(t);
            else todos.add(t);
        }

        Collections.sort(todos, new Comparator<Time>() {
            public int compare(Time a, Time b) {
                if (a.res != b.res) return b.res - a.res;
                return a.tempo - b.tempo;
            }
        });

        Set<Time> classif = new LinkedHashSet<Time>();
        Set<String> fVaga = new HashSet<String>();
        int cSede = 0;

        for (int i = 0; i < todos.size(); i++) {
            Time t = todos.get(i);
            if (t.fatec.equals(sede) && cSede < (ve + 1)) {
                classif.add(t); fVaga.add(t.fatec); cSede++;
            }
        }

        for (int i = 0; i < todos.size(); i++) {
            Time t = todos.get(i);
            if (!fVaga.contains(t.fatec) && classif.size() < vt) {
                classif.add(t); fVaga.add(t.fatec);
            }
        }

        for (int i = 0; i < todos.size(); i++) {
            Time t = todos.get(i);
            if (classif.size() < vt) classif.add(t);
        }

        List<Time> lFinal = new ArrayList<Time>(classif);
        Collections.sort(lFinal, new Comparator<Time>() {
            public int compare(Time a, Time b) {
                return a.nome.compareTo(b.nome);
            }
        });

        System.out.println("\nClassificados para a Final");
        for (int i = 0; i < lFinal.size(); i++) {
            Time t = lFinal.get(i);
            System.out.printf("%s - %s (%d,%d)\n", t.nome, t.fatec, t.res, t.tempo);
        }

        System.out.println("\nLista de Espera");
        for (int i = 0; i < todos.size(); i++) {
            Time t = todos.get(i);
            if (!classif.contains(t)) {
                System.out.printf("%s - %s (%d,%d)\n", t.nome, t.fatec, t.res, t.tempo);
            }
        }

        Collections.sort(desc, new Comparator<Time>() {
            public int compare(Time a, Time b) {
                return a.nome.compareTo(b.nome);
            }
        });

        System.out.println("\nDesclassificados");
        for (int i = 0; i < desc.size(); i++) {
            Time t = desc.get(i);
            System.out.printf("%s - %s (%d,%d)\n", t.nome, t.fatec, t.res, t.tempo);
        }

        System.out.println("\nApuracao concluida!");
    }
}