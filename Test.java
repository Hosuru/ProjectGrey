
import ProjectGreyHelper.MyResources;

public class Test{
    // static private String ARCHIVODATOS = "Moves base.csv";
    // static private String ARCHIVODESTINO = "testTemp.txt";

    public static void main(String[] args){
        // 560 = no. line in file.
        // manual imput.
        // String[][] matrix = new String[560][];

        // matrix = MyResources.csvToTxt(ARCHIVODATOS, 560, ",");

        // for (Object x[] : matrix) {
        //     for (Object y : x) {
        //         System.out.print(y + "\t");
        //     }
        //     System.out.print("\n");
        // }

        // String[] x = {"Bug", "Electric", "Flying", "Ground", "Poison", "Steel", "Dark", "Fighting", "Ghost", "Ice", "Psychic", "Water", "Dragon", "Fire", "Grass", "Normal", "Rock", "Null"};
        
        // for (String y : x) {
        //     System.out.println(y);
        //     System.out.println(E_PokeType.type(y).ImageLinkSp()+"\n");
        // }

        String[][] matrixMoves = MyResources.csvToTxt("Project Grey - Moves CSV.csv", 559, ",");

        Move[] testList = new Move[10];

        for (int i = 1; i < 11; i++) {
            testList[i-1] = new Move(Integer.parseInt(matrixMoves[i][5]),matrixMoves[i][6],Integer.parseInt(matrixMoves[i][8]), matrixMoves[i][0], matrixMoves[i][1], matrixMoves[i][9], matrixMoves[i][10], matrixMoves[i][3], Integer.parseInt(matrixMoves[i][7]), matrixMoves[i][2]);
        }

        for(Move x : testList){
            System.out.println(x.toStringEsp());
            System.err.println();
        }

        String[] goat = MyResources.lineFinder("Earthquake", matrixMoves);
        Move x = new Move(goat);

        System.out.println(x.toStringEsp());
    }
}