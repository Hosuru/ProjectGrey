import ProjectGreyHelper.MyResources;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer_Ab {
    
    static private String ARCHIVODATOS = "Project Grey - Habilidades.csv";
    static private int LINEASDATOS = 107;
    static private String ARCHIVODESTINO = "temp.txt";

    public static void writeItDown (String data, String temp){

        String[][] pseudoFile = MyResources.csvToTxt(data, LINEASDATOS, ";");
        
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(temp))){
            for (Object line[] : pseudoFile) {
                String input = "### " + line[1] + "\n" + line[3];
                wr.write(input,0,input.length());
                wr.newLine();
                wr.newLine();
            }
        } catch (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeItDown(ARCHIVODATOS, ARCHIVODESTINO);
    }
}
