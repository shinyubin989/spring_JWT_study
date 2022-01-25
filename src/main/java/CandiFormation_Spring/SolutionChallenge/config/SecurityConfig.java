package CandiFormation_Spring.SolutionChallenge.config;

import CandiFormation_Spring.SolutionChallenge.jwt.JwtAccessDeniedHandler;
import CandiFormation_Spring.SolutionChallenge.jwt.JwtAuthenticationEntryPoint;
import CandiFormation_Spring.SolutionChallenge.jwt.JwtSecurityConfig;
import CandiFormation_Spring.SolutionChallenge.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final TokenProvider tokenProvider;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

  public SecurityConfig(
    TokenProvider tokenProvider,
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
    JwtAccessDeniedHandler jwtAccessDeniedHandler
  ) {
    this.tokenProvider = tokenProvider;
    this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) {
    web
      .ignoring()
      .antMatchers(
        "/h2-console/**"
        ,"/favicon.ico"
      );
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
      .csrf().disable()

      .exceptionHandling()
      .authenticationEntryPoint(jwtAuthenticationEntryPoint)
      .accessDeniedHandler(jwtAccessDeniedHandler)

      // enable h2-console
      .and()
      .headers()
      .frameOptions()
      .sameOrigin()

      // 세션을 사용하지 않기 때문에 STATELESS로 설정
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

      .and()
      .authorizeRequests() //HttpServletRequest를 사용하는 요청에 대한 접근제한을 설정
      // .antMatchers("/users").permitAll() // "/users"에 대한 요청은 인증없이 접근 허용
      .antMatchers("/auth/login").permitAll()
      .antMatchers("/auth/signup").permitAll()
      .anyRequest().authenticated() // 그외 나머지 요청들은 모두 인증되어야해

      .and()
      .apply(new JwtSecurityConfig(tokenProvider));
  }
}
