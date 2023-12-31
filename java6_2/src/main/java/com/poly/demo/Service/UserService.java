package com.poly.demo.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.poly.demo.JpaReponsitory.EmployeeDAO;
import com.poly.demo.JpaReponsitory.EmployeeRoleDAO;
import com.poly.demo.bean.Employee;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    EmployeeDAO employeeDao;
    @Autowired
    EmployeeRoleDAO EmployeeRoledao;
    @Autowired
    BCryptPasswordEncoder pe;



   @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

           try {
             Employee employee = employeeDao.findById(username).get();
            //
                String password =  employee.getPassword();
                String[] roles = employee.getEmployeeRole().stream()
                                            .map(au -> au.getRole().getId())
                                            .collect(Collectors.toList())
                                            .toArray(new String[0]);
                return User.withUsername(username)
                            .password(pe.encode(password))
                            .roles(roles).build();
           } catch (Exception e) {
                            throw new UsernameNotFoundException("User not found");

           }
            }

            



            public void loginFormOauth2(OAuth2AuthenticationToken oauth2){
             String name = oauth2.getPrincipal().getAttribute("name");
            String email = oauth2.getPrincipal().getAttribute("email");
            String password = Long.toHexString(System.currentTimeMillis());

            UserDetails user = User.withUsername(email)
                                    .password(pe.encode(password))
                                    .roles("GUEST").build();
            
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(auth);
            

            }











        }

     
    
   


    
