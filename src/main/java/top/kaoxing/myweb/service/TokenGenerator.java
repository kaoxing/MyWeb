package top.kaoxing.myweb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class TokenGenerator {

    @Value("${minesweeper.remoteServer.password}")
    private String secret;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations;

    private final Random random = new Random();

    @PostConstruct
    public void init(){
        valueOperations = redisTemplate.opsForValue();
    }

    public String minesweeperGameTokenGenerator(String gameId) {
        return generateToken(gameId);
    }

    public String minesweeperGameTokenVerifier(String token) {
        return tokenVerifier(token);
    }

    public String generateToken() {
        return generateToken("value");
    }

    public String generateToken(String value) {
        return JWT.create().withClaim(value, random.nextInt()).sign(Algorithm.HMAC256(secret));
    }

    public String tokenVerifier(String token) {
        try{
            return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getClaim("value").asString();
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
