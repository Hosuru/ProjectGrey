package ProjectGreyHelper;

public class Test{
    public static void main(String[] args){

        /*
        String[][] matrix = MyResources.scanNow("Pokemon base.csv", ",", 160);
        int i = 1;

        // I wanna see every pokemon name, but only the names
        for (String[] x : matrix) {
            System.out.print(x[1]);
            i++;

            if(i==10){
                i=1;
                System.out.print("\n");
            } else
                System.out.print(" ");
        }*/

        String[] line = MyResources.scanLine("Pokemon base.csv", ",", 1);
        
        for (String x : line) {
            System.out.print(x + " ");
        }

        line = MyResources.scanLine("Pokemon base.csv", ",", 2);
        
        for (String x : line) {
            System.out.print(x + " ");
        }
    }
}