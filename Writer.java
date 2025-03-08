import ProjectGreyHelper.MyResources;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Writer {
    
    static private String ARCHIVODATOS = "Project Grey - Pokes.csv";
    static private int LINEASDATOS = 160;
    static private String ARCHIVODESTINO = "temp.txt";

    public static void writeItDown (String data, String temp){

        String[][] pseudoFile = MyResources.csvToTxt(data, LINEASDATOS, ";");

        boolean header = true;
        boolean firstInPage = false;
        
        Set<String> legendary = new HashSet();
        legendary.add("494");
        legendary.add("638");
        legendary.add("639");
        legendary.add("640");
        legendary.add("641");
        legendary.add("642");
        legendary.add("643");
        legendary.add("644");
        legendary.add("645");
        legendary.add("646");
        legendary.add("647");

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(temp))){
            for (String line[] : pseudoFile) {
                if(header){
                    header = false;
                    continue;
                }

                PokemonWild poke = new PokemonWild(line);

                if(legendary.contains(line[0])){
                    if(!firstInPage){
                        wr.write("\\page\n");
                    }
                    wr.write("{{footnote Pokemon | " + line[1] + "}}\n");
                    wr.write("{{pageNumber,auto}}");
                    wr.newLine();
                    wr.write("{{imageMaskEdge5,--offset:10%,--rotation:180\n");
                    wr.write("![" + line[1] + "](https://www.yeoandyeo.com/wp-content/uploads/07_02_21_1253437873_AAB_560x292.jpg){position:absolute,top:0px,right:-70px,height:500px}\n");
                    wr.write("}}\n");
                    wr.newLine();
                    wr.write("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    wr.newLine();
                    wr.write(poke.toFileEspLegendary()); // yep, this is the pokemon
                    wr.newLine();
                    wr.newLine();
                    wr.write("\\page\n");
                } else if(firstInPage){
                    wr.write("{{footnote Pokemon | " + line[1] + "}}\n");
                    wr.write("{{pageNumber,auto}}\n");
                    wr.newLine();
                    wr.write("![backgound pokéball](https://preview.redd.it/gcekdbseq6k21.png?auto=webp&s=d27752fd1c7bb460f598ceeff8bc49c4904d2f40) {position:absolute,top:650px,right:470px,width:325px,opacity:75%}\n");
                    wr.newLine();
                    wr.write("![backgound pokéball](https://preview.redd.it/gcekdbseq6k21.png?auto=webp&s=d27752fd1c7bb460f598ceeff8bc49c4904d2f40) {position:absolute,top:870px,right:410px,width:170px,opacity:75%}\n");
                    wr.newLine();
                    wr.write("![" + line[1] + "](https://cdn-icons-png.flaticon.com/512/8090/8090305.png) {position:absolute,top:640px,right:510px,width:250px}\n");
                    wr.newLine();
                    wr.write("![" + line[1] + "_shiny](https://static.thenounproject.com/png/42732-200.png) {position:absolute,top:860px,right:420px,width:150px}\n");
                    wr.newLine();
                    wr.write(poke.toFileEspNormal()); // aaaand this poor line too
                    wr.newLine();
                } else {
                    wr.write("\\column\n");
                    wr.write("::::::::::::::::::\n");
                    wr.write(poke.toFileEspNormal()); // last one!
                    wr.write("![backgound pokéball](https://preview.redd.it/gcekdbseq6k21.png?auto=webp&s=d27752fd1c7bb460f598ceeff8bc49c4904d2f40) {position:absolute,top:10px,right:130px,width:280px,opacity:75%}\n");
                    wr.newLine();
                    wr.write("![backgound pokéball](https://preview.redd.it/gcekdbseq6k21.png?auto=webp&s=d27752fd1c7bb460f598ceeff8bc49c4904d2f40) {position:absolute,top:200px,right:30px,width:150px,opacity:75%}\n");
                    wr.newLine();
                    wr.write("![" + line[1] + "](https://cdn-icons-png.flaticon.com/512/8090/8090305.png) {position:absolute,top:-10px,right:150px,width:250px}\n");
                    wr.newLine();
                    wr.write("![" + line[1] + "_shiny](https://static.thenounproject.com/png/42732-200.png) {position:absolute,top:180px,right:30px,width:150px}\n");
                    wr.newLine();
                    wr.write("\\page\n");
                    wr.newLine();
                }
                firstInPage = !firstInPage;
            }

            wr.close();
        } catch (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeItDown(ARCHIVODATOS, ARCHIVODESTINO);
    }
}
