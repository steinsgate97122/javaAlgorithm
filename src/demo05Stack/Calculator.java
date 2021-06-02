package demo05Stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "9-17*1+22";
        StackArray2 numStack = new StackArray2(10);
        StackArray2 operStack = new StackArray2(10);
        int index = 0;//扫描指针
        int num1;
        int num2;
        int oper;
        int res;
        String keepNum = "";
        while (true) {
            char ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOperator(ch)) { //判断是否为运算符
                //为运算符
                if (operStack.isEmpty()) {
                    //运算符栈为空，直接push进去
                    operStack.push(ch);
                } else {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //当前运算符的优先级小于等于栈顶的
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1, num2, oper);
                        numStack.push(res);
                        while ((!operStack.isEmpty()) && operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            res = numStack.calc(num1, num2, oper);
                            numStack.push(res);
                        }
                        operStack.push(ch);
                    } else {
                        //当前运算符的优先级大于栈顶的
                        operStack.push(ch);
                    }
                }
            } else {
                //为数字
//                numStack.push(ch - 48);
                keepNum += ch;
                if (index == expression.length() - 1) {
                    //ch已经是最后一个了
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        //是运算符
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index == expression.length()) {
                break;
            }
        }
        //此时扫描指针已经遍历完毕
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("运算式%s=%d", expression, numStack.pop());
    }
}

class StackArray2 {
    private int top = -1;
    private int[] arr;
    private int maxSize;

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public boolean isOperator(char operator) {
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }

    public int calc(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public int peek() {
        return arr[top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = arr[top];
        top--;
        return value;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = value;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public StackArray2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
}

