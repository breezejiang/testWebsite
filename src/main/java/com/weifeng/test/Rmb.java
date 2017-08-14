package main.java.com.weifeng.test;

import java.text.DecimalFormat;

public class Rmb {
    private static final char[] data = { '��', 'Ҽ', '��', '��', '��', '��', '½', '��', '��', '��' };
    private static final char[] units = { 'Ԫ', 'ʰ', '��', 'Ǫ', '��', 'ʰ', '��', 'Ǫ', '��' };
    private static final char[] decimalunits = { '��', '��', '��' };

    public static String convert(double money) {
        StringBuffer sbf = new StringBuffer();
        String result;
        int unit = 0;
        int decimalunit = 0;

        if (money >= 1000000000) {
            result = "���ֳ�������Χ";
            return result;
        }
        // ������λС��
        money = (double) Math.round(money * 1000) / 1000;
        // ����ָ��������
        DecimalFormat a = new DecimalFormat("##0.000");
        String strmoney = a.format(money);

        int integermoney;
        int decimalmoney;
        // ��������������С������
        if (strmoney.indexOf('.') != 0) {
            integermoney = Integer.parseInt(strmoney.substring(0, strmoney.indexOf('.')));
            decimalmoney = Integer.parseInt(strmoney.substring(strmoney.indexOf('.') + 1, strmoney.length()));
        } else {
            integermoney = (int) money;
            decimalmoney = 0;
        }
        // С������
        while (decimalmoney != 0) {
            sbf.insert(0, decimalunits[decimalunit++]);
            sbf.insert(0, data[decimalmoney % 10]);
            decimalmoney = decimalmoney / 10;
        }
        // ȥС�����ֵ���
        result = sbf.toString().replaceAll("��[��ֽ�]", "");
        sbf = new StringBuffer();
        // ��������
        while (integermoney != 0) {
            sbf.insert(0, units[unit++]);
            sbf.insert(0, data[integermoney % 10]);
            integermoney = integermoney / 10;
        }
        // ȥ�������ֵ���
        if (result == null || result.equals("")) {
            result = sbf.toString().replaceAll("��[ʰ��Ǫ]", "��").replaceAll("��{4}��", "��").replaceAll("��+��", "��").replaceAll("��+Ԫ", "Ԫ").replaceAll("��+",
                    "��") + "��";
        } else {
            result = sbf.toString().replaceAll("��[ʰ��Ǫ]", "��").replaceAll("��{4}��", "��").replaceAll("��+��", "��").replaceAll("��+Ԫ", "Ԫ").replaceAll("��+",
                    "��") + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Rmb rmb = new Rmb();
        System.out.println(rmb.convert(920343010.0561));
    }
}
