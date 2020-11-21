package br.com.ciandt.playlist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class Swagger implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }

    @Bean
    public Docket playlistAPIs() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(basePackage("br.com.ciandt.playlist.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Playlist APIs")
                .description("Playlist's APIs descriptions")
                .version("1.0-BETA")
                .termsOfServiceUrl("http://playlistmusics.com/we-do-not-have-one.html")
                .contact(new Contact("Jhon Doe", "https://spring.io/support", "email@email.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://playlistmusics.com/empty.html")
                .build();
    }
}
