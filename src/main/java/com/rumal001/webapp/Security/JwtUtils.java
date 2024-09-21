package com.rumal001.webapp.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    // Inject base64-encoded keys from properties
    @Value("${JWT_PRIVATE_KEY}")
    private String privateKeyBase64;

    @Value("${JWT_PUBLIC_KEY}")
    private String publicKeyBase64;

    @PostConstruct
    public void loadKeys() throws Exception {
        // Decode and load the private key
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        this.privateKey = keyFactory.generatePrivate(privateKeySpec);

        // Decode and load the public key
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        this.publicKey = keyFactory.generatePublic(publicKeySpec);
    }

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .issuer("WEB-APP")
                .subject(username)
                .claim("Role",role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 86400000))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();

    }
    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claim = Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token).getPayload();
        return claim.getSubject();
    }
}
