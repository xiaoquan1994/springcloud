package com.springcloud.oauth.config;

import com.springcloud.oauth.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenStoreConfig {

    @Bean
    public TokenStore jwtTokenStoreBean() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    private JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter(){
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
                UserModel userModel = ((UserModel) authentication.getPrincipal());
                defaultOAuth2AccessToken.getAdditionalInformation().put("userName", userModel.getUsername());
                return super.enhance(accessToken, authentication);
            }
        };
        converter.setSigningKey("123456");
        return converter;
    }
}
