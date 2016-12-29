package pl.karolcyprowski.simple.srs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.BaseInfoImpl;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
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

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }    
}