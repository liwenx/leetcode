package com.liwx.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liwenxing
 * @date 2018/11/26 23:27
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);

        String temp = "";
        for(int i = 0; i < s.length(); i ++) {
            if (temp.length() > 0) {
                if (map.get(temp.charAt(temp.length() -1)) + map.get(s.charAt(i)) == 0) {
                    temp  = temp.substring(0, temp.length() - 1);
                } else {
                    temp = temp + s.charAt(i);
                }
            } else {
                temp = temp + s.charAt(i);
            }
        }
        if (temp.length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * the faster one
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || stack.pop()!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();


    }

}
