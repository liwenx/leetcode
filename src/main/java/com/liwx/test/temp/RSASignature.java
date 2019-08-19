package com.liwx.test.temp;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.UrlBase64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * @author liwenxing
 * @date 19-6-4 下午4:58
 */


/**
 *
 * 引入包
 *
 *         <!-- https://mvnrepository.com/artifact/commons-codec/commons-codec -->
 *         <dependency>
 *             <groupId>commons-codec</groupId>
 *             <artifactId>commons-codec</artifactId>
 *             <version>1.4</version>
 *         </dependency>
 *
 *
 *
 *         <!-- https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk16 -->
 *         <dependency>
 *             <groupId>org.bouncycastle</groupId>
 *             <artifactId>bcprov-jdk16</artifactId>
 *             <version>1.46</version>
 *         </dependency>
 *
 */

public class RSASignature {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
    public static final String ENCODING = "utf-8";

    /**
     * 获取私钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key.getBytes(ENCODING));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
    /**
     * RSA私钥签名
     *
     * @param content    待签名数据
     * @param privateKey 私钥
     * @return 签名值
     */
    public static String signByPrivateKey(String content, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(priKey);
            signature.update(content.getBytes(ENCODING));
            byte[] signed = signature.sign();
            return new String(UrlBase64.encode(signed), ENCODING);
        } catch (Exception e) {
//            LOGGER.warn("sign error, content: {}, priKey: {}", new Object[]{
//                    content, privateKey
//            });
//            LOGGER.error("sign error", e);
        }
        return null;
    }


    /**
     * 获取公钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(keyBytes));
        return pubKey;
    }

    /**
     * RSA公钥验签，签名UrlBase64编码
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 公钥, 是用了Base64编码的
     * @return 布尔值
     */
    public static boolean verifySignByPublicKey(String content, String sign, String publicKey) {
        try {
            PublicKey pubKey = getPublicKey(publicKey);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(ENCODING));
            return signature.verify(UrlBase64.decode(sign.getBytes(ENCODING)));
        } catch (Exception e) {
//            LOGGER.error("sign error, content: {}, sign:len:{},{}, pubKey: {}",
//                    new Object[]{content, sign.length(), sign, publicKey});
//            LOGGER.error("sign error", e);
        }
        return false;
    }

    /**
     * map转json字符串  按照key值升序排序
     * @param map
     * @return
     */
    private static String map2String (Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        List<Map.Entry<String,Object>> list = new ArrayList<>(map.entrySet());
        //升序排序
        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
        StringBuffer sb = new StringBuffer("{");
        for(Map.Entry<String,Object> mapping:list){
            sb.append("\"").append(mapping.getKey()).append("\":\"").append(mapping.getValue()).append("\",");
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ0PKSlbduiPMNgAEjiE6E5uSOrA81sSPVGt4FA3J0oCavjrWUpsSuCYMMCMH5uU3sTObTLsUsSGp++BpGxzpCkZEG4Ixf/8cOoEr1+N9T605HpG/bTpAWSlkmPYwiNWBlRVpBEH2xDiRFOTtT2Yw6Yq6hPuW3qrPbK819j93MXnAgMBAAECgYAbY7p06Ot6sQX+lTyYOK1eiCMVNWL7HdottVnqA0RJxtQq5rgin3ILat8NpSIZ+sNCpREsEUR521XMEdq/wwb8j9XasHSn/Jx7XrpQlp2cqo3x/yHfka6zoeozQ2K2svl5ypEqThTx3GM3CLPN3yLvd8rwxapDTdArWV9rJs79YQJBAP8cI3/bWgFSbAO9LPY48l31xQEcA/SCE11EWLHWi4U3jXIxpb3sUXMrzkFeNs0S/Ukg48BVWA4zHA+2Bc36/jcCQQCdm3G/snvXlWMqMKOwCL1/FJhamo7lWXS0QApD7X68Tv60ylxuwFDMDPQQn9sS5r15D4gEBlZmCnNXNtLYkR3RAkAXv7HaVDxDxT2C95h474I4lwmY+dewam+NDjDHlXZ1l19WkyKf1KEcfKZ91Vx6qNrldOde31MMN1vUZpiRvVzvAkBPnOLjs7QtHVAfUryMwo1+cRfYxLQkFIEIQEUvNPvNAZZWGtaAN3NY774l26odLSNO0NKjPdRM7UCAMLhnHz7RAkAduo5wkIK/WuV6eu1Qre0sbzob48cTxBaZ2oHmfYXcQ3RRoj5+MNJCWCR7ALC+0IZc23TU83TKTx0I55txVL0J";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdDykpW3bojzDYABI4hOhObkjqwPNbEj1RreBQNydKAmr461lKbErgmDDAjB+blN7Ezm0y7FLEhqfvgaRsc6QpGRBuCMX//HDqBK9fjfU+tOR6Rv206QFkpZJj2MIjVgZUVaQRB9sQ4kRTk7U9mMOmKuoT7lt6qz2yvNfY/dzF5wIDAQAB";
        Map<String, Object> map = new TreeMap<>();
        map.put("partnerId", 123);
        map.put("idfa", "81BD5DC3-9DD8-41F2-B714-EF23CD21CA71");
//        map.put("callbackUrl", "http://www.baidu.com/");
        String content = map2String(map);
        System.out.println(content);
        String sign = signByPrivateKey(content, privateKey); //得到的签名值
        System.out.println(sign);
        System.out.println(verifySignByPublicKey(content, sign, publicKey)); //校验签名是否正确
        String a = DigestUtils.md5Hex("{\"callbackUrl\":\"http://ios.cn/api/api.php?act=callback&id=19&timestamp=1560249086&sign=3b92f545e211961303e6048f8cc80639&sig=18ade67b9eee9ee10debcfa03cb73067&idfa=81BD5DC3-9DD8-41F2-B714-EF23CD21CA11_aso100\",\"idfa\":\"81BD5DC3-9DD8-41F2-B714-EF23CD21CA11\",\"partnerId\":\"123\",\"salt\":\"35aa5d1b8a984081\"}");
        System.out.println(a);
    }
}
