package be.civadis.stc.web;

import java.util.HashMap;
import java.util.Map;

import be.civadis.stc.web.servlet.StcRestServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;

@Configuration
@ComponentScan("be.civadis.stc")
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * plain URL...
	 */
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "hi!";
	}

	/*
	 * ZK servlets
	 */
	@Bean
	public ServletRegistrationBean dHtmlLayoutServlet() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("update-uri", "/zkau");
		DHtmlLayoutServlet dHtmlLayoutServlet = new DHtmlLayoutServlet();
		ServletRegistrationBean reg = new ServletRegistrationBean(dHtmlLayoutServlet, "*.zul");
		reg.setLoadOnStartup(1);
		reg.setInitParameters(params);
		return reg;
	}

	@Bean
	public ServletRegistrationBean dHtmlUpdateServlet() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("update-uri", "/zkau/*");
		ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setLoadOnStartup(2);
		reg.setInitParameters(params);
		return reg;
	}
	
	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}

	@Bean
	public ServletRegistrationBean restletServlet() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("org.restlet.application", "be.civadis.stc.web.rest.application.StcRestApplication");
		ServletRegistrationBean reg = new ServletRegistrationBean(new StcRestServlet(), "/api/*");
		reg.setLoadOnStartup(3);
		reg.setInitParameters(params);
		return reg;
	}


}
