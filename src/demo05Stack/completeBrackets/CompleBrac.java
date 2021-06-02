package demo05Stack.completeBrackets;

import java.util.Stack;

public class CompleBrac {
    public static void main(String[] args) {
        String expression = "1+2)*3-4)*5-6)))";
        Stack<String> numStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        int index = 0;
        String exp1 = null;
        String exp2 = null;
        String oper = null;
        char ch = ' ';
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if(isOper(ch)){ //运算符
                operStack.push(ch+"");
            }else if (isBracket(ch)){
                //为右括号，弹出两个表达式和运算符
                exp2 = numStack.pop();
                exp1 = numStack.pop();
                oper = operStack.pop();
                String newExp = "(" + exp1 + oper + exp2 + ")";
                numStack.push(newExp);
            }else {
                //为数字
                numStack.push(ch+"");
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        //numStack中存储了若干表达式，和operStack中的操作符进行组合
        while (true){
            if(operStack.isEmpty()){
                break;
            }
            exp2 = numStack.pop();
            exp1 = numStack.pop();
            oper = operStack.pop();
            String result = exp1 + oper + exp2;
            numStack.push(result);
        }
        System.out.println(numStack.pop());
    }

    public static boolean isOper(char val){
        return val == '+'||val == '-'||val == '*'||val == '/';
    }

    public static boolean isBracket(char val){
        return val == ')';
    }
}
