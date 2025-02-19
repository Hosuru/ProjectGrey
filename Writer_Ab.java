import ProjectGreyHelper.MyResources;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer_Ab {
    
    static private String ARCHIVODATOS = "Project Grey - Habilidades.csv";
    static private String ARCHIVODESTINO = "temp.txt";

    public static void writeItDown (String data, String temp){
        
        String lineErrors = "";
        for (int i = 2; i < 107; i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp, true))){
                    String[] row = MyResources.scanLine(data, ";", i);

                    String line = ("#### " + row[1] + "\n" + row[3]);

                    bw.write(line);
                    bw.newLine();
            
            } catch (Exception e){
                System.err.println("Something went wrong: " + e.getMessage());
                e.printStackTrace();
                lineErrors = lineErrors + i + " ";
            }
        }

        System.out.print(lineErrors);
    }

    public static void main(String[] args) {
        writeItDown(ARCHIVODATOS, ARCHIVODESTINO);
    }
}
