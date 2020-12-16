package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;


public class DayFourteenPart2 {


    private static final int MAXX = 81163;
    private static Long[] mem = new Long[MAXX];
    private static HashMap<Long, Long> mem2 = new HashMap<Long, Long>();

    private static int max;
    private static String mask;


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input14.txt";
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

        if ( line.startsWith("mask") ) {
            mask = line.substring(7);
            max = mask.length();
            System.out.println("msk:" + mask);
            System.out.println("-------");

        } else {
            String memPosStr = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            int memPos = Integer.valueOf(memPosStr);
            doMath(line.substring(line.indexOf("=") + 2), memPos);
        }
    }



    private static void doMath( final String str, final int memPos ) {

        String bin = Integer.toBinaryString(Integer.valueOf(str));
        String memPosBin = Integer.toBinaryString(memPos);
        String res = "";

        for ( int i = memPosBin.length(); i < max; i++ ) {
            memPosBin = "0" + memPosBin;
        }

        for ( int i = bin.length(); i < max; i++ ) {
            bin = "0" + bin;
        }

        // System.out.println(str);

        res = addBinary(memPosBin);

        System.out.println("bin:" + memPosBin);
        System.out.println("res:" + res);

        rec(res, Long.valueOf(str));

        // res = addBinary(bin);
        // mem[memPos] = Long.parseLong(res, 2);

    }


    private static void rec( final String res, final Long val ) {
        if ( res.contains("X") ) {
            rec(res.replaceFirst("X", "0"), val);
            rec(res.replaceFirst("X", "1"), val);
        } else {
            long mp1 = Long.parseLong(res, 2);
            // mem[(int) mp1] = val;
            mem2.put(mp1, val);
            System.out.println("rec:" + res + " " + mp1);

        }
    }


    private static String addBinary( final String bin ) {
        String res = "";

        for ( int i = 0; i < max; i++ ) {
            String maskVal = mask.substring(i, i + 1);
            String binVal = bin.substring(i, i + 1);

            if ( maskVal.equals("0") ) {
                res += binVal;
            }
            if ( maskVal.equals("1") ) {
                res += maskVal;
            }
            if ( maskVal.equals("X") ) {
                res += "X";
            }
        }

        return res;
    }


    public static void main( final String[] args ) {

        // for ( int i = 0; i < MAXX; i++ ) {
        // mem[i] = 0l;
        // }


        readFile();
        System.out.println("-------");

        long sum = 0;
        // for ( int i = 0; i < MAXX; i++ ) {
        // // System.out.println(i + ": " + mem[i]);
        // sum += mem[i];
        // }

        for ( Entry<Long, Long> l : mem2.entrySet() ) {
            sum += l.getValue();
        }

        System.out.println("sum: " + sum);

    }



}
