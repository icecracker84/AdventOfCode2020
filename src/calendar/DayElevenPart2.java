package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayElevenPart2 {


    private static String[][] map = new String[100][100];
    private static String[][] mapNext = new String[100][100];


    private static int n = 96;// x - n
    private static int m = 90;// y - m
    // private static int n = 9;// x - n
    // private static int m = 9;// y - m
    private static int xx = 0;

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input11.txt";
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

        for ( int y = 0; y <= m; y++ ) {
            map[xx][y] = (line.substring(y, y + 1));
            mapNext[xx][y] = (line.substring(y, y + 1));
        }
        xx++;
    }



    public static void main( final String[] args ) {
        readFile();
        runStep(2100);
        show();
    }


    private static void runStep( final int nr ) {
        for ( int x = 1; x <= nr; x++ ) {
            findSeat();
            switchMaps();
        }
    }


    private static boolean findSeat() {

        boolean found = false;
        int x = 0;
        int y = 0;

        while ( x <= n ) {
            // empty
            if ( changeSeat(x, y, "#", "L") ) {
                mapNext[x][y] = "L";
            }
            // occupy
            if ( changeSeat(x, y, "L", "#") ) {
                mapNext[x][y] = "#";
            }
            y++;
            if ( y == m + 1 ) {
                y = 0;
                x++;
            }
        }
        return found;

    }


    private static boolean changeSeat( final int x, final int y, final String base, final String next ) {

        int nrofEmptys = 0;
        int nrofOccupied = 0;
        int ind = 1;
        boolean ok = true;
        boolean found = false;

        if ( !map[x][y].equals(base) ) {
            return false;
        }

        // NEXT -0
        while ( !found && ok && x - ind >= 0 ) {
            if ( map[x - ind][y].equals(next) ) {
                ok = false;
            } else if ( map[x - ind][y].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }

        ind = 1;
        ok = true;
        found = false;

        // NEXT 0-
        while ( !found && ok && y - ind >= 0 ) {
            if ( map[x][y - ind].equals(next) ) {
                ok = false;
            } else if ( map[x][y - ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }
        ind = 1;
        ok = true;
        found = false;

        // NEXT --
        while ( !found && ok && y - ind >= 0 && x - ind >= 0 ) {
            if ( map[x - ind][y - ind].equals(next) ) {
                ok = false;
            } else if ( map[x - ind][y - ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }

        ind = 1;
        ok = true;
        found = false;

        // NEXT -+
        while ( !found && ok && y + ind <= m && x - ind >= 0 ) {
            if ( map[x - ind][y + ind].equals(next) ) {
                ok = false;
            } else if ( map[x - ind][y + ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }


        ind = 1;
        ok = true;
        found = false;

        // NEXT ++
        while ( !found && ok && y + ind <= m && x + ind <= n ) {
            if ( map[x + ind][y + ind].equals(next) ) {
                ok = false;
            } else if ( map[x + ind][y + ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }


        ind = 1;
        ok = true;
        found = false;

        // NEXT 0+
        while ( !found && ok && y + ind <= m ) {
            if ( map[x][y + ind].equals(next) ) {
                ok = false;
            } else if ( map[x][y + ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }


        ind = 1;
        ok = true;
        found = false;


        // NEXT +0
        while ( !found && ok && x + ind <= n ) {
            if ( map[x + ind][y].equals(next) ) {
                ok = false;
            } else if ( map[x + ind][y].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }


        ind = 1;
        ok = true;
        found = false;

        // NEXT +-
        while ( !found && ok && y - ind >= 0 && x + ind <= n ) {
            if ( map[x + ind][y - ind].equals(next) ) {
                ok = false;
            } else if ( map[x + ind][y - ind].equals(base) ) {
                found = true;
            }
            ind++;
        }
        if ( ok ) {
            nrofEmptys++;
        }
        if ( found ) {
            nrofOccupied++;
        }


        if ( base.equals("#") ) {
            return nrofOccupied >= 5;
        } else {
            return nrofEmptys == 8;
        }
    }


    private static void show() {
        System.out.println("----------");
        int cnt = 0;
        for ( int x = 0; x <= n; x++ ) {
            for ( int y = 0; y <= m; y++ ) {
                System.out.print(map[x][y]);
                if ( map[x][y].equals("#") ) {
                    cnt++;
                }
            }
            System.out.println();
        }
        System.out.println("----------");
        System.out.println(cnt); // 529 ++

    }

    private static void switchMaps() {
        for ( int x = 0; x <= n; x++ ) {
            for ( int y = 0; y <= m; y++ ) {
                map[x][y] = mapNext[x][y];
            }
        }
    }



}
