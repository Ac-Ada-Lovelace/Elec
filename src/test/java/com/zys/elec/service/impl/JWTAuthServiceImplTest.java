package com.zys.elec.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zys.elec.service.JWTAuthService;
import com.zys.elec.service.impl.JWTAuthServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JWTAuthServiceImplTest {

    private JWTAuthService jwtAuthService;
    private static final String SECRET_KEY = "your_secret_key";
    private static final String USERNAME = "testuser";
    private static final String CAPTCHA = "123456";

    @BeforeEach
    public void setUp() {
        jwtAuthService = new JWTAuthServiceImpl();
    }
    
    @Test
    public void testGenerateToken() {
        String token = jwtAuthService.generateToken(USERNAME, CAPTCHA);
        assertNotNull(token);

        DecodedJWT decodedJWT = JWT.decode(token);
        assertEquals(USERNAME, decodedJWT.getSubject());
        assertEquals(CAPTCHA, decodedJWT.getClaim("captcha").asString());
    }

    @Test
    public void testValidateToken() {
        String token = jwtAuthService.generateToken(USERNAME, CAPTCHA);
        assertTrue(jwtAuthService.validateToken(token));

        String invalidToken = token + "invalid";
        assertFalse(jwtAuthService.validateToken(invalidToken));
    }

    @Test
    public void testGetUsernameFromToken() {
        String token = jwtAuthService.generateToken(USERNAME, CAPTCHA);
        String username = jwtAuthService.getUsernameFromToken(token);
        assertEquals(USERNAME, username);
    }
}