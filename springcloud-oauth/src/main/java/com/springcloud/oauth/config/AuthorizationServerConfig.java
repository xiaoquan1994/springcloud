package com.springcloud.oauth.config;

import com.springcloud.oauth.filter.LoginAuthenticationFilter;
import com.springcloud.oauth.service.impl.MyUserDetailsService;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Arrays;

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private MyUserDetailsService myUserDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource(name = "jwtTokenStoreBean")
    private TokenStore tokenStore;
    @Resource(name="authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("ec-api-service")
                .secret(passwordEncoder.encode("Aa123654..."))
                .scopes("service")
                .autoApprove(true)
                .authorizedGrantTypes("refresh_token", "password")
                .accessTokenValiditySeconds(24*3600)
                .refreshTokenValiditySeconds(2*4*3600);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(myUserDetailsService)
                .tokenStore(tokenStore);//配置令牌存储策略
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
        oauthServer.addTokenEndpointAuthenticationFilter(new LoginAuthenticationFilter());
    }
}
