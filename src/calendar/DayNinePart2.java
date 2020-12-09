package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayNinePart2 {


    private static long[] list = new long[1010];

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
        i--;

        innerLoop();


        long a = 83267654028700l;
        long b = 83267654028700l;

        if ( a == b ) {
            System.out.println("----------");
        }

        System.out.println(j + " " + list[j]); //

    }


    private static void innerLoop() {

        boolean found = false;

        while ( j < i && !found ) {
            j++;
            if ( sumOfMany() ) {
                found = true;
            }
        }
    }


    private static boolean sumOfMany() {

        boolean ok = false;
        long sum = 0;
        int k = j;

        while ( k <= i - 1 && sum < list[i] && !ok ) {
            sum = list[k];
            int l = k + 1;
            while ( l < i && sum < list[i] && !ok ) {
                System.out.println("ss:" + sum); //
                sum += list[l];
                if ( sum == list[i] ) {
                    ok = true;
                    System.out.println("k:" + k + " l:" + l); //
                }
                l++;
            }
            k++;
        }

        return ok;
    }



}
