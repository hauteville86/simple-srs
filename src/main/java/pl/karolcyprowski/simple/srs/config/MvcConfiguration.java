package pl.karolcyprowski.simple.srs.config;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.ReviewSession;
import pl.karolcyprowski.simple.srs.business.ReviewSessionImpl;
import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsAlgorithm;
import pl.karolcyprowski.simple.srs.controller.SimpleSrsController;
import pl.karolcyprowski.simple.srs.options.Options;
import pl.karolcyprowski.simple.srs.options.OptionsImpl;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Autowired
	public SimpleSrsService simpleSrsService;
	
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory()
	{
		return new HibernateJpaSessionFactoryBean();
	}
	
	@Bean
	public BaseInfo base()
	{
		return simpleSrsService.generateBaseInfo();
	}
	
	@Bean
	public ReviewSession reviewSession()
	{
		return new ReviewSessionImpl();
	}
	
	@Bean
	public SrsAlgorithm srsAlgorithm()
	{
		//TODO: The srsAlgorithm implementation shouldn't be hard-coded, but read from the properties instead
		logger.info("Create new srsAlgorithm...");
		return new SimpleSrsGlossAlgorithm();
	}
	
	@Bean
	public GregorianCalendar currentDate()
	{
		return new GregorianCalendar();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new StandardPasswordEncoder();
	}
	
	@Bean
	public Options options()
	{
		return new OptionsImpl();
	}

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }    
}