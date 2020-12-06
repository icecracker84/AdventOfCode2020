package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayThree {

    private static final int MAX = 20000;

    static class Field {
        Field( final int a, final int b, final boolean c ) {
            x = a;
            y = b;
            tree = c;
        }

        int x;
        int y;
        boolean tree;
    }

    static int[][] map = new int[MAX][MAX];


    static int summa = 0;
    static int summa2 = 0;


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input3.txt";
        BufferedReader br = null;
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ( line != null ) {
                process(line, i);
                i++;
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    private static void process( final String line, final int i ) {

        for ( int j = 0; j < 31; j++ ) {
            for ( int shift = 0; shift < 500; shift++ ) {
                map[i][j + 31 * shift] = "#".equals(line.substring(j, j + 1)) ? 1 : 0;
            }
        }
    }


    public static void main( final String[] args ) {

        readFile();
        int y = 0;
        int cnt = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;
        int cnt5 = 0;

        y = 0;
        for ( int i = 0; i < 325; i++ ) {
            cnt += map[i][y];
            y += 1;
        }

        y = 0;
        for ( int i = 0; i < 325; i++ ) {
            cnt2 += map[i][y];
            y += 3;
        }

        y = 0;
        for ( int i = 0; i < 325; i++ ) {
            cnt3 += map[i][y];
            y += 5;
        }

        y = 0;
        for ( int i = 0; i < 325; i++ ) {
            cnt4 += map[i][y];
            y += 7;
        }

        y = 0;
        for ( int i = 0; i < 325; i += 2 ) {
            System.out.print(map[i][y] + " ");
            cnt5 += map[i][y];
            y += 1;
        }


        System.out.println(cnt + " " + cnt2 + " " + cnt3 + " " + cnt4 + " " + cnt5 + " " + cnt * cnt2 * cnt3 * cnt4 * cnt5);

        // 75 294 77 63 44 , 411 472 904 too low
        // 75 294 77 63 39 , 4 171 617 450 4171617450 too low
        // 75 294 77 63 44 , 4 706 440 200 4706440200 too low
        // 75 294 79 85 39 5774564250

        /*
         * for ( int i = 0; i < 325; i++ ) { for ( int j = 0; j < 310; j++ ) { System.out.print(map[i][j]); } System.out.println(); }
         */
        // System.out.println(cnt);

    }



}
