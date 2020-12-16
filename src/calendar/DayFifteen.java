package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;


public class DayFifteen {


    private static final int MAXX = 30000001; // 30000000
    private static int startingTurn = 0;
    private static Integer[] play = new Integer[MAXX];
    private static int ind = 1;
    private static HashSet<Integer> set = new HashSet<Integer>();
    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


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
            map.put(val, ind);
            ind++;
        }
        startingTurn = ind;
    }


    public static void main( final String[] args ) {


        readFile();

        while ( ind < MAXX ) {
            play[ind] = applyRule(ind);
            ind++;
        }


        System.out.println(MAXX - 1 + " " + play[MAXX - 1] + "-------");
        System.out.println(MAXX + " " + play[MAXX] + "-------");

        // int i = 1;
        // while ( i < MAXX ) {
        // System.out.println(i + ": " + play[i]);
        // i++;
        // }


    }

    static int percent = 0;

    private static int applyRule( final int i ) {

        if ( Math.floorMod(i, MAXX / 100) == 0 ) {
            percent++;
            System.out.println(percent + "%");
        }
        if ( !(startingTurn == i) && set.contains(play[i - 1]) ) {
            Integer retVal = map.get(play[i - 1]);
            map.replace(play[i - 1], i - 1);
            return i - 1 - retVal;
        } else {
            set.add(play[i - 1]);
            map.put(play[i - 1], i - 1);
            if ( play[i - 1] <= startingTurn ) {
                map.replace(play[i - 1], i - 1);
            }
            return 0;
        }
    }



}
