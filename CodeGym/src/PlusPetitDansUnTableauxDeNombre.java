public class PlusPetitDansUnTableauxDeNombre {
    public static void main(String[] args) throws Exception{
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Plus petit dans un tableau de nombvre *");
        System.out.println("****************************************************");
        int[] tabInts = {5, 6, 9, 1, 7, 0, -7, -9, 2, -4};
        int min =  tabInts [0];
        for(int i = 0; i < tabInts.length; i++) {
              if(tabInts[i] < min) {
                 min =  tabInts [i];
              }
        }
        System.out.println("la plus petite valeur est : " +min);

    }
}
