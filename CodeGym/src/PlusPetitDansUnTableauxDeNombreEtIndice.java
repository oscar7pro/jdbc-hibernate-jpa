public class PlusPetitDansUnTableauxDeNombreEtIndice {
    public static void main(String[] args) throws Exception{
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("*              Plus petit dans un tableau de nombvre *");
        System.out.println("****************************************************");
        int[] tabInts = {5, 6, 9, 1, 7, 0, -7, -9, 2, -4};
        Pair<Integer, Integer> result = getMinimumAndIndex(tabInts);

        System.out.println("la plus petite valeur est : " +result.x);
        System.out.println("L'indice de la plus petite valeur est : " +result.y);

    }
    private static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if(array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        int index = 0;
        int min = array[index];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min ) {
                index = i;
                min = array[i];
            }
        }
        return new Pair<Integer, Integer>(min, index);

    }
    public static  class Pair<X, Y > {
        public X x;
        public Y y;
        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
