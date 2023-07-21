package com.poly.demo.online_so6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.demo.Service.UserService;

@Configuration
@EnableWebSecurity
public class s2_AuthConfig extends WebSecurityConfigurerAdapter {

        
        // Mã hóa mật khẩu
        @Bean
        public BCryptPasswordEncoder getPasswordEncoder(){
            return new BCryptPasswordEncoder();
        }

        // Quản lý người dữ liệu người sử dụng
        @Autowired
        UserService userService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(userService);
                
        }
         // Phân quyền sử dụng và hình thức đăng nhập

        @Override   
        protected void configure(HttpSecurity http) throws Exception{
            //CSRF,CORS - chia sẽ từ bên ngoài và truy cập
            http.csrf().disable().cors().disable();

            http.authorizeRequests(requests -> requests
                    .antMatchers("/home/admins").hasRole("ADMIN")
                    .antMatchers("/home/users").hasAnyRole("ADMIN","USER")
                    .antMatchers("/home/authenticated").authenticated());
                    //nếu không đúng vai trò vào đường dẫn
            http.exceptionHandling(handling -> handling
                    .accessDeniedPage("/auth/access/denied"));

            http.formLogin(login -> login  //giao dien
                    .loginPage("/auth/login/form")
                    .loginProcessingUrl("/auth/login")
                    .defaultSuccessUrl("/auth/login/success", false)
                    .failureUrl("/auth/login/error")
                    .usernameParameter("username")
                    .passwordParameter("password"));

            http.rememberMe(me -> me
                    .rememberMeParameter("remember"));


                    //dang xuat
            http.logout(logout -> logout

                    .logoutUrl("/auth/logoff")
                    .logoutSuccessUrl("/auth/logoff/success"));
            
                    // .logoutUrl("/logout") // ???ng d?n URL ?? ??ng xu?t
                    // .logoutSuccessUrl("/security/index") // ???ng d?n URL sau khi ??ng xu?t thành công
                    // .invalidateHttpSession(true) // Vô hi?u hóa phiên ??ng nh?p
                    // .deleteCookies("JSESSIONID")); // Xóa cookie JSESSIONID (n?u có)


              // dang nhap bang mang xa hoi demo 7.6
                http.oauth2Login()
                .loginPage("/auth/login/form")
                .defaultSuccessUrl("/auth/login/success",true)
                .failureUrl("/auth/login/error")
                .authorizationEndpoint()
                        .baseUri("/oauth2/authorization");        
                        
        }


      
    

   
}