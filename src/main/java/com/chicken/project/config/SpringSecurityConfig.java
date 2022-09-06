package com.chicken.project.config;

import com.chicken.project.member.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private EmployeeService employeeService;

    @Autowired
    public SpringSecurityConfig(EmployeeService employeeService){

        this.employeeService = employeeService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web){

        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
    }

    /* HTTP요청에 대한 권한 설정 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 페이지 접근 권한
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"calendar/**").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "calendar/**").hasRole("ADMIN")
                .antMatchers("/notice/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
        // 로그인 로그아웃 설정
          .and()
                .formLogin()
                .loginPage("/member/employee/login")
                .successForwardUrl("/main/admin_main")
                .usernameParameter("empId")
                .passwordParameter("empPwd")
          .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("확인");
        auth.userDetailsService(employeeService).passwordEncoder(passwordEncoder());
    }
}
