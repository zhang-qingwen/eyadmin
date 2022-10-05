package com.qingwen.basic.day19;

/**
 * @Author qingwen
 * @Create 2022-10-05 19:31
 * <p>
 * 获取两个zi字符串中最大相同字串，比如：
 * str1 = "abcwerthelloyuioef", str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的字串与较长的串进行比较
 */
public class MaxString {
    public static void main(String[] args) {
        String str1 = "abcwerthelloyuioef";
        String str2 = "cvhellobnm";
        String compareStr = "";
        Boolean maxFlag = false;

        for(int i = str2.length(); i>0; i--){
            for(int j =0; j< str2.length() - i; j++) {
                compareStr = str2.substring(j, i);
                if(str1.contains(compareStr)){
                    maxFlag = true;
                }else maxFlag = false;
            }
            if(maxFlag)
                break;
        }

        if(maxFlag)
            System.out.println(compareStr);
        else
            System.out.println("未找到");
    }
}
