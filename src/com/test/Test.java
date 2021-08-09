package com.test;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));

    }


    /**
     * 输入：s = "is2 sentence4 This1 a3"
     * 输出："This is a sentence"
     * 解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字。
     */
    public static String sortSentence(String s) {
        String[] split = s.split(" ");
        int length = split.length;
        int index;
        String[] sort = new String[length];
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = split[i].charAt(split[i].length() - 1);
            index = c - '0';
            sort[index - 1] = split[i].substring(0, split[i].length() - 1);
        }
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                result.append(sort[i]);
                break;
            }
            result.append(sort[i] + " ");
        }
        return result.toString();
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 输入：nums = [3,4,3,3]
     * 输出：4
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * Implement the function likes which takes an array containing the names of people that like an item.
     * 输入：
     * {} // 输出 "no one likes this"
     * {"Peter"} // 输出 "Peter likes this"
     * {"Jacob", "Alex"} // 输出 "Jacob and Alex like this"
     * {"Max", "John", "Mark"} // 输出 "Max, John and Mark like this"
     * {"Alex", "Jacob", "Mark", "Max"} // 输出 "Alex, Jacob and 2 others like this"
     *
     * @param names
     * @return
     */
    public static String whoLikesIt(String[] names) {
        int length = names.length;
        switch (length) {
            case 0:
                return "no one likes this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + " ," + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + " ," + names[1] + " and " + (length - 2) + " others like this";
        }
    }
}
