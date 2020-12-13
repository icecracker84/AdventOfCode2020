package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class DayTenPart2 {


    private static Integer[] diff = new Integer[1010];
    private static ArrayList<Integer> inputList = new ArrayList<Integer>();

    private static int ind = 1;
    private static int ind2 = 1;
    private static int lastVal = 0;

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input10.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ( line != null ) {
                process(line);
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    private static void process( final String line ) {
        diff[ind] = 0;
        inputList.add(Integer.valueOf(line));
        ind++;
        diff[ind] = 0;
    }



    public static void main( final String[] args ) {

        readFile();
        Collections.sort(inputList);

        for ( Integer i : inputList ) {
            // if ( ind2 > 1 ) {
            System.out.println(i + " " + (i - lastVal));

            diff[i - lastVal]++;

            // }
            lastVal = i;
            ind2++;
        }
        diff[3]++;

        System.out.println("----------");
        for ( int j = 0; j < ind; j++ ) {
            System.out.println(j + " " + diff[j]);
        }


    }



}
