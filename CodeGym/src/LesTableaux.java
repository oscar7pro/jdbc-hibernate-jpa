import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class LesTableaux {
    public static void main(String[] args) {
        char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        System.out.println("****************************************************");
        System.out.println("*              Tableau de 1 à 10                   *");
        System.out.println("****************************************************");
        int tabInt [] = new int [10];
        for (int i = 0; i< tabInt.length; i++) {
            tabInt[i] = i + 1;
            System.out.print(tabInt[i]+ " ");
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Tableau de 10 à 1                   *");
        System.out.println("****************************************************");
        for(int i = 0; i <tabInt.length; i++) {
            tabInt[i] =10 - i;
            System.out.print(tabInt[i]+ " ");
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Tableau de 0 à 9                   * ");
        System.out.println("****************************************************");

        for(int i = 0; i < tabInt.length ; i++) {
            tabInt[i] = i;
            System.out.print(tabInt[i] + " ");
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Tableau de 0 à 9                   * ");
        System.out.println("****************************************************");
        for(int i = 0; i < tabInt.length; i++) {
            tabInt[i] = 9 - i;
            System.out.print(tabInt[i] + " ");
        }
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("*              Alphabet de A à Z                   *");
        System.out.println("****************************************************");

        for(char i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("*              Alphabet de Z à A                   *");
        System.out.println("****************************************************");


        for(char i =0; i < alphabet.length; i++) {
            alphabet[i] = '?';

            System.out.print("?");
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Alphabet de A à Z  avec un sur saut *");
        System.out.println("****************************************************");
        for(int i = 0; i< alphabet.length; i++) {
            if( i % 2 == 0) {
                System.out.print(alphabet[i] + " ");
            }else {
                System.out.print(" .. ");
            }
        }
        System.out.println();

    }

}
