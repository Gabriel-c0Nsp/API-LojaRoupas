package org.lojaroupas.api.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private ApiInfoBuilder infoApi() {
    
    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

    apiInfoBuilder.title("API for a fake clothing store");
    apiInfoBuilder.description("This API was made for educational purposes. It's an API that I made to get fake products for a web site of mine");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.termsOfServiceUrl("Open Source: MIT license");
    return apiInfoBuilder;
  }

  @Bean
  public Docket detailApi() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket
      .select()
      .apis(RequestHandlerSelectors.basePackage("org.lojaroupas.api.controller"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(this.infoApi().build())
      .consumes(new HashSet<String>(Arrays.asList("application/json")))
      .produces(new HashSet<String>(Arrays.asList("application/json")));
      
    return docket;
  }

}
