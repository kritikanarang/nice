package com.nice.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nice.api.elements.JacksonUtils;
import com.nice.api.elements.SchemaGenerator;
//import com.nice.helper.generic.ProductHelper;
//import com.nice.helper.generic.SpecificationHelper;
import com.nice.helper.generic.TutorHelper;

@Configuration
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class AppConfig  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JacksonUtils jacksonUtils() {
		return new JacksonUtils();
	}
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TutorHelper tutorHelper() {
		return new TutorHelper();
	}
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public SchemaGenerator schemaGenerator() {
		return new SchemaGenerator();
	}
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
