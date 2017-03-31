package com.citywalk.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.citywalk.backend.constant.Constants;
import com.citywalk.backend.constant.Endpoints;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * This application used spring boot to load the necessary beans / depenedent beans
 * @author Guru
 *
 */
@SpringBootApplication
@EnableSwagger
@ComponentScan("com.citywalk.backend")
public class CitywalkApplication extends SpringBootServletInitializer {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CitywalkApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CitywalkApplication.class, args);
	}
	
	@Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(new ApiInfo(
                		Constants.API_NAME,
                		Constants.API_DESCRIPTION,
                        Constants.API_TERMS_OF_SERVICE_URL,
                        Constants.API_CONTACT,
                        Constants.API_LICENSE,
                        Constants.API_LICENSE_URL
                )).apiVersion(Constants.API_VERSION)
                .useDefaultResponseMessages(false)
                .includePatterns(Endpoints.API_INCLUDE_PATTERN);
    }
}