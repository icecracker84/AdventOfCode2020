package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class DayThirteenPart2 {

    private static long ind = 0;
    static int travelLengthRelevant = 0;
    static long t1 = 0l;
    static long t2 = 0;
    static long m1 = 0l;
    static long m2 = 0;

    static long start = 0l;
    static long diff = 0;

    static ArrayList<Item> travel = new ArrayList<Item>();
    static ArrayList<Item> travel2 = new ArrayList<Item>();
    private static Integer travelLength = 0;

    public static class Item implements Comparable<Item> {
        public Item( final Integer nr, final Long val ) {
            this.nr = nr;
            this.val = val;
        }

        Integer nr;
        Long val;

        @Override

        public int compareTo( final Item o ) {
            if ( this.nr == 0 ) {
                return -1;
            }

            if ( o.nr == 0 ) {
                return 1;
            }

            if ( this.val < o.val ) {
                return 1;
            } else if ( this.val > o.val ) {
                return -1;
            }
            return 0;
        }
    }

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
            ;
        } else {


            for ( String s : line.split(",") ) {
                if ( !s.equals("x") ) {
                    travel.add(new Item(travelLength, Long.valueOf(s)));
                    travelLengthRelevant++;
                }
                travelLength++;
            }
        }
    }



    public static void main( final String[] args ) {
        readFile();
        getMax();
        show();

    }

    private static void getMax() {

        Collections.sort(travel);

        int i = 0;
        for ( Item item : travel ) {
            if ( i == 0 ) {
                t1 = item.val;
                m1 = item.nr == 0 ? 0 : item.val - item.nr;
            }
            if ( i == 1 ) {
                t2 = item.val;
                m2 = item.nr == 0 ? 0 : item.val - item.nr;
            }
            i++;

            System.out.println("nr:" + item.nr + " " + item.val);

        }


        System.out.println(t1 + " " + t2 + " " + m1 + " " + m2);

        int x = 1;
        int found = 0;
        while ( found < 2 ) {
            x++;
            if ( Math.floorMod(t1 * x - m2 + m1, t2) == 0 ) {
                Math.floorMod(t1 * x - m2 + m1, t2);

                if ( found == 0 ) {
                    start = x * t1;
                } else {
                    diff = x * t1 - start;
                }
                found++;
            }
        }
        System.out.println("START:" + start + " + " + diff + " = " + (start + diff));
        System.out.println("----------");


        int ind = 0;
        for ( Item item : travel ) {
            if ( ind > 1 ) {
                travel2.add(item);
            } else {

                if ( Math.floorMod(((start + diff + item.nr)), item.val) == 0 ) {
                    System.out.println(ind + " OK");
                } else {
                    System.out.println(ind + " NOT OK");
                }


            }


            ind++;
        }

        System.out.println("----------");

    }


    private static void show() {

        int currRelevant = 0;
        long t = 0;
        long it = 1;



        while ( currRelevant < travelLengthRelevant - 2 ) {
            currRelevant = 0;
            t = start + it * diff;
            for ( Item item : travel2 ) {
                if ( Math.floorMod((t + item.nr), item.val) == 0 ) {
                    currRelevant++;
                }
            }
            it++;

        }


        System.out.println("END: " + t + " ");

    }



}
