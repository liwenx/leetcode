package com.liwx.test.temp;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author liwenxing
 * @date 19-6-4 下午4:58
 */
public class RSASignature {
    public static final String key = "mifi";
    public static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ0PKSlbduiPMNgAEjiE6E5uSOrA81sSPVGt4FA3J0oCavjrWUpsSuCYMMCMH5uU3sTObTLsUsSGp++BpGxzpCkZEG4Ixf/8cOoEr1+N9T605HpG/bTpAWSlkmPYwiNWBlRVpBEH2xDiRFOTtT2Yw6Yq6hPuW3qrPbK819j93MXnAgMBAAECgYAbY7p06Ot6sQX+lTyYOK1eiCMVNWL7HdottVnqA0RJxtQq5rgin3ILat8NpSIZ+sNCpREsEUR521XMEdq/wwb8j9XasHSn/Jx7XrpQlp2cqo3x/yHfka6zoeozQ2K2svl5ypEqThTx3GM3CLPN3yLvd8rwxapDTdArWV9rJs79YQJBAP8cI3/bWgFSbAO9LPY48l31xQEcA/SCE11EWLHWi4U3jXIxpb3sUXMrzkFeNs0S/Ukg48BVWA4zHA+2Bc36/jcCQQCdm3G/snvXlWMqMKOwCL1/FJhamo7lWXS0QApD7X68Tv60ylxuwFDMDPQQn9sS5r15D4gEBlZmCnNXNtLYkR3RAkAXv7HaVDxDxT2C95h474I4lwmY+dewam+NDjDHlXZ1l19WkyKf1KEcfKZ91Vx6qNrldOde31MMN1vUZpiRvVzvAkBPnOLjs7QtHVAfUryMwo1+cRfYxLQkFIEIQEUvNPvNAZZWGtaAN3NY774l26odLSNO0NKjPdRM7UCAMLhnHz7RAkAduo5wkIK/WuV6eu1Qre0sbzob48cTxBaZ2oHmfYXcQ3RRoj5+MNJCWCR7ALC+0IZc23TU83TKTx0I55txVL0J";
    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdDykpW3bojzDYABI4hOhObkjqwPNbEj1RreBQNydKAmr461lKbErgmDDAjB+blN7Ezm0y7FLEhqfvgaRsc6QpGRBuCMX//HDqBK9fjfU+tOR6Rv206QFkpZJj2MIjVgZUVaQRB9sQ4kRTk7U9mMOmKuoT7lt6qz2yvNfY/dzF5wIDAQAB";

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key.getBytes("utf-8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(keyBytes));
        return pubKey;
    }

    public static String encrypt(PublicKey publicKey, String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, publicKey);
            byte[] enBytes = cipher.doFinal(plainText.getBytes("utf-8"));
            return new String(Base64.encodeBase64(enBytes));
        } catch (Exception var4) {
            return null;
        }
    }

    public static String decrypt(PrivateKey privateKey, String enStr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, privateKey);
            byte[] deBytes = cipher.doFinal(Base64.decodeBase64(enStr));
            return new String(deBytes, "utf-8");
        } catch (Exception var4) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPrivateKey(key));
        System.out.println(getPublicKey(key));
    }
}
