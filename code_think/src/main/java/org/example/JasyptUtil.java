package org.example;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * AES加密工具
 * </p>
 *
 * @author ocean
 * @version 1.0.0
 * @date 2023/5/4 14:51
 */
@Slf4j
public class AESUtils {

    // 秘钥 16
    private static final String SECRET_KEY = "1111111111111111";
    // 秘钥 24
    //private static final String SECRET_KEY = "111111111111111122222222";
    // 秘钥 32
    //private static final String SECRET_KEY = "11111111111111112222222233333333";

    // 算法
    private static final String ALGORITHM = "AES";

    private static final String UTF8 = StandardCharsets.UTF_8.name();

    /**
     * 字符串加密
     *
     * @param message   明文字符串
     * @param secretKey 秘钥
     * @return 加密字符串
     */
    public static String encryption(String message, String secretKey) {
        if (!StringUtils.hasLength(message)) {
            log.error("encryption message should not be null or empty.");
        }
        byte[] encodeBytes = encryption(message.getBytes(StandardCharsets.UTF_8), secretKey);
        return Base64.encodeBase64String(encodeBytes);
    }

    /**
     * 字符串加密
     *
     * @param messageBytes 明文字节数组
     * @param secretKey    秘钥
     * @return 加密字节数组
     */
    public static byte[] encryption(byte[] messageBytes, String secretKey) {
        if (ArrayUtils.isEmpty(messageBytes)) {
            log.error("encryption message should not be empty.");
        }
        if (!StringUtils.hasLength(secretKey)) {
            log.error("secretKey {}, encryption key should not be null or empty.", secretKey);
        }
        Cipher cipher = getCipher(secretKey, Cipher.ENCRYPT_MODE);
        byte[] encryptionBytes = null;
        try {
            encryptionBytes = cipher.doFinal(messageBytes);
        } catch (Exception e) {
            log.error("encryption fail. ", e);
        }
        return encryptionBytes;
    }

    /**
     * 字符串加密
     *
     * @param encryptionMessage 加密字符串
     * @param secretKey         秘钥
     * @return 明文字符串
     */
    public static String decrypt(String encryptionMessage, String secretKey) {
        if (!StringUtils.hasLength(encryptionMessage)) {
            log.error("decrypt encryptionMessage should not be null or empty.");
        }
        byte[] decodeBytes = decrypt(Base64.decodeBase64(encryptionMessage.getBytes(StandardCharsets.UTF_8)), secretKey);
        return new String(decodeBytes, StandardCharsets.UTF_8);
    }


    /**
     * 字符串加密
     *
     * @param encryptedBytes 加密字节数组
     * @param secretKey      秘钥
     * @return 明文字节数组
     */
    public static byte[] decrypt(byte[] encryptedBytes, String secretKey) {
        if (ArrayUtils.isEmpty(encryptedBytes)) {
            log.error("decrypt encryptedBytes should not be empty.");
        }
        if (!StringUtils.hasLength(secretKey)) {
            log.error("secretKey {}, decrypt key should not be null or empty.", secretKey);
        }
        Cipher cipher = getCipher(secretKey, Cipher.DECRYPT_MODE);
        byte[] decodeBytes = null;
        try {
            decodeBytes = cipher.doFinal(encryptedBytes);
        } catch (Exception e) {
            log.error("decrypt fail. ", e);
        }
        return decodeBytes;
    }

    private static Cipher getCipher(String key, int mode) {
        Cipher cipher = null;
        SecretKey secretKey;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            byte[] keyBytes = key.getBytes(UTF8);
            secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
            cipher.init(mode, secretKey);
        } catch (Exception e) {
            log.error("getAESCipher fail. ", e);
        }
        return cipher;
    }

    public static void main(String[] args) {
        String data = "ocean测试!@#";
        log.info("AES秘钥长度只能为16、24、32:{}", SECRET_KEY.getBytes(StandardCharsets.UTF_8).length);
        String encryptionData = encryption(data, SECRET_KEY);
        log.info("加密后:{}", encryptionData);
        String decryptData = decrypt(encryptionData, SECRET_KEY);
        log.info("解密后:{}", decryptData);
    }


}
