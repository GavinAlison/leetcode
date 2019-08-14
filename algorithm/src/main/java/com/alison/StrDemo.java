package com.alison;

public class StrDemo {

    public static void main(String[] args) {
        String str = "123456";
        char[] s = str.toCharArray();
        StrDemo strDemo = new StrDemo();
        strDemo.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 先处理字符串，将首尾空格都删除；
     * 倒序遍历字符串，当第一次遇到空格时，添加s[i + 1: j]（即添加一个完整单词）；
     * 然后，将直至下一个单词中间的空格跳过，并记录下一个单词尾部j；
     * 继续遍历，直至下一次遇到第一个空格，回到1.步骤；
     * 由于首部没有空格，因此最后需要将第一个单词加入，再return。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        StringBuffer sb = new StringBuffer();
        int i = s.length() - 1, j = s.length();
        while (i > 0) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, j));
                sb.append(' ');
                while (s.charAt(i) == ' ') {
                    i--;//ignore extra spaces between words
                }
                j = i + 1;
            }
            i--;
        }
        return sb.append(s.substring(0, j)).toString();
    }

    public int myAtoi(String str) {
        return -1;
    }

}
