package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DayEleven {


    private static String[][] map = new String[100][100];
    private static String[][] mapNext = new String[100][100];
    private static String[][] mapTmp = new String[100][100];


    private static int n = 96;// x - n
    private static int m = 90;// y - m
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
        runStep(10000);
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
            if ( emptySeat(x, y) ) {
                mapNext[x][y] = "L";
            }
            if ( occupySeat(x, y) ) {
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

    private static boolean emptySeat( final int x, final int y ) {

        int nrofOccupied = 0;

        if ( !map[x][y].equals("#") ) {
            return false;
        }

        if ( x - 1 < 0 ) {
        } else if ( map[x - 1][y].equals("#") ) {
            nrofOccupied++;
        }

        if ( y - 1 < 0 ) {
        } else if ( map[x][y - 1].equals("#") ) {
            nrofOccupied++;
        }

        if ( x - 1 < 0 || y - 1 < 0 ) {
        } else if ( map[x - 1][y - 1].equals("#") ) {
            nrofOccupied++;
        }

        if ( x - 1 < 0 || y + 1 > m ) {
        } else if ( map[x - 1][y + 1].equals("#") ) {
            nrofOccupied++;
        }

        if ( x + 1 > n ) {
        } else if ( map[x + 1][y].equals("#") ) {
            nrofOccupied++;
        }

        if ( y + 1 > m ) {
        } else if ( map[x][y + 1].equals("#") ) {
            nrofOccupied++;
        }

        if ( x + 1 > n || y + 1 > m ) {
        } else if ( map[x + 1][y + 1].equals("#") ) {
            nrofOccupied++;
        }

        if ( x + 1 > n || y - 1 < 0 ) {
        } else if ( map[x + 1][y - 1].equals("#") ) {
            nrofOccupied++;
        }

        return nrofOccupied >= 4;
    }

    private static boolean occupySeat( final int x, final int y ) {

        int nrofEmptys = 0;

        if ( !map[x][y].equals("L") ) {
            return false;
        }

        if ( x - 1 < 0 || map[x - 1][y].equals(".") || map[x - 1][y].equals("L") ) {
            nrofEmptys++;
        }
        if ( y - 1 < 0 || map[x][y - 1].equals(".") || map[x][y - 1].equals("L") ) {
            nrofEmptys++;
        }
        if ( x - 1 < 0 || y - 1 < 0 || map[x - 1][y - 1].equals(".") || map[x - 1][y - 1].equals("L") ) {
            nrofEmptys++;
        }
        if ( x - 1 < 0 || y + 1 > m || map[x - 1][y + 1].equals(".") || map[x - 1][y + 1].equals("L") ) {
            nrofEmptys++;
        }
        if ( x + 1 > n || map[x + 1][y].equals(".") || map[x + 1][y].equals("L") ) {
            nrofEmptys++;
        }
        if ( y + 1 > m || map[x][y + 1].equals(".") || map[x][y + 1].equals("L") ) {
            nrofEmptys++;
        }
        if ( x + 1 > n || y + 1 > m || map[x + 1][y + 1].equals(".") || map[x + 1][y + 1].equals("L") ) {
            nrofEmptys++;
        }
        if ( x + 1 > n || y - 1 < 0 || map[x + 1][y - 1].equals(".") || map[x + 1][y - 1].equals("L") ) {
            nrofEmptys++;
        }
        return nrofEmptys == 8;
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
