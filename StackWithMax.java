package DataStructures_Wk1;

import java.util.*;
import java.io.*;

public class StackWithMax {
    class MyStack{
        Stack<Integer> stack = new Stack<Integer>();
        int max;
        public void push( int a){
            if(isEmpty()){
                stack.push(a);
                max = a;
            }else{
                if(a > max){
                    int res = (2*a) - max;
                    max = a;
                    stack.push(res);
                }else{
                    stack.push(a);
                }
            }
        }

        public void pop(){
            int a = stack.pop();
            if(a > max){
                max = (2*max) - a;
            }
        }

        public int getMax(){
            return max;
        }

        public Boolean isEmpty(){
            return stack.isEmpty();
        }
    }

    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        MyStack stack = new MyStack();

        for (int qi = 0; qi < queries; qi++) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.getMax());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }

}
