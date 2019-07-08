package sofa.common.rsa;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ace on 2017/9/10.
 */
public class JwtRsaUtil {

    private static final String PASSWORD = "sofa";


    /**
     * 获取密钥
     *
     * @return
     * @throws Exception
     */
    public  static PrivateKey getPrivateKey() throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(generatePrivateKey());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }


    /**
     * 获取公钥
     *
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey() throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(generatePublicKey());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }



    /**
     * 根据密码生成公钥
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static byte[] generatePublicKey() throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(PASSWORD.getBytes());
        keyPairGenerator.initialize(512, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        return publicKeyBytes;
    }

    /**
     * 根据密码生成私钥
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static byte[] generatePrivateKey() throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(PASSWORD.getBytes());
        keyPairGenerator.initialize(512, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        return privateKeyBytes;
    }


}

