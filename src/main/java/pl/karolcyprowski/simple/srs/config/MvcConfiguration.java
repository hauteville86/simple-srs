package pl.karolcyprowski.simple.srs.config;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import pl.karolcyprowski.simple.srs.business.EbbinghausAlgorithm;
import pl.karolcyprowski.simple.srs.business.ReviewSession;
import pl.karolcyprowski.simple.srs.business.ReviewSessionImpl;
import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsAlgorithm;
import pl.karolcyprowski.simple.srs.controller.SimpleSrsController;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionary;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionaryImpl;
import pl.karolcyprowski.simple.srs.module.ModuleMaster;
import pl.karolcyprowski.simple.srs.module.ModuleMasterImpl;
import pl.karolcyprowski.simple.srs.options.Options;
import pl.karolcyprowski.simple.srs.options.OptionsImpl;
import pl.karolcyprowski.simple.srs.scheduler.MainScheduler;
import pl.karolcyprowski.simple.srs.scheduler.MainSchedulerImpl;
import pl.karolcyprowski.simple.srs.scheduler.utilities.UtilityFactory;
import pl.karolcyprowski.simple.srs.scheduler.utilities.UtilityFactoryImpl;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;
import pl.karolcyprowski.simple.srs.user.User;
import pl.karolcyprowski.simple.srs.user.UserImpl;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Value("${pl.karolcyprowski.basic_algorithm}")
	private String basicAlgorithm;
	
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
		switch(basicAlgorithm)
		{
			case "SimpleSrsGlossAlgorithm":
				return new SimpleSrsGlossAlgorithm();
			case "EbbinghausAlgorithm":
				return new EbbinghausAlgorithm();
			default:
				return new EbbinghausAlgorithm();
		}
		
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
	
	@Bean
    public User user()
    {
    	return new UserImpl();
    }
	

	@Bean
	public UtilityFactory utilityFactory()
	{
		return new UtilityFactoryImpl();
	}
	
	@Bean
	public MainScheduler mainScheduler()
	{
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(!(authentication instanceof AnonymousAuthenticationToken))
//		{
//			if(authentication != null)
//			{
//				String currentName = authentication.getName();
//				return new MainSchedulerImpl();
//			}
//		}
		return new MainSchedulerImpl();
	}
	
	@Bean
	public SRSDictionary srsDictionary()
	{
		return new SRSDictionaryImpl();
	}
	

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }    
    
    @Bean
    public ModuleMaster moduleMaster() {
    	return new ModuleMasterImpl();
    }
    
}