package org.example;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtil {
    /**
     * Jasypt生成加密结果
     *
     * @param salt 配置文件中设定的加密盐值
     * @param value    加密值
     * @return
     */
    public static String encryptPwd(String salt, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryPTor(salt));
        String result = encryptor.encrypt(value);
        return result;
    }

    /**
     * 解密
     *
     * @param salt 配置文件中设定的加密盐值
     * @param value    解密密文
     * @return
     */
    public static String decyptPwd(String salt, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryPTor(salt));
        String result = encryptor.decrypt(value);
        return result;
    }

    public static SimpleStringPBEConfig cryPTor(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    //盐可以自己设置（中文好像不能用）
    static final String SALT = "income";

    //随便写个main方法试试
    public static void main(String[] args) {
        // 加密
        String encPwd = JasyptUtil.encryptPwd(SALT, "12345678");
        System.out.println("加密后的值为:"+ encPwd);

        // 解密
        String decPwd = JasyptUtil.decyptPwd(SALT, "ivvEH0y8vmexO0EozwlP+jqUGr6XhLuy");
        System.out.println("解密后的值为:"+ decPwd);
    }
}
