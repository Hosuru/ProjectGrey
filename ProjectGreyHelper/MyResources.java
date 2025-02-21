package ProjectGreyHelper;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyResources{
    public static String[][] csvToTxt(String data, int lines, String delimiter){
        String[][] output = new String[lines][];
        int x = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(data))){
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(delimiter);
                output[x] = values;
                x++;
            }
        } catch (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }
        return output;
    }
}