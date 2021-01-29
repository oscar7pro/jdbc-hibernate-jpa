import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TableauxDeChaineEnOrdreInverser {
    public static void main(String[] args) throws Exception{
        InputStream in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*             Tableaux De Chaine En Ordre Inverser    *");
        System.out.println("****************************************************");
        String[] tabInts = new String [10];

        for(int i = 0; i < tabInts.length; i++) {
            System.out.println("Saisir une chaine : ");
            String chaine = reader.readLine();
             tabInts [i] = chaine;
        }

        for(int j = tabInts.length-1; j >= 0 ; j--) {
            System.out.print(tabInts [j] + " ");
        }

    }
}
