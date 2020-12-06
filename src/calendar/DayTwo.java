package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayTwo {

    static ArrayList<Integer> elements = new ArrayList<Integer>();
    static ArrayList<Integer> sumArray = new ArrayList<Integer>();

    static int summa = 0;
    static int summa2 = 0;


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input2.txt";
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
        int i = 0;
        int j = 0;
        String c = "x";
        Integer from = null;
        Integer to = null;

        for ( String s : line.split(" ") ) {
            i++;

            if ( i == 1 ) {
                j = 0;

                for ( String s2 : s.split("-") ) {
                    if ( j == 0 ) {
                        from = Integer.valueOf(s2);
                        j++;
                    } else {
                        to = Integer.valueOf(s2);
                    }
                }
            }

            if ( i == 2 ) {
                c = s.replace(":", "");
            }

            if ( i == 3 ) {
                i = 0;
                int diff = s.length() - s.replaceAll(c, "").length();
                if ( from <= diff && diff <= to ) {
                    summa++;
                }
                if ( (s.charAt(from - 1) == c.charAt(0) && s.charAt(to - 1) != c.charAt(0))
                    || (s.charAt(from - 1) != c.charAt(0) && s.charAt(to - 1) == c.charAt(0)) ) {
                    summa2++;
                }

            }
        }

    }


    public static void main( final String[] args ) {

        readFile();

        System.out.println("s" + summa2);

    }



}
