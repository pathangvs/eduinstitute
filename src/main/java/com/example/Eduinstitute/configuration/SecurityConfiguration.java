package com.example.Eduinstitute.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.user-query}")
    private String usersQuery;

    @Value("${spring.queries.role-query}")
    private String rolesQuery;

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //http.authorizeRequests().anyRequest().permitAll();


        http.
                authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/newhome").permitAll()
                .antMatchers("/newhome/newcourse/login").permitAll()
                .antMatchers("/home/admin/**").hasAuthority("admin").anyRequest()
                //           .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/newhome/newcourse/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/newhome")
                .usernameParameter("uemail")
                .passwordParameter("upassword")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
//spring will redirsct to its homepage where thelogin page was accesed
    }
//
}


