package techloxa.gamificacion.juego3d.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	String[] resources = new String[] { "/include/**", "/bootstrap/**", "/css/**", "/fontawesome/**", "/img/**",
			"/js/**", "/jquery/**", "/datatables/**", "/layer" };
	// Utiliza la función de hash fuerte BCrypt.
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	// private LoginSuccessHandler successHandler;
	private CustomSuccessHandler successHandler;

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/api/**").permitAll().antMatchers("/")
				.permitAll()
				// Página de inicio sin login
				.antMatchers("/crear_usuario").permitAll()
				.antMatchers("/guardar_usuario").permitAll()
				.antMatchers("/profesor/**").hasRole("PROFESOR")
				.antMatchers("/usuario/**").hasRole("PROFESOR")
				.antMatchers("/administracion/**").hasRole("ADMINISTRADOR")
				.antMatchers("/administrador/listar_usuarios").hasRole("ADMINISTRADOR")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				// Se accede a la pagina de login mediante botón
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.successHandler(successHandler)
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/error_403");
		http.csrf().disable();
	}

	// Acceso sistema
	@Autowired
	public void configureGobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)

				// .usersByUsernameQuery("SELECT usuario, contrasenia, 'true' as enabled FROM
				// profesor Where usuario=?")

				// .usersByUsernameQuery("SET @user =?;SELECT p.usuario, p.contrasenia, 'true'
				// as enabled FROM profesor p Where p.usuario= @user UNION SELECT a.usuario,
				// a.contrasenia FROM administrador a Where a.usuario=@user")
				.usersByUsernameQuery("SELECT usuario, contrasenia, 'true' as enabled FROM usuario u Where u.usuario=?")
				// .usersByUsernameQuery("SELECT usuario, contrasenia, 'true' as enabled FROM
				// profesor Where usuario=? UNION SELECT usuario, contrasenia, 'true' as enabled
				// FROM administrador Where usuario=?")
				// .usersByUsernameQuery("SELECT DISTINCT * from (SELECT p.usuario,
				// p.contrasenia, 'true' as enabled from profesor p WHERE p.usuario=? UNION
				// SELECT a.usuario, a.contrasenia, 'true' as enabled from administrador a WHERE
				// a.usuario=?) as r1")

				// .usersByUsernameQuery("SELECT usuario, contrasenia, 'true' as enabled FROM
				// profesor, administrador Where usuario=?")
				// .authoritiesByUsernameQuery("SELECT usuario, rol FROM profesor Where
				// usuario=?");
				// .authoritiesByUsernameQuery("SELECT usuario, rol FROM profesor Where
				// usuario=?");

				// .authoritiesByUsernameQuery("SELECT p.usuario, p.rol FROM administrador p
				// Where p.usuario=?")
				.authoritiesByUsernameQuery("SELECT u.usuario, u.rol FROM usuario u Where u.usuario=?");
		// .authoritiesByUsernameQuery("SELECT * from (SELECT p.usuario, p.rol FROM
		// profesor p Where p.usuario=? UNION SELECT a.usuario, a.rol FROM administrador
		// a Where a.usuario=?) AS r");

		// .authoritiesByUsernameQuery("SELECT usuario, rol FROM profesor Where
		// usuario='bdportilla1' UNION SELECT usuario, rol FROM administrador Where
		// usuario='bdportilla1'");

	}

}
