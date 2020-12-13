package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class DayTen {


    private static Integer[] inputArr = new Integer[1010];
    private static Long[] inputVal = new Long[1010];
    private static Long[] inputRec = new Long[1010];
    private static ArrayList<Integer> inputList = new ArrayList<Integer>();

    private static int ind = 1;
    private static int ind2 = 1;
    private static int lastVal = 0;

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input10.txt";
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
        inputList.add(Integer.valueOf(line));
    }



    public static void main( final String[] args ) {

        readFile();
        Collections.sort(inputList);

        inputArr[0] = 0;
        for ( Integer i : inputList ) {
            inputArr[ind] = i;
            ind++;
        }


        for ( int j = ind - 1; j >= 0; j-- ) {
            inputVal[j] = calc(j);
            System.out.println(j + " " + inputArr[j] + " " + inputVal[j]);
        }

        System.out.println("----------");

        System.out.println(rec(0)); // 9023189417984 +++

    }



    private static Long rec( final int j ) {
        long nodeVal = 0;
        if ( j == ind - 1 ) {
            nodeVal++;
        }
        if ( j < ind - 1 ) {
            for ( int k = 1; k <= inputVal[j]; k++ ) {
                if ( inputRec[j + k] == null ) {
                    nodeVal += rec(j + k);
                } else {
                    nodeVal += inputRec[j + k];
                }
            }
        }
        // System.out.println(j + " " + inputArr[j] + " " + nodeVal);
        inputRec[j] = nodeVal;
        return nodeVal;
    }


    private static Long calc( final int j ) {
        long nodeVal = 1;

        if ( j < ind - 3 ) {
            if ( inputArr[j + 3] == inputArr[j] + 3 ) {
                nodeVal += 2;
            } else if ( inputArr[j + 2] == inputArr[j] + 2 ) {
                nodeVal++;
            }
        } else if ( j < ind - 2 ) {
            if ( inputArr[j + 2] == inputArr[j] + 2 ) {
                nodeVal++;
            }
        }
        return nodeVal;
    }


}
