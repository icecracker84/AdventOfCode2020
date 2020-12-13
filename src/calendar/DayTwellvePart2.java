package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayTwellvePart2 {

    private static int east = 0;
    private static int south = 0;

    private static int eastWP = 10;
    private static int southWP = -1;

    private static int dir = 0; // 0-E 1-S 2-W 3-N
    private static int prevDir = 0; // 0-E 1-S 2-W 3-N

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
            southWP += Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("N") ) {
            southWP -= Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("E") ) {
            eastWP += Integer.valueOf(line.substring(1));
        }
        if ( line.substring(0, 1).equals("W") ) {
            eastWP -= Integer.valueOf(line.substring(1));
        }

        if ( line.substring(0, 1).equals("F") ) {

            east += Integer.valueOf(line.substring(1)) * eastWP;
            south += Integer.valueOf(line.substring(1)) * southWP;


        }

        if ( line.substring(0, 1).equals("R") ) {

            dir += Integer.valueOf(line.substring(1)) / 90;

            int tempEastWP = eastWP;
            int tempSouthWP = southWP;

            if ( Math.abs(dir - prevDir) == 3 ) {
                tempEastWP = southWP;
                tempSouthWP = -eastWP;
            }
            if ( Math.abs(dir - prevDir) == 2 ) {
                tempEastWP = -eastWP;
                tempSouthWP = -southWP;
            }
            if ( Math.abs(dir - prevDir) == 1 ) {
                tempEastWP = -southWP;
                tempSouthWP = eastWP;
            }

            southWP = tempSouthWP;
            eastWP = tempEastWP;

            if ( dir >= 4 ) {
                dir -= 4;
            }

            prevDir = dir;
        }

        if ( line.substring(0, 1).equals("L") ) {
            dir -= Integer.valueOf(line.substring(1)) / 90;

            int tempEastWP = eastWP;
            int tempSouthWP = southWP;

            if ( Math.abs(dir - prevDir) == 1 ) {
                tempEastWP = southWP;
                tempSouthWP = -eastWP;
            }
            if ( Math.abs(dir - prevDir) == 2 ) {
                tempEastWP = -eastWP;
                tempSouthWP = -southWP;
            }
            if ( Math.abs(dir - prevDir) == 3 ) {
                tempEastWP = -southWP;
                tempSouthWP = eastWP;
            }

            southWP = tempSouthWP;
            eastWP = tempEastWP;

            if ( dir <= -1 ) {
                dir += 4;
            }

            prevDir = dir;

        }

        System.out.println(" e:" + east + " s:" + south + " eWP:" + eastWP + " sWP:" + southWP + " dir:" + dir); // 38 396++

    }



    public static void main( final String[] args ) {
        readFile();
        show();
    }



    private static void show() {
        System.out.println("----------");

        System.out.println(" e:" + east + " s:" + south + " eWP:" + eastWP + " sWP:" + southWP + " dir:" + dir); // 1777++

    }



}
