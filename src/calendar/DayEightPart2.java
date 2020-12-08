package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DayEightPart2 {


    private static ArrayList<Item> list2 = new ArrayList<Item>();
    private static Item[] list = new Item[1000];

    private static int i = 1;
    private static int curr = 1;
    private static int acc = 0;

    public static class Item {

        public Item( final String op, final Integer val ) {
            this.op = op;
            this.val = val;
        }

        String op;
        Boolean processed = false;
        Integer val;

    }


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input8.txt";
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

        String op = null;
        Integer val = null;
        for ( String s : line.split(" ") ) {
            if ( "nop".equals(s) || "jmp".equals(s) || "acc".equals(s) ) {
                op = s;
            } else {
                val = Integer.valueOf(s);
            }
        }

        list[i] = new Item(op, val);
        i++;
    }



    public static void main( final String[] args ) {

        readFile();
        list[i] = new Item("0", 0);

        int kTrack = 0;

        while ( curr < 591 ) {
            kTrack++;
            int k = 0;
            acc = 0;
            curr = 1;
            innerLoop(kTrack, k);
            resetProcessed();

            System.out.println(curr + " " + kTrack + " " + list[curr].op + " " + list[curr].val);
        }

        System.out.println(curr + " " + kTrack + " " + acc); // 1420-

    }


    private static void resetProcessed() {
        for ( int ind = 1; ind < i; ind++ ) {
            list[ind].processed = false;
        }
    }


    private static void innerLoop( final int kTrack, int k ) {
        while ( !list[curr].processed && curr <= 591 ) {
            k++;
            list[curr].processed = true;
            if ( list[curr].op.equals("acc") ) {
                acc += list[curr].val;
                curr++;
            } else if ( list[curr].op.equals("jmp") ) {
                if ( k == kTrack ) {
                    curr++;
                } else {
                    curr += list[curr].val;
                }
            } else if ( list[curr].op.equals("nop") ) {
                if ( k == kTrack ) {
                    curr += list[curr].val;
                } else {
                    curr++;
                }
            }
        }
    }



}
