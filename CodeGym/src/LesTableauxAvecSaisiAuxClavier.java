import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LesTableauxAvecSaisiAuxClavier {
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String [] tabStrings = new String[10];
        System.out.println(" Saisir une chaine : ");
        for(int i = 0; i < tabStrings.length; i++) {
            String chaine = bfr.readLine();
            tabStrings[i] = chaine;
            System.out.println(tabStrings[i]);
        }

        for(String chaine: tabStrings) {

            System.out.print(chaine + " |");
        }
    }
}
