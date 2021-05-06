package com.liwx.test.temp;

/**
 * @author liwenxing
 * @date 2021/5/6 下午2:16
 */
public class RMB {
    public static void main(String[] args) {
        String s = toUpper("123,456,789.55");
        System.out.println(s);
    }

    /**
     * 小写转换大写金额
     */
    public static String toUpper(String amount) {
        StringBuffer result = new StringBuffer("");
        String[] tmp = amount.replaceAll(",", "").split("\\.");
        String integer = tmp[0];
        final int LEN = integer.length();
        if (LEN > 12) {
            throw new RuntimeException("太大了 ，处理不了啊！");
        }
        for (int k = 12; k > LEN; k--) {
            integer = "0" + integer;
        }
        int part1 = Integer.parseInt(integer.substring(0, 4));
        int part2 = Integer.parseInt(integer.substring(4, 8));
        int part3 = Integer.parseInt(integer.substring(8, 12));

        if (part1 != 0) {
            result.append(parseInt(part1) + "亿");
        }

        if (part2 != 0) {
            if (part2 < 1000)
                result.append("零");
            result.append(parseInt(part2) + "万");
        } else {
            result.append("零");
        }

        if (part3 != 0) {
            if (part3 < 1000)
                result.append("零");
            result.append(parseInt(part3));
        }
        result.append("元");
        if (tmp.length == 2) {
            result.append(parseFloat(tmp[1]));
        }
        return result.toString();
    }

    /**
     * 解析四位整数转换为中文金额大写
     *
     * @param sStr
     * @return
     */
    public static String parseInt(int i) {
        String[] num = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String result = "";
        int tmp = i;
        if (tmp / 1000 != 0) {
            result += num[tmp / 1000] + "仟";
            tmp = tmp - (tmp / 1000) * 1000;
        }
        if (tmp / 100 != 0) {
            result += num[tmp / 100] + "佰";
            tmp = tmp - (tmp / 100) * 100;
        }
        if (tmp / 10 != 0) {
            result += num[tmp / 10] + "拾";
            tmp = tmp - (tmp / 10) * 10;
        }
        if (tmp != 0)
            result += num[tmp];
        return result;
    }

    /**
     * 解析小数部分
     */
    public static String parseFloat(String sStr) {
        String[] num = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "七", "捌", "玖"};
        String[] unit = {"角", "分"};
        String result = "";

        final int LEN = sStr.length();
        for (int i = 0; i < LEN; i++) {
            String tmp = sStr.substring(i, i + 1);
            int k = Integer.parseInt(tmp);
            result += num[k] + unit[i];
        }
        return result;
    }
}
