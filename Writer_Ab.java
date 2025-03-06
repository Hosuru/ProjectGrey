import ProjectGreyHelper.MyResources;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer_Ab {
    
    static private String ARCHIVODATOS = "Project Grey - Moves CSV.csv";
    static private int LINEASDATOS = 559;
    static private String ARCHIVODESTINO = "temp.txt";

    public static void writeItDown (String data, String temp){

        String[][] pseudoFile = MyResources.csvToTxt(data, LINEASDATOS, ";");
        
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(temp))){
            int i = 0;
            for (String line[] : pseudoFile) {
                if(i != 0){
                    Move move = new Move(line);
                    String output = move.toFile(i);
                    wr.write(output);
                    wr.newLine();
                    wr.newLine();
                }
                i++;
            }
        } catch (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeItDown(ARCHIVODATOS, ARCHIVODESTINO);
    }
}
