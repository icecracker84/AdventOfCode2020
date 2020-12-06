package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFive {

    static int seatID = 0;
    static ArrayList<Integer> seatIDList = new ArrayList<Integer>();


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input5.txt";
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

        // System.out.println(line);

        int n = 7;
        int m = 3;
        int min = 0;
        int max = 127;
        int colmin = 0;
        int colmax = 7;
        for ( int i = 0; i < line.length(); i++ ) {
            if ( n > 0 ) {
                if ( 'B' == line.charAt(i) ) {
                    min = max + 1 - (int) Math.pow(2, n - 1);
                } else {
                    max = min - 1 + (int) Math.pow(2, n - 1);
                }
                n--;
                // System.out.println(min + " " + max);

            } else {
                if ( 'R' == line.charAt(i) ) {
                    colmin = colmax + 1 - (int) Math.pow(2, m - 1);
                } else {
                    colmax = colmin - 1 + (int) Math.pow(2, m - 1);
                }
                // System.out.println(colmin + " " + colmax);

                Math.pow(2, m);
                m--;
            }

        }
        int currseatID = max * 8 + colmax;
        if ( seatID < currseatID ) {
            seatID = currseatID;
        }
        seatIDList.add(currseatID);
    }


    public static void main( final String[] args ) {

        readFile();

        // System.out.println("max: " + seatID);

        for ( Integer i : seatIDList ) {
            System.out.println(i);
        }

    }



}
