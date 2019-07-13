package sofa.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import sofa.common.bean.dto.TokenDTO;
import sofa.common.rsa.JwtRsaUtil;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class JwtUtil {

    /**
     * 过期时间
     */
    private static final Integer EXPIRE = 5 * 60 * 5;

    private static final String USER_ID = "userId";

    /**
     * 私钥加密token
     *
     * @param tokenDTO
     * @return
     * @throws Exception
     */
    public static String encryptToken(TokenDTO tokenDTO) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(tokenDTO.getUserId())
                .claim(USER_ID, tokenDTO.getUserId())
                .setExpiration(DateTime.now().plusSeconds(EXPIRE).toDate())
                .signWith(SignatureAlgorithm.RS256, JwtRsaUtil.getPrivateKey())
                .compact();
        return compactJws;
    }


    /**
     * 公钥解密token
     *
     * @param token token值
     * @return
     */
    public static TokenDTO decryptToken(String token) throws Exception {
        Jws<Claims> jws = decrypt(token);
        Claims body = jws.getBody();
        TokenDTO tokenDTO = new TokenDTO();
        String userId = body.getSubject();
        tokenDTO.setUserId(userId);
        return tokenDTO;
    }


    /**
     * 公钥解密
     *
     * @param token
     * @return
     * @throws Exception
     */
    private static Jws<Claims> decrypt(String token) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(JwtRsaUtil.getPublicKey()).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取密钥
     *
     * @param privateKey
     * @return
     * @throws Exception
     */
    public PrivateKey getPrivateKey(byte[] privateKey) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static void main(String[] args) throws Exception {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUserId("qwe");
        String s = JwtUtil.encryptToken(tokenDTO);
        System.out.println(s);
    }
}
