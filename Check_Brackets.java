package DataStructures_Wk1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Check_Brackets {

    public static class Bracket {
        private char type;
        int pos;
        Bracket(char type, int pos){
            this.type = type;
            this.pos = pos;
        }
        public Boolean match(char c){
            if (this.type == '[' && c == ']')
                return true;
            if (this.type == '{' && c == '}')
                return true;
            if (this.type == '(' && c == ')')
                return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
            InputStreamReader input_stream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(input_stream);
            String text = reader.readLine();
            Stack<Bracket> stack = new Stack<>();

            for(int i = 0; i < text.length(); i++){
                char current_char = text.charAt(i);
                if(current_char == '(' || current_char == '{' || current_char == '['){
                    Bracket br = new Bracket(current_char,i+1);
                    stack.push(br);
                }
                if(current_char == ')' || current_char == '}' || current_char == ']'){
                    if(stack.empty()) {
                        System.out.println(i+1);
                        return;
                    }
                    Bracket bracketOnTopOfStack = stack.peek();
                    if (bracketOnTopOfStack.match(current_char)) {
                        stack.pop();
                    }else {
                        System.out.println(i+1);
                        return;
                    }
                }
            }
            if(stack.empty()){
                System.out.println("Success");
            }else{
                System.out.println(stack.peek().pos);
            }
    }
}


