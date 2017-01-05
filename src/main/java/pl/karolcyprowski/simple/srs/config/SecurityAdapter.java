package pl.karolcyprowski.simple.srs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception
	{
		http
	      .authorizeRequests()
	        .antMatchers("/signup","/about").permitAll() // #4
	        .antMatchers("/admin/**").hasRole("ADMIN") // #6
	        .anyRequest().authenticated() // 7
	        .and()
	    .formLogin()  // #8
	        .loginPage("/login") // #9
	        .permitAll(); // #5
	}
}
