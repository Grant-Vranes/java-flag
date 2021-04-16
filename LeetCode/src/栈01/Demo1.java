package 栈01;

import java.util.Stack;

/**例1：
 * 字符串中只有字符'('和')'，合法字符串需要括号可以配对，比如：(),(())
 * 像((,)),)( 等等都是不合法的
 */
public class Demo1 {

    public static void main(String[] args) {
        Demo1 o = new Demo1();
        System.out.println(o.isValid(")("));
    }

    public boolean isValid(String s){
    //当字符串本来就是空的时候，我们可以快速返回true
         if(s==null || s.length()==0){
        return true;
    }
    //当字符串长度为奇数时，不可能是一个有效的合法字符串
        if(s.length()%2 == 1){
        return false;
    }
    //消除法的主要核心逻辑
        Stack<Character> t = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){//压栈
                t.push(c);
            }else if(c==')'){//弹栈
                if(t.empty()){
                    return false;
                }
                t.pop();
            }

        }
        return t.empty();
    }

    /**深度优化解法：栈中存放内容一样，并且有消除特性，我们可以使用leftBraceNumber的加和减来代替入栈和出栈
    public boolean isValid(String s){
        //当字符串本来就是空的时候，我们可以快速返回true
        if(s==null || s.length()==0){
            return true;
        }
        //当字符串长度为奇数时，不可能是一个有效的合法字符串
        if(s.length()%2 == 1){
            return false;
        }
        //消除法的主要核心逻辑
        int leftBraceNumber = 0;
        for(int i=0; i<s.length(); i++){
            //取出字符
            char c = s.charAt(i);
            if(c=='('){//压栈
                leftBraceNumber++;
            }
            if(c==')'){//弹栈
                if(leftBraceNumber<=0){
                    return false;//如果弹栈失败
                }
                --leftBraceNumber;
            }
        }
        return leftBraceNumber==0;//
    }
     */
}
