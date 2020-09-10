package com.company;
import java.io.*;
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
            System.out.println(auxVal);
            st.push(auxVal);
        }
        System.out.println("SIZE: " + st.size());
        System.out.println("TOP: " + st.peek());
        System.out.println("STACK: " + st.toString());
    }

    public static void main(String[] args) {
        String strExpr =  "4 2 / 5 + 8 - 7 2 / +";
        strExpr = strExpr.replaceAll("\\s+", "");
        char[] chars = strExpr.toCharArray();
        eval(chars);
    }
}
