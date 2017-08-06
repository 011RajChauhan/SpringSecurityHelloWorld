package rj.com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("rajan").password("chauhan").roles("USER");
		auth.inMemoryAuthentication().withUser("sandeep").password("sandy").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("vicky").password("vicky").roles("ADMIN","DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/","home").permitAll()
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.antMatchers("/user/**").access("hasRole('USER')")
			.and().formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
