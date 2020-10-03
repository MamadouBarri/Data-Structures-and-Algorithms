import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackApplication {

    public static boolean balancingSymbols(String s) {
        Set<Character> openingSymbols = new HashSet<>();
        openingSymbols.add('(');
        openingSymbols.add('{');
        openingSymbols.add('[');
        Set<Character> closingSymbols = new HashSet<>();
        openingSymbols.add(')');
        openingSymbols.add('}');
        openingSymbols.add(']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(openingSymbols.contains(c)) {
                stack.push(c);
            } else {
                char poppedChar = stack.pop();
                if(poppedChar != c){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(balancingSymbols("((({}))"));
    }
}
