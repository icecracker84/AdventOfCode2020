package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DaySixteenPart2 {


    private static ArrayList<Rule> arr = new ArrayList<Rule>();
    private static ArrayList<Ticket> validArr = new ArrayList<Ticket>();

    private static int phase = 1;


    static class Rule {
        Rule( final int from, final int to, final String name, final int from2, final int to2 ) {
            this.from = from;
            this.to = to;
            this.from2 = from2;
            this.to2 = to2;
            this.name = name;
            posMap = new ArrayList<Integer>();
        }

        ArrayList<Integer> posMap;
        int pos;
        int from;
        int to;
        int from2;
        int to2;
        String name;
    }


    static class Ticket {
        Ticket() {
            arr = new ArrayList<Integer>();
        }

        ArrayList<Integer> arr;
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
            int row = 1;
            int from = 1;
            int to = 1;
            int from2 = 1;
            int to2 = 1;

            for ( String s : line.substring(line.indexOf(":") + 1).split("or") ) {
                for ( String s2 : s.split("-") ) {
                    if ( row == 1 ) {
                        from = Integer.valueOf(s2.trim());
                    } else if ( row == 2 ) {
                        to = Integer.valueOf(s2.trim());
                    } else if ( row == 3 ) {
                        from2 = Integer.valueOf(s2.trim());
                    } else if ( row == 4 ) {
                        to2 = Integer.valueOf(s2.trim());
                    }
                    row++;
                }

            }
            arr.add(new Rule(from, to, line.substring(0, line.indexOf(":")), from2, to2));


        }

        if ( phase == 3 ) {
            boolean ok = true;
            Ticket ticket = new Ticket();
            for ( String s : line.split(",") ) {
                Integer val = Integer.valueOf(s);
                ticket.arr.add(val);

                if ( !valid(val) ) {
                    ok = false;
                }
            }
            if ( ok ) {
                validArr.add(ticket);
            }
        }


        if ( "nearby tickets:".equals(line) ) {
            phase = 3;
        }


    }


    private static boolean valid( final Integer val ) {
        boolean ok = false;
        for ( Rule r : arr ) {
            if ( (r.from <= val && val <= r.to) || (r.from2 <= val && val <= r.to2) ) {
                ok = true;
            }
        }

        return ok;
    }



    private static boolean validFor( final int ruleIndex, final int index ) {
        boolean ok = true;
        Rule r = arr.get(ruleIndex);
        // System.out.println("r:" + r.name + " " + r.from + " " + r.to + " " + r.from2 + " " + r.to2);

        for ( Ticket ticket : validArr ) {
            Integer t = ticket.arr.get(index);
            // System.out.print("t: " + t + " ");

            if ( !((r.from <= t && t <= r.to) || (r.from2 <= t && t <= r.to2)) ) {
                ok = false;
            }

        }

        if ( ok ) {
            r.posMap.add(index);
        }
        return ok;
    }



    public static void main( final String[] args ) {


        readFile();

        for ( int x = 0; x < arr.size(); x++ ) {
            for ( int y = 0; y < arr.size(); y++ ) {
                validFor(x, y);
                // System.out.println("");
            }
        }


        for ( int i = 0; i < arr.size(); i++ ) {
            calcPos();
        }
        show();
        System.out.println("-------"); // 32760++ 1032700701541-- 514662805187


    }


    private static void calcPos() {
        Integer toRemove = 0;
        for ( Rule r : arr ) {
            // System.out.print(r.name + ": ");
            if ( r.posMap.size() == 1 ) {
                for ( Integer i : r.posMap ) {
                    r.pos = i;
                    toRemove = i;
                    // System.out.println("pos: " + r.pos + "");
                }
                r.posMap.clear();
            }
        }
        for ( Rule r : arr ) {
            r.posMap.remove(toRemove);
        }


    }

    private static void show() {
        for ( Rule r : arr ) {
            System.out.print(r.name + ": ");
            for ( Integer i : r.posMap ) {
                System.out.print(i + " ");
            }
            System.out.println("pos: " + r.pos + "");
        }
    }



}
