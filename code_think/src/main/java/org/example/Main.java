package org.example;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



        String aa = "        at java.lang.Thread.run(Thread.java:748)\n" +
                "2024-05-22 10:49:35.704 [http-nio-9090-exec-23] ERROR com.asiainfo.filter.MCSSOFilter - USSOFilter-Error\n" +
                "java.lang.RuntimeException: MSS云认证用户在本地系统不存在！71156707@VZ\n" +
                "        at com.asiainfo.filter.MCSSOFilter.updateUser(MCSSOFilter.java:202)\n" +
                "        at com.asiainfo.filter.MCSSOFilter.doFilter(MCSSOFilter.java:99)\n" +
                "        at com.asiainfo.controller.IncomeLoginController.main(IncomeLoginController.java:81)";
        System.out.println(aa.length());


        String str = "5";
        try {
            double d = Double.parseDouble(str);
            int num = (int) d; // 或使用 Math.round(d) 根据需求选择
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.err.println("无法将字符串转换为数字: " + e.getMessage());
        }



        String value = "income-warn-0.log";
        //区分处理以日期格式命名的文件 （如 income-warn-2024-06-07.0.log）和不包含日期格式的文件（如 income-warn.log）
        Pattern genericPattern = Pattern.compile("^([a-z]+-[a-z]+)-(\\d{4}-\\d{2}-\\d{2})\\.(\\d+)\\.log$");
        Matcher matcher = genericPattern.matcher(value);
        if (matcher.matches()) {
            System.out.println("匹配成功");
        }

        String localPathIncome = "/data/weblogic/income_pg/ailk-income/logs/";
        String localPathApi = "/data/weblogic/income_pg/ailk-income-api/logs/";

        String localPath = "/data/weblogic/income_pg/ailk-income/logs/";
        if (localPath.equals(localPathIncome)) {
            System.out.println("---111---");
        } else if (localPath.equals(localPathApi)) {
            System.out.println("---222---");
        }


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        String billCode ="0099002009_B197_202311_0082819";
        String billCode ="0099002009_FT_S_05_202311_0082819";

        String busiTypeCode_momth = billCode.substring(billCode.indexOf("_") + 1 , billCode.lastIndexOf("_") );
        String busiTypeCode = busiTypeCode_momth.substring(0, busiTypeCode_momth.lastIndexOf("_"));
        System.out.println(busiTypeCode_momth);
        System.out.println(busiTypeCode);





    }
}
