import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LesTableauxDeNombreAvecSaisiAuxClavier {
    public static void main(String[] args) throws Exception{
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Lit 10 nombre au clavier             *");
        System.out.println("****************************************************");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int[] tabInts = new int [10];
        for(int i = 0; i < tabInts.length; i++) {
            System.out.println(" Saisir un nombre : ");
            String  saisir = bfr.readLine();
            int  nombre = Integer.parseInt(saisir);
            tabInts[i] = nombre;
            System.out.println(tabInts[i]);
        }

        for(int chaine: tabInts) {

            System.out.print(chaine + " |");
        }
    }
}
