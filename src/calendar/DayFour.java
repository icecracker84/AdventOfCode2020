package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFour {


    static class Val {

        public Val( final String name ) {
            this.name = name;
        }

        String name;

        boolean Validate( final String in ) {

            if ( name.substring(1, 2).equals("y") ) {
                if ( in.length() != 4 ) {
                    return false;
                } else if ( name.equals("byr") ) {
                    if ( !(Integer.valueOf(in) >= 1920 && Integer.valueOf(in) <= 2002) ) {
                        return false;
                    } else {
                        allFieldPresent++;
                    }
                } else if ( name.equals("iyr") ) {
                    if ( !(Integer.valueOf(in) >= 2010 && Integer.valueOf(in) <= 2020) ) {
                        return false;
                    } else {
                        allFieldPresent++;
                    }
                } else if ( name.equals("eyr") ) {
                    if ( !(Integer.valueOf(in) >= 2020 && Integer.valueOf(in) <= 2030) ) {
                        return false;
                    } else {
                        allFieldPresent++;
                    }
                }


            } else if ( name.equals("hgt") ) {
                String innerVal = in.substring(0, in.length() - 2);
                if ( in.endsWith("in") ) {
                    if ( !(Integer.valueOf(innerVal) >= 59 && Integer.valueOf(innerVal) <= 76) ) {
                        return false;
                    } else {
                        allFieldPresent++;
                    }
                } else if ( in.endsWith("cm") ) {
                    if ( !(Integer.valueOf(innerVal) >= 150 && Integer.valueOf(innerVal) <= 193) ) {
                        return false;
                    } else {
                        allFieldPresent++;
                    }
                } else {
                    return false;
                }
            } else if ( name.equals("hcl") ) {
                if ( !in.matches("[#]{1}[a-f0-9]{6}") ) {
                    return false;
                } else {
                    allFieldPresent++;
                }
            } else if ( name.equals("ecl") ) {
                if ( !((in.equals("amb")) || (in.equals("blu")) || (in.equals("brn")) || (in.equals("gry")) || (in.equals("grn"))
                    || (in.equals("hzl")) || (in.equals("oth"))) ) {
                    return false;
                } else {
                    allFieldPresent++;
                }
            } else if ( name.equals("pid") ) {
                if ( !in.matches("[0-9]{9}") ) {
                    return false;
                } else {
                    allFieldPresent++;
                }
            }

            return true;
        }
    }


    static ArrayList<Val> validator = new ArrayList<Val>();
    static int cnt = 0;
    static int allFieldPresent = 0;

    private static String passport = "";


    private static void readFile() {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input4.txt";
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

        passport += " " + line;

        if ( "".equals(line) ) {
            validate(passport);
            passport = "";
        }
    }


    private static void validate( final String passport2 ) {

        System.out.println(passport2);
        allFieldPresent = 0;

        for ( String code : passport2.split(" ") ) {
            int i = 0;
            Val v = null;
            for ( String keyVal : code.split(":") ) {
                if ( i == 0 ) {
                    v = new Val(keyVal);
                } else {
                    if ( !v.Validate(keyVal) ) {
                        return;
                    }
                }
                i++;
            }
        }


        if ( allFieldPresent == 7 ) {
            cnt++;
        }
    }


    public static void main( final String[] args ) {

        validator.add(new Val("byr"));
        validator.add(new Val("iyr"));
        validator.add(new Val("eyr"));
        validator.add(new Val("hgt"));
        validator.add(new Val("hcl"));
        validator.add(new Val("ecl"));
        validator.add(new Val("pid"));
        readFile();

        // 284 sum / 256
        System.out.println(cnt);

    }



}
