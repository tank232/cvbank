package tel.ran.group.cvbank.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true)
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/jobSeeker/registration/").permitAll()
                .antMatchers("/admin/registration/").permitAll()
                .antMatchers("/Company/registration/").permitAll()
                .antMatchers("/jobSeeker/login/").permitAll()
                .antMatchers("/admin/login/").permitAll()
                .antMatchers("/Company/login/").permitAll()
                .antMatchers("/jobSeeker**").hasRole("JOB_SEEKER")
                .antMatchers("/admin**").hasRole("ADMIN")
                .antMatchers("/Company**").hasRole("COMPANY")
                .anyRequest().authenticated();

        http.addFilterBefore(
                authenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }


}
