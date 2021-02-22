package com.example.plantfinder.plantfinderapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    @Value("${enable.swagger.plugin:true}")
    private boolean enableSwaggerPlugin;
  
    ApiInfo apiInfo() {

        return new ApiInfoBuilder()
            .title("Swagger Plantfinder API")
            .description("Following is the Plantfinder API available to interface with application.")
            .license("MIT")
            .licenseUrl("https://opensource.org/licenses/MIT")
            .version("1.0.0")
            .contact(new Contact("Red Hat","https://codeaches.com", "mmartofe@redhat.com"))
            .build();
    }

    @Bean
    public Docket customImplementation() {

      return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.example.plantfinder.plantfinderapi"))
          .paths(PathSelectors.any())
          .build()
          .enable(enableSwaggerPlugin)
          .apiInfo(apiInfo());
    }
    
}
