package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayNine {


    private static Long[] list = new Long[1010];

    private static int i = 1;
    private static int j = 0;
    private static int preamble = 25;

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input9.txt";
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
        list[i] = Long.valueOf(line);
        i++;
    }



    public static void main( final String[] args ) {

        readFile();

        System.out.println(i);

        innerLoop();


        System.out.println("----------");

        System.out.println(j + " " + list[j]); //

    }


    private static void innerLoop() {

        boolean ok = true;

        while ( j < i && ok ) {
            j++;
            if ( !sumOfTwo() ) {
                ok = false;
            }
        }
    }


    private static boolean sumOfTwo() {

        boolean ok = false;

        if ( j <= preamble ) {
            return true;
        }

        for ( int k = j - preamble; k < j; k++ ) {
            for ( int l = k + 1; l < j; l++ ) {
                if ( ((Long) (list[k] + list[l])).equals(list[j]) ) {
                    System.out.println(k + " " + list[k]); //
                    System.out.println(l + " " + list[l]); //
                    System.out.println(j + " " + list[j]); //
                    System.out.println(); //

                    ok = true;
                }
            }
        }

        return ok;
    }



}
