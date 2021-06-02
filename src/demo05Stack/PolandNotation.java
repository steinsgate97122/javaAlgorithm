package demo05Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//        String expression = "3.1 4 + 5 * 6 -";
//        List<String> list = getListString(expression);
//        double calculate = calculate(list);
//        System.out.println("运算结果为：" + calculate);
        String expression = "1.1+((2+3)*4)-5.5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> suffixEx = parseSuffixExpressionList(list);
        System.out.println(suffixEx);
        System.out.printf("运算式%s的结果=%.2f\n",expression,calculate(suffixEx));
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            if (item.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
                // 是数字就直接压进s2
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //左括号也弹出去
            } else { //只剩下运算符了
                // 要比较优先级
                while (s1.size() != 0 && !s1.peek().equals("(") && (Operation.getValue(s1.peek()) >= Operation.getValue(item))) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //扫描完毕后，把s1剩下的都pop给s2
        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //将字符串转化为集合形式
    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        char c; //用来接收字符
        while (index < s.length()) {
            c = s.substring(index, index + 1).charAt(0);
            if ((c < '0' || c > '9') && (c != '.')) { //c不是数字，直接add进去
                list.add("" + c);
                index++;
            } else {
                String str = "";
                while ((index < (s.length() - 1)) && ((c = s.substring(index, index + 1).charAt(0)) >= '0' && (c = s.substring(index, index + 1).charAt(0)) <= '9') || ((c = s.charAt(index)) == '.')) {
                    str += c;
                    index++;
                }
                if (index == s.length() - 1) {
                    str += s.substring(index, index + 1).charAt(0);
                    index++;
                }
                list.add(str);
            }
        }
        return list;
    }

    //将后缀表达式从字符串转化为集合
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        return new ArrayList<String>(Arrays.asList(split));
    }

    public static double calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) { //数字
                stack.push(item);
            } else { //运算符
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("符号不正确");
                }
                stack.push("" + res);
            }
        }
        return Double.parseDouble(stack.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println(operation);
        }
        return res;
    }
}