package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DaySixteen {


    private static final int MAXX = 100; // 30000000
    private static ArrayList<Rule> arr = new ArrayList<Rule>();

    private static int phase = 1;
    private static int sum = 0;


    static class Rule {
        Rule( final int from, final int to ) {
            this.from = from;
            this.to = to;
        }

        int from;
        int to;
    }



    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input16.txt";
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
        if ( "".equals(line) ) {
            phase = 2;
        }


        if ( phase == 1 ) {
            for ( String s : line.substring(line.indexOf(":") + 1).split("or") ) {
                int row = 1;
                int from = 1;
                int to = 1;
                for ( String s2 : s.split("-") ) {
                    if ( row == 1 ) {
                        from = Integer.valueOf(s2.trim());
                        row++;
                    } else {
                        to = Integer.valueOf(s2.trim());
                    }
                }
                arr.add(new Rule(from, to));

            }

        }

        if ( phase == 3 ) {
            for ( String s : line.split(",") ) {
                Integer val = Integer.valueOf(s);
                if ( !valid(val) ) {
                    sum += val;
                }
            }
        }


        if ( "nearby tickets:".equals(line) ) {
            phase = 3;
        }


    }


    private static boolean valid( final Integer val ) {
        boolean ok = false;
        for ( Rule r : arr ) {
            if ( r.from <= val && val <= r.to ) {
                ok = true;
            }
        }

        return ok;
    }


    public static void main( final String[] args ) {


        readFile();


        for ( Rule r : arr ) {
            System.out.println(r.from + "-" + r.to);
        }

        System.out.println(sum + "-------");


    }


    private static int applyRule( final int i ) {
        return 1;
    }



}
