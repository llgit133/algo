package org.example;

public class test {
    private static String NEW_SPLIT = new String(new byte[]{5});



    public static void main(String[] args) {

        String fileNameAll = "DAPM_MSS_INCOME_E_RECORD.$workOrderId$.$operDate$.$acctMonth$.$repeatCount$.$fileBatch$.$batchSerial$.401;DAPM_MSS_INCOME_APPROVAL.$operDate$.$acctMonth$.$repeatCount$.$fileBatch$.$batchSerial$.401";

        String[] fileNameList = fileNameAll.split(";");
        String[] cellCode = {fileNameList[0].split("\\.")[0], fileNameList[1].split("\\.")[0]};

        System.out.println((fileNameList[0] + ".gz" + NEW_SPLIT + "0" + NEW_SPLIT + "1" + NEW_SPLIT + "202403" + NEW_SPLIT + "\r\n"));

        String name = "DAPM_MSS_INCOME_E_RECORD.A229_ARC0001_B450_2024_03_033734.20240507.202403.12.218.001.401.GZ";
        String replace_name = name.replace("GZ", "gz");
        System.out.println("replace_name : "+ replace_name);

        String ssgtx = "计列2017年01月中国电信大数据精准营销服务销售合同 - 深圳优网收入(HQYJS1600330CGN00)";
        String qqq = "计";
        System.out.println(qqq.length());
        System.out.println(ssgtx.length());

        int ssgtxtCount = 20;
        String resultInfo = "ssgtxt字段超长50的行项有" + ssgtxtCount + "行、" + "请检查处理后重新导入！！";
        System.out.println(resultInfo);

    }
}
