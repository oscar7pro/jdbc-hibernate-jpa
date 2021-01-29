import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SommeEntierTableauxDeNombre {
    public static void main(String[] args) throws Exception{
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Somme d'entier dans un tableau      *");
        System.out.println("****************************************************");
        int[] tabInts = {5, 6, 9, 1, 7, 0, -7, -9, 2, -4};
        int somme = 0;
        for(int i = 0; i < tabInts.length; i++) {
              somme +=tabInts[i] ;
        }
        System.out.println(somme);

    }
}
