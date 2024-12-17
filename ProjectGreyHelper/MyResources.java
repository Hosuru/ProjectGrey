package ProjectGreyHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyResources {
    
    public static String[][] scanNow(String file, String separator, int rows){
        String matrix[][] = new String[rows][];
        int x = 0;

        try{
            Scanner sc = new Scanner(new File(file));    // generamos el scanner. necesita de un archivo, el cual no usaremos en otro momento, así que lo generamos dentro
            sc.useDelimiter("\n");
            while(sc.hasNext() && x<rows){
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
            Scanner sc = new Scanner(new File(file));
            sc.useDelimiter("\n");
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

    // recorre todo el csv buscando de cierto valor específico sabiendo en que posición debería estar
    public static String[] searchLine(String file, String separator, Object x, int pos){
        String output[];
        String[] line = null;
        boolean notFound = true;

        try{
            Scanner sc = new Scanner(new File(file));
            sc.useDelimiter("\n");

            while(sc.hasNext() && notFound){
                line = sc.next().split(separator);

                notFound = line[pos]==x;
            }
            output = line;

            if (output == null)
                throw new Exception(""); // the catch already sends the message, no need to say anything else

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return null;
        } catch (Exception ex) {
            System.err.println("Line not found");
            return null;
        }

        return output;
    }
}