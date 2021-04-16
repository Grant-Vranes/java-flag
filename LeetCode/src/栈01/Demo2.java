package 栈01;

import java.util.Stack;

/**
 * 广度扩展普适性:
 * 	给定一个只包括'(',')','{','}','[',']'的字符串，判断字符串是否有效。有效字符串需满足：
 *         1)左括号必须用相同类型的右括号闭合
 *         2)左括号必须以正确的顺序闭合
 *         3)注意空字符串可被认为是有效字符串
 */

public class Demo2 {
    public static void main(String[] args) {
        Demo2 o = new Demo2();//如果是静态方法就不用new对象
        System.out.println(o.isValid("([}}])"));
    }

    public boolean isValid(String s){
        //当字符串为空时，认为是有效字符串
        if(s.length()==0 || s.isEmpty() || s==null){
            return true;
        }
        //如果字符串奇数个，不可能是一个有效的合法字符串
        if(s.length()%2==1){
            return false;
        }
        //核心逻辑
        /*
        Stack<Character> t = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if(c=='(') {
                t.push(c);
            }else if(c==')' && t.peek()=='('){//peek()查看栈顶元素
                if(t.empty()){
                    return false;
                }
                t.pop();
            }

            if(c=='{') {
                t.push(c);
            }else if(c=='}' && t.peek()=='{'){
                if(t.empty()){
                    return false;
                }
                t.pop();
            }

            if(c=='[') {
                t.push(c);
            }else if(c==']' && t.peek()=='['){
                if(t.empty()){
                    return false;
                }
                t.pop();
            }
        }
        return t.empty();
        */

        //简洁周到的核心逻辑
        Stack<Character> t = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                t.push(c);
            } else if (c == '}') {
                if (t.empty() || t.peek() != '{') {
                    return false;
                }
                t.pop();
            } else if (c == ']') {
                if (t.empty() || t.peek() != '[') {
                    return false;
                }
                t.pop();
            } else if (c == ')') {
                if (t.empty() || t.peek() != '(') {
                    return false;
                }
                t.pop();
            } else {
                return false;
            }
        }
        return t.empty();
    }
}
