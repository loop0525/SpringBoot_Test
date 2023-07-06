package com.loop.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtil{
    //默认有效期 30min
    public static final Long JWT_TTL = 3600000L;
    //jwt令牌信息
    public static final String JWT_KEY = "loop0525.top";
    /**
     * 创建令牌
     * @param id 令牌唯一标识
     * @param subject 主题信息
     * @param ttlMillis 有效期
     */
    public static String generateToken(String id, String subject, Long ttlMillis){
        // 指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 系统当前时间
        long nowMillis = System.currentTimeMillis();
        // 令牌颁发时间
        Date now = new Date(nowMillis);

        // 若传入的令牌有效期为null，则使用默认有效期
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        // 令牌过期时间
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        // 生成密钥
        SecretKey secretKey = generalKey();
        // 封装令牌信息
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id) //令牌唯一标识
                .setSubject(subject) // 主题
                .setIssuer("loop") // 签发者
                .setIssuedAt(now) // 签发时间
                .signWith(signatureAlgorithm, secretKey) // 签名以及密钥.参1：签名算法；参2：密钥（盐）
                .setExpiration(expDate);// 设置过期时间
        return jwtBuilder.compact();
    }
    /**
     * 生成加密 generalKey：对当前密钥进行再次Base64加密
     */
    public static SecretKey generalKey(){
        byte[] encodeKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }
    /**
     * 解析令牌
     */
    public static Claims parseToken(String token){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey) //解析密钥
                .parseClaimsJws(token) //解析token
                .getBody(); //获取解析后的数据
    }
}
