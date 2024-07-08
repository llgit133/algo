//package org.example;
//
//
//import org.apache.commons.lang.StringUtils;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        String str = StringUtils.substring(
//                new SimpleDateFormat("MMddHHmmss").format(new Date()),
//                0,
//                -1
//        );
//        System.out.println(str);
//        Long idPrefix = Long.parseLong(str);
////        * 100000;
//        System.out.println(idPrefix);
//
//
//        String[] temp = {"500104", "500105", "500090", "500091", "500092","400350","400352","400356","400353","400355","400351","400354"};
//
//        String gftcode = "4003521";
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"500104", "500105", "500090", "500091", "500092", "400350", "400352", "400356", "400353", "400355", "400351", "400354"}));
//        boolean judge  = list.lastIndexOf(gftcode) > -1;
//
//    }
//}
