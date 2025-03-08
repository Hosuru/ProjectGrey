import ProjectGreyHelper.MyResources;
public class Test{

    public static void main(String[] args){
        // String[][] matrixMoves = MyResources.csvToTxt("Project Grey - Moves CSV.csv", 559, ";");

        // Move[] testList = new Move[15];

        // for (int i = 1; i < 16; i++) {
        //     testList[i-1] = new Move(Integer.parseInt(matrixMoves[i][5]),matrixMoves[i][6],Integer.parseInt(matrixMoves[i][8]), matrixMoves[i][0], matrixMoves[i][1], matrixMoves[i][9], matrixMoves[i][10], matrixMoves[i][3], Integer.parseInt(matrixMoves[i][7]), matrixMoves[i][2], matrixMoves[i][4]);
        // }

        // System.err.println("done!");

        // int i = 1;
        // for (Move move : testList) {
        //     System.out.println("#### {{color:#cca983,width:13px,position:relative,top:-1px #" + i + "}} " + move.toFile());
        //     i++;
        // }

        String[][] pokeMatrix = MyResources.csvToTxt("Project Grey - Pokes.csv", 160, ";");
        // String[] blitzleLine = MyResources.lineFinder("522", pokeMatrix);
        // PokemonWild Blitzle = new PokemonWild(blitzleLine);

        // System.out.println(Blitzle.toFileEspNormal());
        
        String[] victiniLine = MyResources.lineFinder("494", pokeMatrix);
        // PokemonWild Victiny = new PokemonWild(victiniLine);

        // System.out.println(Victiny.toFileEspLegendary());

        for (String word : victiniLine) {
            if(word.equals("Victini")){
                continue;
            }

            System.out.println(word);
        }
    }
}