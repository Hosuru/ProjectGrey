package ProjectGreyHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MyResources{
    public static String[][] csvToTxt(String data, int lines, String delimiter){
        String[][] output = new String[lines][];
        int x = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "UTF-8"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(delimiter,-1);
                output[x] = values;
                x++;
            }
        } catch (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }
        return output;
    }

    // now the idea is to make a full json with EVERYTHING called GENV.json, but for THAT, first we gotta:
    //  - make sure that every pokemon has all the information there, both english and spanish
    //      - for that we need to make something that searches through matrixes

    public static String[] lineFinder(String firstEntry, String[][] matrix){
        boolean foundF = false;
        String[] output = null;

        for (String x[] : matrix) {
            if(x[0].equals(firstEntry)){
                output = x;
                foundF = true;
            }
        }

        if(!foundF){
            System.err.println("data" + firstEntry + "not found");
            return null;
        } else {
            return output;
        }
    }
}