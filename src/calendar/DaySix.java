package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DaySix {

    static int cnt = 0;
    private static String group = "";
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    private static int groupNr = 0;



    private static void reset() {
        for ( char alphabet = 'a'; alphabet <= 'z'; alphabet++ ) {
            map.put(String.valueOf(alphabet), 0);
        }
    }

    private static int count( final int number ) {
        int c = 0;
        for ( char alphabet = 'a'; alphabet <= 'z'; alphabet++ ) {
            if ( map.get(String.valueOf(alphabet)) == number ) {
                c++;
            }
        }
        return c;
    }

    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input6.txt";
        BufferedReader br = null;
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ( line != null ) {
                process(line, i);
                i++;
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    private static void process( final String line, final int i ) {

        group = line;
        groupNr++;

        validate(group, groupNr);


        if ( "".equals(line) ) {
            int countThis = count(groupNr - 1);
            System.out.println(groupNr - 1 + " " + countThis);
            cnt += countThis;

            group = "";
            groupNr = 0;

            reset();
        }
    }



    private static void validate( final String line, final int groupNr ) {

        for ( int i = 0; i < line.length(); i++ ) {
            map.put(String.valueOf(line.charAt(i)), map.get(String.valueOf(line.charAt(i))) + 1);
        }
        System.out.println(line);

    }


    public static void main( final String[] args ) {

        reset();
        readFile();

        // 6868 ++
        System.out.println(cnt);

    }



}
