package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DayThirteen {

    private static int ind = 0;
    private static int start = 0;
    static List<Integer> list = new ArrayList<Integer>();

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input13.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ( line != null ) {
                process(line);
                ind++;
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    private static void process( final String line ) {

        if ( ind == 0 ) {
            start = Integer.valueOf(line);
        } else {
            for ( String s : line.split(",") ) {
                if ( !s.equals("x") ) {
                    list.add(Integer.valueOf(s));
                }
            }
        }
    }



    public static void main( final String[] args ) {
        readFile();
        show();



    }



    private static void show() {

        int min = 10000000;
        int val = 0;

        for ( Integer i : list ) {
            int div = start / i;

            int curr = i * (div + 1) - start;

            if ( curr < min ) {
                min = curr;
                val = i;
            }

            System.out.println(i + " " + div + " " + curr);
        }

        System.out.println("END: " + min + " " + val + " " + start + " " + min * val);

    }



}
