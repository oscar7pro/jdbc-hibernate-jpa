public class PlusGrandDansUnTableauxDeNombre {
    public static void main(String[] args) throws Exception{
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Plus petit dans un tableau de nombvre *");
        System.out.println("****************************************************");
        int[] tabInts = {5, 6, 9, 1, 7, 0, -7, -9, 2, -4};
        int max =  tabInts [0];
        for(int i = 0; i < tabInts.length; i++) {
              if(tabInts[i] > max) {
                 max =  tabInts [i];
                  System.out.println(" MAX en cours : " +max);

              }
        }
        System.out.println("la plus grande valeur est : " +max);

    }
}
