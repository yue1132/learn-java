package com.security;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSADemo {

    public static final String src = "learn security rsa";

    public static void main(String[] args) {
        jdkRSA();
    }

    public static void jdkRSA() {

        try {
            // 1.初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey rsaPublicKey = keyPair.getPublic();
            PrivateKey rsaPrivateKey = keyPair.getPrivate();

            // 2.执行签名
            KeyFactory rsaFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            PrivateKey privateKey = rsaFactory.generatePrivate(pkcs8EncodedKeySpec);

            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());

            byte[] result = signature.sign();
            System.out.println(HexBin.encode(result));

            // 3.验证
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            PublicKey publicKey = rsaFactory.generatePublic(x509EncodedKeySpec);

            signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(src.getBytes());

//            byte[] resultP = signature.sign();
//            System.out.println(HexBin.encode(resultP));

            boolean bool = signature.verify(result);
            System.out.println(bool);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
