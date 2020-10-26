package tn.esprit.spring;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.apache.log4j.Logger;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javassist.bytecode.stackmap.BasicBlock.Catch;
import tn.esprit.spring.config.LoginFilter;

@SpringBootApplication
@EnableAutoConfiguration
public class TimesheetApplication {
  
	private static final Logger l =Logger.getLogger(TimesheetApplication.class);
	
	public static void main(String[] args) {SpringApplication.run(TimesheetApplication.class, args);}
//TimesheetApplication tim = new TimesheetApplication();
//	tim.getAlEmployer();
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf"); 
		
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}


	@Bean
	public FilterRegistrationBean loginFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.addUrlPatterns("/pages/*");
		registration.setFilter(new LoginFilter());
		return registration;
	}
 
	public void getAlEmployer() {
	try {
		
		l.info("ajout de getAlEmployer():");
		int i =1/0;
		l.debug("lancement de la division par 0"+i);
		l.info("out getAlEmployer() ");
	}
	catch(Exception e)
	{
		l.error("y'a une erreur deans getAlEmployer()"+e);
	}
	}
}
