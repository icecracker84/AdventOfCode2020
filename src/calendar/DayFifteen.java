package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class DayFifteen {


    private static final int MAXX = 3000;
    private static final int startingTurn = 7;
    private static Integer[] play = new Integer[MAXX];
    private static int ind = 1;
    private static HashSet<Integer> set = new HashSet<Integer>();


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input15.txt";
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

        for ( String s : line.split(",") ) {
            Integer val = Integer.valueOf(s);
            play[ind] = val;
            set.add(val);
            ind++;
        }
    }


    public static void main( final String[] args ) {


        readFile();

        while ( ind < 2021 ) {
            play[ind] = applyRule(ind);

            ind++;
        }


        System.out.println("-------");

        int i = 1;
        while ( i < 2021 ) {
            System.out.println(i + ": " + play[i]);
            i++;
        }


    }


    private static int applyRule( final int i ) {

        int j = i - 1;

        if ( !(startingTurn == i) && set.contains(play[i - 1]) ) {
            boolean found = false;
            while ( !found ) {
                j--;
                if ( play[j].equals(play[i - 1]) ) {
                    found = true;
                }
            }
            return i - 1 - j;
        } else {
            set.add(play[i - 1]);
            return 0;
        }
    }



}
