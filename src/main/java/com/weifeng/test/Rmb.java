package main.java.com.weifeng.test;

import java.text.DecimalFormat;

public class Rmb {
    private static final char[] data = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
    private static final char[] units = { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿' };
    private static final char[] decimalunits = { '厘', '分', '角' };

    public static String convert(double money) {
        StringBuffer sbf = new StringBuffer();
        String result;
        int unit = 0;
        int decimalunit = 0;

        if (money >= 1000000000) {
            result = "数字超出处理范围";
            return result;
        }
        // 保留三位小数
        money = (double) Math.round(money * 1000) / 1000;
        // 不用指数法计数
        DecimalFormat a = new DecimalFormat("##0.000");
        String strmoney = a.format(money);

        int integermoney;
        int decimalmoney;
        // 分离整数部分与小数部分
        if (strmoney.indexOf('.') != 0) {
            integermoney = Integer.parseInt(strmoney.substring(0, strmoney.indexOf('.')));
            decimalmoney = Integer.parseInt(strmoney.substring(strmoney.indexOf('.') + 1, strmoney.length()));
        } else {
            integermoney = (int) money;
            decimalmoney = 0;
        }
        // 小数部分
        while (decimalmoney != 0) {
            sbf.insert(0, decimalunits[decimalunit++]);
            sbf.insert(0, data[decimalmoney % 10]);
            decimalmoney = decimalmoney / 10;
        }
        // 去小数部分的零
        result = sbf.toString().replaceAll("零[厘分角]", "");
        sbf = new StringBuffer();
        // 整数部分
        while (integermoney != 0) {
            sbf.insert(0, units[unit++]);
            sbf.insert(0, data[integermoney % 10]);
            integermoney = integermoney / 10;
        }
        // 去整数部分的零
        if (result == null || result.equals("")) {
            result = sbf.toString().replaceAll("零[拾佰仟]", "零").replaceAll("零{4}万", "零").replaceAll("零+万", "万").replaceAll("零+元", "元").replaceAll("零+",
                    "零") + "整";
        } else {
            result = sbf.toString().replaceAll("零[拾佰仟]", "零").replaceAll("零{4}万", "零").replaceAll("零+万", "万").replaceAll("零+元", "元").replaceAll("零+",
                    "零") + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Rmb rmb = new Rmb();
        System.out.println(rmb.convert(920343010.0561));
    }
}
