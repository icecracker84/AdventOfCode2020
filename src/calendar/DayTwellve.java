package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayTwellve {

    private static int east = 0;
    private static int south = 0;
    private static int dir = 0; // 0-E 1-S 2-W 3-N

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input12.txt";
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

        if ( line.substring(0, 1).equals("S") ) {
            south += Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("N") ) {
            south -= Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("E") ) {
            east += Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("W") ) {
            east -= Integer.valueOf(line.substring(1));
        }

        if ( line.substring(0, 1).equals("F") ) {
            if ( dir == 0 ) {
                east += Integer.valueOf(line.substring(1));
            }
            if ( dir == 2 ) {
                east -= Integer.valueOf(line.substring(1));
            }
            if ( dir == 1 ) {
                south += Integer.valueOf(line.substring(1));
            }
            if ( dir == 3 ) {
                south -= Integer.valueOf(line.substring(1));
            }
        }

        if ( line.substring(0, 1).equals("R") ) {

            dir += Integer.valueOf(line.substring(1)) / 90;
            if ( dir >= 4 ) {
                dir -= 4;
            }
        }

        if ( line.substring(0, 1).equals("L") ) {
            dir -= Integer.valueOf(line.substring(1)) / 90;
            if ( dir <= -1 ) {
                dir += 4;
            }
        }

    }



    public static void main( final String[] args ) {
        readFile();
        show();
    }



    private static void show() {
        System.out.println("----------");

        System.out.println(" e:" + east + " s:" + south + " d:" + dir); // 1777++

    }



}
