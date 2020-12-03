package Lecode.DivideAndRule;

import java.util.ArrayList;
import java.util.List;

public class RP241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String input = "2-1-1";
        List<Integer> res = diffWaysToCompute(input);
        System.out.println();
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        //如果字符串中没有运算符时，为计算出来的数字，添加进结果集
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
            return res;
        }
        //遍历字符串
        for(int i = 0; i < input.length(); i++) {
            //当找到运算符时
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(int left : diffWaysToCompute(input.substring(0, i))) {
                    for (int right : diffWaysToCompute(input.substring(i + 1,input.length()))) {
                        if (input.charAt(i) == '+') {
                            res.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            res.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            res.add(left * right);
                        }
                    }
                }
            }
        }
        return res;
    }
}
