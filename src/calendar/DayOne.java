package calendar;

import java.util.ArrayList;

public class DayOne {

    static ArrayList<Integer> elements = new ArrayList<Integer>();
    static ArrayList<Integer> sumArray = new ArrayList<Integer>();


    private static void addElements() {
        elements.add(1918);
        elements.add(1869);
        elements.add(1821);
        elements.add(1852);
        elements.add(1981);
        elements.add(1987);
        elements.add(1989);
        elements.add(1597);
        elements.add(1634);
        elements.add(1537);
        elements.add(1991);
        elements.add(1603);
        elements.add(1543);
        elements.add(1949);
        elements.add(1879);
        elements.add(1800);
        elements.add(1761);
        elements.add(2010);
        elements.add(1810);
        elements.add(1458);
        elements.add(1755);
        elements.add(1938);
        elements.add(1500);
        elements.add(2005);
        elements.add(818);
        elements.add(1493);
        elements.add(1618);
        elements.add(1923);
        elements.add(1283);
        elements.add(1952);
        elements.add(1373);
        elements.add(1605);
        elements.add(1230);
        elements.add(1321);
        elements.add(1873);
        elements.add(1853);
        elements.add(1886);
        elements.add(1372);
        elements.add(1913);
        elements.add(1871);
        elements.add(159);
        elements.add(733);
        elements.add(1400);
        elements.add(1880);
        elements.add(1462);
        elements.add(2007);
        elements.add(1801);
        elements.add(1982);
        elements.add(1728);
        elements.add(1640);
        elements.add(1442);
        elements.add(1525);
        elements.add(1953);
        elements.add(1791);
        elements.add(1906);
        elements.add(1946);
        elements.add(1641);
        elements.add(2009);
        elements.add(1627);
        elements.add(1935);
        elements.add(1936);
        elements.add(1908);
        elements.add(1826);
        elements.add(1291);
        elements.add(1978);
        elements.add(1884);
        elements.add(1799);
        elements.add(1464);
        elements.add(1538);
        elements.add(1365);
        elements.add(1678);
        elements.add(1872);
        elements.add(1964);
        elements.add(1863);
        elements.add(1388);
        elements.add(1912);
        elements.add(1928);
        elements.add(1471);
        elements.add(1632);
        elements.add(1336);
        elements.add(1396);
        elements.add(1948);
        elements.add(1974);
        elements.add(1331);
        elements.add(1290);
        elements.add(1992);
        elements.add(1096);
        elements.add(1889);
        elements.add(1874);
        elements.add(1341);
        elements.add(757);
        elements.add(1351);
        elements.add(1876);
        elements.add(1674);
        elements.add(2002);
        elements.add(1504);
        elements.add(1865);
        elements.add(1469);
        elements.add(1792);
        elements.add(1920);
        elements.add(1925);
        elements.add(1898);
        elements.add(1899);
        elements.add(1435);
        elements.add(405);
        elements.add(1488);
        elements.add(1319);
        elements.add(1322);
        elements.add(1749);
        elements.add(1867);
        elements.add(1957);
        elements.add(1944);
        elements.add(1727);
        elements.add(1293);
        elements.add(1739);
        elements.add(1285);
        elements.add(1917);
        elements.add(1897);
        elements.add(1844);
        elements.add(1966);
        elements.add(1921);
        elements.add(1905);
        elements.add(1830);
        elements.add(1484);
        elements.add(1364);
        elements.add(1782);
        elements.add(1415);
        elements.add(1412);
        elements.add(1413);
        elements.add(833);
        elements.add(1857);
        elements.add(1370);
        elements.add(1890);
        elements.add(1393);
        elements.add(1262);
        elements.add(1311);
        elements.add(2008);
        elements.add(1545);
        elements.add(1896);
        elements.add(1362);
        elements.add(1862);
        elements.add(1617);
        elements.add(1864);
        elements.add(608);
        elements.add(1868);
        elements.add(1689);
        elements.add(1784);
        elements.add(1806);
        elements.add(1976);
        elements.add(1870);
        elements.add(1973);
        elements.add(1993);
        elements.add(1986);
        elements.add(1998);
        elements.add(1414);
        elements.add(1858);
        elements.add(1990);
        elements.add(1841);
        elements.add(1895);
        elements.add(1779);
        elements.add(1850);
        elements.add(2001);
        elements.add(1590);
        elements.add(1902);
        elements.add(1487);
        elements.add(943);
        elements.add(1808);
        elements.add(782);
        elements.add(1546);
        elements.add(2004);
        elements.add(1656);
        elements.add(154);
        elements.add(1661);
        elements.add(1688);
        elements.add(1731);
        elements.add(1466);
        elements.add(1927);
        elements.add(1438);
        elements.add(1387);
        elements.add(1576);
        elements.add(1793);
        elements.add(1797);
        elements.add(1979);
        elements.add(1903);
        elements.add(1638);
        elements.add(1940);
        elements.add(1911);
        elements.add(1301);
        elements.add(1669);
        elements.add(1409);
        elements.add(1578);
        elements.add(1887);
        elements.add(1860);
        elements.add(1619);
        elements.add(1939);
        elements.add(1625);
        elements.add(1941);
        elements.add(1374);
        elements.add(1766);
        elements.add(1407);
    }

    private static void part1() {
        addElements();

        for ( int i : elements ) {
            for ( int j : elements ) {
                if ( i + j == 2020 ) {
                    System.out.println("***i*j: " + i + " " + j + " " + i * j);
                }
            }
        }
    }

    private static void part2() {
        addElements();

        for ( int i : elements ) {
            for ( int j : elements ) {
                for ( int k : elements ) {
                    if ( i + j + k == 2020 ) {
                        System.out.println("***ijk: " + i + " " + j + " " + k + " " + i * j * k);
                    }
                }
            }
        }
    }

    public static void main( final String[] args ) {

        part1();
        part2();
    }



}
