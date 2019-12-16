package com.example.service.alpha.controller;

import com.example.service.alpha.config.TokenProvider;
import com.example.service.alpha.config.WebSecurityConfig;
import com.example.service.alpha.model.AuthToken;
import com.example.service.alpha.model.LoginUser;
import com.example.service.alpha.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

/**
 * Create token on user behalf.
 * <p><ul>
 *     <li>Needed as for service security</li>
 *     <li>Endpoint authentication is whitelisted in {@link WebSecurityConfig}</li>
 * </ul></p>
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/generate-token")
    public ResponseEntity<?> register(@RequestParam MultiValueMap body) throws AuthenticationException {
        logger.info("New generate token request.");
        if(body == null || body.get("username") == null || body.get("password") == null) {
            return ResponseEntity.badRequest().build();
        }
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        body.get("username").toString(),
                        body.get("password").toString()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        logger.info("Newly generated token: " + token);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
