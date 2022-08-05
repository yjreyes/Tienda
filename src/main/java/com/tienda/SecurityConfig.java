package com.tienda;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("juan")
                .password("{noop}123")
                .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("rebeca")
                .password("{noop}456")
                .roles("VENDEDOR", "USER")
                .and()
                .withUser("pedro")
                .password("{noop}789")
                .roles("USER");
    }

    //El siguiente método realiza la autorizacion a recursos del sitio web
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo", "articulo/guardar",
                        "/articulo/modificar/**", "articulo/eliminar/**",
                        "/categoria/nuevo", "categoria/guardar",
                        "/categoria/modificar/**", "categoria/eliminar/**",
                        "/cliente/nuevo", "cliente/guardar",
                        "/cliente/modificar/**", "cliente/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado",
                        "/categoria/listado",
                        "/cliente/listado")
                .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/")
                .hasAnyRole("ADMIN","VENDEDOR","USER")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }

}
