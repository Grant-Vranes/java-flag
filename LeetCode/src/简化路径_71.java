import java.util.Stack;

public class 简化路径_71 {
    public static void main(String[] args) {
        String s = "/a/./b/../../c/";
        System.out.println(simplifyPath(s));
    }

    public static String simplifyPath(String path) {
        //先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况
        String[] str = path.split("/");
        Stack<String> t = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if(!t.empty() && str[i].equals("..")) {//返回上一目录，要把栈中路径出一个栈
                t.pop();
            }else if(!str[i].equals("") && !str[i].equals(".") & !str[i].equals("..")){//此时即路径入栈
                t.push(str[i]);
            }
        }
        if(t.empty()){//如果栈空，说明最后的结果只能是/
            return "/";
        }

        StringBuffer res = new StringBuffer();//StringBuffer做字符串连接
        for (int i = 0; i < t.size(); i++){
            res.append("/" + t.get(i));
        }
        return res.toString();
    }
}
