package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayFourteen {


    private static final int MAXX = 65565;
    private static Long[] mem = new Long[MAXX];
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
        String res = "";
        int len = bin.length();

        for ( int i = bin.length(); i < max; i++ ) {
            bin = "0" + bin;
        }

        // System.out.println(str);

        res = addBinary(bin, len);

        System.out.println("bin:" + bin);
        System.out.println("res:" + res);

        mem[memPos] = Long.parseLong(res, 2);

    }


    private static String addBinary( final String bin, final int len ) {
        String res = "";

        for ( int i = 0; i < max; i++ ) {
            String maskVal = mask.substring(i, i + 1);
            String binVal = bin.substring(i, i + 1);

            if ( maskVal.equals("X") ) {
                res += binVal;
            }
            if ( maskVal.equals("0") || maskVal.equals("1") ) {
                res += maskVal;
            }
        }

        return res;
    }


    public static void main( final String[] args ) {

        for ( int i = 0; i < MAXX; i++ ) {
            mem[i] = 0l;
        }


        readFile();
        System.out.println("-------");

        long sum = 0;
        for ( int i = 0; i < MAXX; i++ ) {
            // System.out.println(i + ": " + mem[i]);
            sum += mem[i];
        }
        System.out.println("sum: " + sum);

    }



}
