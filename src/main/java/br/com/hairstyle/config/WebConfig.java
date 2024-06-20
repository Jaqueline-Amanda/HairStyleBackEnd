package br.com.hairstyle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedMethods("GET", "POST", "PUT", "DELETE")/*quais os métodos que serão aceitos*/
               .allowedOrigins("http://localhost:8000",/*quais os domínios que serão aceitos*/
                       "http://localhost:5173");
    }
}
