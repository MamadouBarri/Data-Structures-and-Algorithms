package com.company;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
Theory:
Infix Expression : Operator between two operands
A + B ; A + B * C
Prefix Expression : Operator before both operands
+ A B; + A * B C
Postfix Expression: Operator after both operands
A B +; A B C * +

With parentheses?
Infix        Prefix      Postfix
(A + B) * C | * + A B C  | A B + C *

Parentheses are only need to Infix notation because the order
of operations within prefix and postfix expressions are completely
determined by the position of the operator and nothing else

 */

public class evalPostFix {

    public static void eval(char[] expr) {
        int index = 0;
        Integer iVal1 = null;
        Integer iVal2 = null;
        Integer auxVal = null;
        Stack st = new Stack();

        for (index = 0; index < expr.length; index++) {
            System.out.println("C: " + expr[index]);
            Character currentChar = Character.valueOf(expr[index]);
            if (!Character.isDigit(currentChar)) {
                iVal1 = (Integer) st.pop();
                iVal2 = (Integer) st.pop();
                switch (expr[index]) {
                    case '+':
                        auxVal = Integer.valueOf(iVal2.intValue() + iVal1.intValue());
                        break;
                    case '-':
                        auxVal = Integer.valueOf(iVal2.intValue() - iVal1.intValue());
                        break;
                    case '*':
                        auxVal = Integer.valueOf(iVal2.intValue() * iVal1.intValue());
                        break;
                    case '/':
                        auxVal = Integer.valueOf(iVal2.intValue() / iVal1.intValue());
                        break;
                }
            } else {
                    auxVal = Integer.valueOf(Character.getNumericValue(currentChar.charValue()));
            }
            st.push(auxVal);
        }
        System.out.println("SIZE: " + st.size());
        System.out.println("TOP: " + st.peek());
    }
    public static boolean isArithmeticOperator(Character c){
        Set<Character> arithmeticOps = new HashSet<>(Arrays.asList('-', '*', '/', '+'));
        return arithmeticOps.contains(c);
    }
    public static void print(String str){
        System.out.println(str);
    }
    public static String infixToPostFix(String infixExpr) {
        // Create Operator Priorities
        Map<Character, Integer> charPriority = new HashMap<>();
        charPriority.put('(', 3);
        charPriority.put('*', 2);
        charPriority.put('/', 2);
        charPriority.put('-', 1);
        charPriority.put('+', 1);
        // Init
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for(char c : infixExpr.toCharArray()) {
            // if ( -> stack
            // if operator -> compare for priority
            // if operand -> output
            if(c == ')' || Character.isDigit(c)){
                if(c == ')'){
                    while(operators.peek() != '('){
                        output.append(operators.pop());
                    }
                    // Remove '('
                    operators.pop();
                } else {
                    output.append(c);
                }
            } else {
                if(operators.empty() || c == '('){
                    operators.push(c);
                } else {
                    List<Character> tmp = new ArrayList<>();
                    print(Integer.toString(operators.size()));
                    while(!operators.empty() && charPriority.get(operators.peek()) >= charPriority.get(c) && operators.peek() != '('){
                        tmp.add(operators.pop());
                    }
                    for(int i = tmp.size() - 1; i >=0; i--){
                        output.append(tmp.get(i));
                    }
                    operators.push(c);
                }
            }
        }
        if(!operators.empty() && operators.peek() != '(') output.append(operators.pop());
        return output.toString();
    }
    public static void main(String[] args) {
        String infixExpr = "( 4 + 2 ) / 2 * (8 + 2)";
        infixExpr = infixExpr.replaceAll("\\s", "");

        String postExpr =  infixToPostFix(infixExpr);
        postExpr = postExpr.replaceAll("\\s+", "");
        char[] chars = postExpr.toCharArray();
        eval(chars);
    }


}
