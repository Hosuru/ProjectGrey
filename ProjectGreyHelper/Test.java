package ProjectGreyHelper;

public class Test{
    static private String ARCHIVODATOS = "Moves base.csv";
    static private String ARCHIVODESTINO = "testTemp.txt";

    public static void main(String[] args){
        // 560 = no. line in file.
        // manual imput.
        String[][] matrix = new String[560][];

        matrix = MyResources.csvToTxt(ARCHIVODATOS, 560, ",");

        for (Object x[] : matrix) {
            for (Object y : x) {
                System.out.print(y + "\t");
            }
            System.out.print("\n");
        }
    }
}