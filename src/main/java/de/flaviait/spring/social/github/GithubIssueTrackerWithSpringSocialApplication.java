package de.flaviait.spring.social.github;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class GithubIssueTrackerWithSpringSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubIssueTrackerWithSpringSocialApplication.class, args);
    }

    @Bean
    public SpringTemplateLoader templateLoader() {
        SpringTemplateLoader templateLoader = new SpringTemplateLoader();
        templateLoader.setBasePath("classpath:/templates/");
        return templateLoader;
    }

    @Bean
    public JadeConfiguration jadeConfiguration() {
        JadeConfiguration configuration = new JadeConfiguration();
        configuration.setCaching(false);
        configuration.setPrettyPrint(true);
        configuration.setTemplateLoader(templateLoader());
        return configuration;
    }

    @Bean
    public ViewResolver viewResolver() {
        JadeViewResolver viewResolver = new JadeViewResolver();
        viewResolver.setConfiguration(jadeConfiguration());
        return viewResolver;
    }
}
