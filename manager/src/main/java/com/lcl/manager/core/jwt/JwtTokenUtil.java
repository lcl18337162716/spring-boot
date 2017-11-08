package com.lcl.manager.core.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: jwt工具类
 * @Package com.lcl.manager.util
 * @Description: jwt
 * @date 2017/11/1
 */
@Component
public class JwtTokenUtil implements Serializable{

    private static final long serialVersionUID = -3301605591108950415L;
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    /**
     * 设置token秘钥key
     */
    @Value("{jwt.secret}")
    private String secret;
    /**
     * 设置token失效时间单位分
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成token
     * @param userId
     * @return
     */
    public String generateToken(String userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userId);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return initToken(claims);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = initToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    protected String initToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpriationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 判断token是否可以刷新
     * @param token
     * @param lastPasswordReset
     * @return
     */
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }
    /**
     * 生成token失效时间
     * @return
     */
    protected  Date generateExpriationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000*60);
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
    /**
     * 校验token是否有效
     * @param token
     * @param userId
     * @return
     */
    public Boolean validateToken(String token,String userId){
        String jwtUserId = getJwtUserIdFromToken(token);
        Date createDate = getCreatedDateFromToken(token);
        return (userId.equals(jwtUserId)
                        && !isTokenExpired(token));
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    protected Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 根据token获取用户id
     * @param token
     * @return
     */
    public String getJwtUserIdFromToken(String token) {
        String userId = null;
        try {
            final Claims claims = getClaimsFromToken(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }

    /**
     * 获取token创建时间
     * @param token
     * @return
     */
    public Date getCreatedDateFromToken(String token){
        Date created = null;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
     * 获取token过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 根据token获取Claims
     * @param token
     * @return
     */
    protected Claims getClaimsFromToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


}

