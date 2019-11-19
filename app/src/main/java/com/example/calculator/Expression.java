package com.example.calculator;

import android.util.Log;

import java.util.Stack;

public class Expression {

    //将输入的infix中缀表达式换成后缀表达式，并返回这个后缀表达式
    public static StringBuffer toPostfix(String infix)
    {
        Stack<String> stack=new Stack<String>();//设置字符栈
        StringBuffer posfix=new StringBuffer(infix.length()*2);//设置后缀表达式可变字符串

        int i=0;//字符下标

        while(i<infix.length())
        {
            char ch=infix.charAt(i);//返回字符串中的单个字符
            switch (ch) {

                //将获得的字符和每一个栈顶元素进行比较
                case'^':
                    while (!stack.isEmpty()&&stack.peek().equals('^'))
                    {
                        posfix.append(stack.pop());
                    }
                    stack.push(ch+"");
                    i++;
                    break;

                case 'l':
                    while (!stack.isEmpty()&& (stack.peek().equals("^")))
                    {
                        posfix.append(stack.pop());
                    }
                   String s=ch+"";
                    i++;
                    s=s+infix.charAt(i);
                    stack.push(s);
                    i++;
                    break;

                case 's':
                case 'c':
                case 't':
                    while (!stack.isEmpty()&& (stack.peek().equals("^")))
                    {
                        posfix.append(stack.pop());
                    }
                    String st=ch+"";
                    for (int a=0;a<2;a++)
                    {
                        i++;
                        st=st+infix.charAt(i);
                    }
                    stack.push(st);
                    i++;
                    break;

                case '+':case'-':
                    while(!stack.isEmpty()&&!stack.peek().equals("("))
                    {
                        posfix.append(stack.pop());//append方法是用来向字符缓冲区追加字符
                    }
                    stack.push(ch+"");
                    i++;
                    break;
                case'*':case'/':case '%':
                    while(!stack.isEmpty()&&!(stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("(")))
                        posfix.append(stack.pop());
                    stack.push(ch+"");
                    i++;
                    break;
                case'(':
                    stack.push(ch+"");
                    i++;
                    break;

                //如果是右括号，那么要将和栈内的元素一一比较，直到出栈运算符为左括号为止
                case')':
                    String out=stack.pop();
                    while(out!=null&&!out.equals("("))
                    {
                        posfix.append(out);
                        out=stack.pop();
                    }
                    i++;
                    break;

                default:
                    while (i<infix.length()&&( ch>='0'&&ch<='9'||ch=='Π'||ch=='e'||ch=='.')) {
                        posfix.append(ch);
                        i++;
                        if (i<infix.length()) {
                            ch=infix.charAt(i);
                        }
                    }
                    posfix.append(" ");//添加一个空格作为数字和符号之间的分隔符
            }
        }
        while (!stack.isEmpty()) {
            posfix.append(stack.pop());//将所有运算符出栈
        }
        return posfix;
    }

//将字符数据转化为数值
    double value = 0.0;
    public double translate(String str){
        int flag = 1;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '.') {
                flag = -1;
                continue;
            }
            else if (flag == 1) {
                value = value * 10 + str.charAt(i) - '0';
            }else {
                value = value + Math.pow(10, flag) * (str.charAt(i) - '0');
                System.out.println(value);
                flag--;
            }
        }
        return value;
    }

    //计算所得的后缀表达式的值：
    public String ToValue(StringBuffer posfix) {

        Stack<Double> stack=new Stack<Double>();//创造一个操作数的链式栈实例
        int flag = -1;
        double value=0;
        for(int i=0;i<posfix.length();i++) {
            char ch = posfix.charAt(i);
            //遇到数字
            value = 0;
            if (ch == 'Π') {
                value = 3.14159265;
                stack.push(value);
            } else if (ch == 'e') {
                Log.e("e 入栈了吗", "执行");
                value = 2.71828182;
                stack.push(value);
            }
           else if (ch >= '0' && ch <= '9'||ch=='.') {
                value=0;
                while (ch != ' ') {
                    value = value * 10 + ch - '0';//将整数字符转换成int型整数值
                    ch = posfix.charAt(++i);
                    if (ch=='.')
                    {
                        i++;
                        ch=posfix.charAt(i);
                        while (ch!=' ') {
                            value = value + Math.pow(10, flag) * (posfix.charAt(i) - '0');
                            flag--;
                            ch = posfix.charAt(++i);
                        }
                    }
                }
            stack.push(value);//数字入栈
            flag=-1;
        }
            //遇到运算符
            else {
                if (ch!=' ') {
                    if (ch =='l')
                    {
                        String c=ch+"";
                        i++;
                        c=c+posfix.charAt(i);
                        double m=stack.pop();
                        switch (c){
                            case "lg":value=Math.log10(m);break;
                            case "ln":value=Math.log(m);break;
                        }
                        Log.e("v",String.valueOf(value));
                        stack.push(value);
                    }else if (ch=='s'||ch=='c'||ch=='t')
                    {
                        String d=ch+"";
                        for (int a=0;a<2;a++)
                        {
                            i++;
                            d=d+posfix.charAt(i);
                        }
                        Log.e("oper",d);
                        double n=stack.pop();
                        Log.e("nStart",String.valueOf(n));
                        n=Math.toRadians(n);
                        Log.e("n",String.valueOf(n));
                        switch (d)
                        {

                            case "sin":value=Math.sin(n); break;
                           // Log.e("sin", String.valueOf(value));
                            case "cos":value=Math.cos(n);break;
                            case "tan":value=Math.tan(n);break;
                        }
                        Log.e("结果",String.valueOf(value));
                        stack.push(value);
                    }else {
                        //出栈两个操作数
                        double y = stack.pop();
                        double x = stack.pop();

                        //根据运算符进行计算
                        switch (ch) {
                            case '^':
                                value = Math.pow(x,y);
                                break;
                            case '+':
                                value = x + y;
                                break;
                            case '-':
                                value = x - y;
                                break;
                            case '%':
                                value = x -(x/y)*y;
                                break;
                            case '*':
                                value = x * y;
                                break;
                            case '/':
                                value = x / y;
                                break;
                        }
                        stack.push(value);//运算结果入栈
                    }

                }
            }
        }
        double result= stack.pop();//返回最后的运算结果
        return String.format("%.2f",result);
    }

}
