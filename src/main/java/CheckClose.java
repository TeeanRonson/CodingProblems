import com.sun.deploy.security.CertificateHostnameVerifier;

import java.util.Stack;

public class CheckClose {


    public CheckClose() {

    }



    private boolean readString(String input) {


        Stack<Character> stack = new Stack<>();
        char[] cArray = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            char curr = cArray[i];
            if (curr == ' ') {
                continue;
            }
            if(curr == ')') {
                if(!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            } else if (curr == ']') {
                if(!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            } else if (curr == '}') {
                if(!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(curr);
//            System.out.println(stack);
        }
//        System.out.println(stack);
        return stack.isEmpty();
    }


    public static void main(String[] args) {


        CheckClose cc = new CheckClose();

        System.out.println(cc.readString("{[()]}"));
        System.out.println(cc.readString("[}{]"));
        System.out.println(cc.readString("(){}[]"));
        System.out.println(cc.readString("(((())))"));
        System.out.println(cc.readString("((([]))){}"));
        System.out.println(cc.readString("{(})"));
        System.out.println(cc.readString("[][]{{[}]}}"));


//        Stack<Character> a = new Stack<>();
////        a.push('a');
////        a.push('b');
////        a.push('c');
//        System.out.println(a);
//        System.out.println(a.peek());


    }
}
