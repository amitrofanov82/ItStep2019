package ca.by.project_x;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Spring Container Configuration that is responsible 
 * for Web and Rest API functionality.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"ca.by.project_x"})
public class WebConfiguration implements WebMvcConfigurer{
	
	
	@Value( "${resources.filesystem.rootpath}" )
	private String fsResoucesRootPath;

    @Bean
    public RestTemplate restTemplate(@Autowired RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ErrorProperties errorProperties(ServerProperties serverProperties) {
        return serverProperties.getError();
    }
    
    /** @return Springfox/Swagger api documentation builder. */
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    
    @Override
    //see https://www.baeldung.com/spring-mvc-static-resources
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:webapp/index.html");
        registry.addResourceHandler("/resources/**").addResourceLocations();
        
        registry
	        .addResourceHandler("/resources/**")
	        .addResourceLocations("file:" + fsResoucesRootPath + "/")
	        .setCachePeriod(60000)
	        .resourceChain(true)
	        .addResolver(new GzipResourceResolver())
	        .addResolver(new PathResourceResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index.html");
    }
}
