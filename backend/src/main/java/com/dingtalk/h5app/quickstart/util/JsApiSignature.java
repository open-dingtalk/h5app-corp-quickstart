package com.dingtalk.h5app.quickstart.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import com.dingtalk.h5app.quickstart.exception.DingtalkEncryptException;

/**
 * 钉钉jsapi签名工具类
 *
 * @author openapi@dingtalk
 * @date 2020/2/4
 */
public class JsApiSignature {
    public static String sign(String url, String nonce, Long timestamp, String ticket)
        throws DingtalkEncryptException {
        String plain = String.format(
            "jsapi_ticket=%s&noncestr=%s&timestamp=%d&url=%s",
            ticket, nonce, timestamp, url);
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.reset();
            sha1.update(plain.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(sha1.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new DingtalkEncryptException(DingtalkEncryptException.COMPUTE_SIGNATURE_ERROR, e);
        }
    }

    /**
     * 模拟生成随机 nonce 字符串
     * @return 随机字符串
     */
    public static String genNonce() {
        return bytesToHex(Long.toString(System.nanoTime()).getBytes(StandardCharsets.UTF_8));
    }

    private static String bytesToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash){
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
