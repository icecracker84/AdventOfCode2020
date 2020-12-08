package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class DaySeven {

    static TreeNode<String> root = new TreeNode<String>("shinygold");
    static HashMap<String, Integer> map = new HashMap<String, Integer>();


    public static class TreeNode<T> implements Iterable<TreeNode<T>> {

        T data;
        TreeNode<T> parent;
        List<TreeNode<T>> children;
        boolean checked;
        int bags;

        public TreeNode( final T data ) {
            this.data = data;
            this.children = new LinkedList<TreeNode<T>>();
            checked = false;
        }

        public TreeNode<T> addChild( final T child, final int bags ) {
            TreeNode<T> childNode = new TreeNode<T>(child);
            childNode.parent = this;
            childNode.bags = bags;
            this.children.add(childNode);
            return childNode;
        }

        @Override
        public Iterator<TreeNode<T>> iterator() {
            // TODO Auto-generated method stub
            return null;
        }

        public boolean has( final TreeNode<T> node, final TreeNode<T> nodeToFind ) {
            if ( node.data == nodeToFind.data ) {
                return true;
            } else {
                for ( TreeNode<T> child : node.children ) {
                    return node.has(child, nodeToFind);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ret.append((String) this.data).append("\n");
            toStringRec(this, ret);
            return ret.toString();
        }

        public void toStringRec( final TreeNode<T> node, final StringBuilder ret ) {

            for ( TreeNode<T> child : node.children ) {
                ret.append((String) child.data).append("\n");
                node.toStringRec(child, ret);
            }

        }

    }

    private static void readFile( final TreeNode<String> rootNode ) {
        String file = "c:\\Users\\gelencserd\\Documents\\JAVA\\calendar2020\\src\\calendar\\input7.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ( line != null ) {
                process(line, rootNode);
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    private static void process( final String line, final TreeNode<String> rootNode ) {
        String workData = line.replaceAll("bags", "").replaceAll("bag", "").replaceAll(" ", "").replaceAll("contain", "=").replaceAll("\\.", "");



        int ind = 0;
        String currRoot = "";

        for ( String part : workData.split("=") ) {
            ind++;
            if ( ind == 1 ) {
                currRoot = part;
                // System.out.println(currRoot);
            } else {
                for ( String child : part.split(",") ) {
                    String numbers = child.replaceAll("[^0-9]+", "");
                    String node = child.replaceAll("[0-9]+", "");

                    if ( node.equals(rootNode.data) ) {
                        // int nr = 0;
                        // for ( int i = 0; i < numbers.length(); i++ ) {
                        // nr += Integer.valueOf(numbers.substring(i, i + 1));
                        // }
                        rootNode.addChild(currRoot, Integer.valueOf(numbers));
                        System.out.println(currRoot + " " + numbers);

                    }
                }
            }
        }

        // root
    }



    public static void main( final String[] args ) {


        /*
         * TreeNode<String> node0 = root.addChild("node0"); TreeNode<String> node1 = root.addChild("node1"); TreeNode<String> node2 =
         * root.addChild("node2"); { TreeNode<String> node20 = node2.addChild(null); TreeNode<String> node21 = node2.addChild("node21"); {
         * TreeNode<String> node210 = node20.addChild("node210"); } }
         */

        // readFile(root);
        recurse(root, 1);

        // System.out.println("--------------------");
        /*
         * for ( TreeNode<String> child : root.children ) { for ( TreeNode<String> child2 : child.children ) { for ( TreeNode<String> child3 :
         * child2.children ) { for ( TreeNode<String> child4 : child3.children ) { for ( TreeNode<String> child5 : child4.children ) { for (
         * TreeNode<String> child6 : child5.children ) { map.put(child6.data, 1); // System.out.println("5: " + child5.data); } map.put(child5.data,
         * 1); // System.out.println("5: " + child5.data); } map.put(child4.data, 1); // System.out.println("4: " + child4.data); }
         * map.put(child3.data, 1); // System.out.println("3: " + child3.data); } map.put(child2.data, 1); // System.out.println("2: " + child2.data);
         * } map.put(child.data, 1); // System.out.println(child.data); }
         */
        System.out.println("--------------------");

        int cnt = 0;
        int sum = 0;
        Iterator it = map.entrySet().iterator();
        while ( it.hasNext() ) {
            // System.out.println(it.next());
            cnt++;
            Entry<String, Integer> e = (Entry<String, Integer>) it.next();
            System.out.println(e.getKey() + " " + e.getValue());
            sum += e.getValue();
        }
        System.out.println("c: " + cnt + " s:" + sum);// 365+ 372-OK 373X 594-

    }


    private static void recurse( final TreeNode<String> node, final int limit ) {

        if ( !node.checked ) { // root.has(root, node)
            readFile(node);
            node.checked = true;
            map.put(node.data, node.bags);
        }

        if ( limit < 200 ) {
            for ( TreeNode<String> child : node.children ) {
                recurse(child, limit + 1);
            }
        }
    }



}
