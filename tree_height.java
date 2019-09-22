package DataStructures_Wk1;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class Tree{
        int label;
        List<Tree> childTrees = new ArrayList<>();
        Tree(int label){
            this.label = label;
        }
        public void addChild(Tree t){
            this.childTrees.add(t);
        }
        public int getLabel(){
            return label;
        }
        public List<Tree> getChidren(){
            return childTrees;
        }
    }
    public class TreeHeight {
        int parent[];
        List<Tree> treesArray;
        int root;
        int n;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }

            treesArray = new ArrayList<>();
            for(int i = 0; i<n; i++){
                Tree t = new Tree(i);
                treesArray.add(t);
            }
            for(int i = 0; i<n; i++){
                if(parent[i] == -1){
                    root = i;
                }else{
                    treesArray.get(parent[i]).addChild(treesArray.get(i));
                }
            }
        }

        int computeHeight() {
            Queue<Tree> queue = new LinkedList<>();
            Set<Integer> prevLevelNodes = new HashSet<>();
            prevLevelNodes.add(treesArray.get(root).getLabel());
            queue.add(treesArray.get(root));
            int height = 0;
            while(!queue.isEmpty()){
                Tree firstTree = queue.remove();
                int firstTreeLabel = firstTree.getLabel();
                if(prevLevelNodes.contains(firstTreeLabel)){
                    height++;
                    prevLevelNodes.clear();
                }
                for(Tree t:firstTree.getChidren()){
                    prevLevelNodes.add(t.getLabel());
                }
                queue.addAll(firstTree.getChidren());
            }
            return height;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
