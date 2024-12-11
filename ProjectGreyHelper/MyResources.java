package ProjectGreyHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyResources {
    
    public static String[][] scanNow(String file, String separator, int rows, int columns){
        String matrix[][] = new String[rows][columns];
        int x = 0;

        try{
            Scanner sc = new Scanner(new File(file));    // generamos el scanner. necesita de un archivo, el cual no usaremos en otro momento, así que lo generamos dentro

            while(sc.hasNext()){
                matrix[x] = sc.next().split(separator);

                x++;
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found, try again");
            return null;
        }
        return matrix;
    }

    public static String[] scanLine(String file, String separator, int rowN){
        String output[];

        try{
            Scanner sc = new Scanner(new File(file));   // generamos el scanner. necesita de un archivo, el cual no usaremos en otro momento, así que lo generamos dentro

            for (int i = 0; i < rowN-1; i++) {
                sc.next();

                if (!sc.hasNext()) {
                    throw new Exception();
                }
            }
                output = sc.next().split(separator);
            
            sc.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found, try again");
            return null;
        } catch (Exception ex) {
            System.err.println("Pokemon not found, try again");
            return null;
        }
        return output;
    }
}
