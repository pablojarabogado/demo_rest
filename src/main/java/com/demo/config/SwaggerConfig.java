/**
 * 
 */
package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * @author Pablo Jara
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.demo"))
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());

	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("API DEMO").description("DOCUMENTACIÓN").version("0.0.1-SNAPSHOT")
				.build();
	}

}
