package pl.karolcyprowski.simple.srs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
	      .authorizeRequests()
	        .antMatchers("/signup","/about", "/resources/**", "/adduser").permitAll() // #4
	        .antMatchers("/admin/**").hasRole("ADMIN") // #6
	        .anyRequest().authenticated() // 7
	        .and()
	    .formLogin()  // #8
	        .loginPage("/login") // #9
	        .permitAll()
	        .and()
	    .logout()
	    	.permitAll(); // #5
		
		http.csrf().disable();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//		auth.jdbcAuthentication().dataSource(dataSource)
//			.passwordEncoder(passwordEncoder)
//			.usersByUsernameQuery("SELECT * FROM simplesrs.user WHERE username = ?")
//			.authoritiesByUsernameQuery("SELECT * FROM simplesrs.authorities WHERE username = ?");
		
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
