import java.util.Stack;
public class 有效的括号_20 {
    public static void main(String[] args) {
        String s = "([}}])";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        //当字符串为空，直接返回true
        if(s==null || s.length()==0){
            return true;
        }
        //当字符串长度为奇数时，肯定不成立，直接返回false
        if(s.length()%2 == 1){
            return false;
        }
        Stack<Character> t = new Stack();
        for(int i = 0; i < s.length(); i++){
            //取出字符
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){//当前字符与栈顶字符一定要配对才能pop，不配对，又不是({[中的一个，自然就是(}这种情况，必然返回false
                t.push(c);
            }else if(!t.empty()){
                if(c==')' && t.peek()!='('){
                    return false;
                }
                if(c==']' && t.peek()!='['){
                    return false;
                }
                if(c=='}' && t.peek()!='{'){
                    return false;
                }
                t.pop();
            }else if(t.empty()){
                return false;
            }
        }
        return t.empty();
    }
}
