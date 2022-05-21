package cherniavskiy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllersConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/listInto").setViewName("listInto");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/registrationto").setViewName("registrationto");
        registry.addViewController("/curRec").setViewName("curRec");
        registry.addViewController("/toAccount").setViewName("toAccount");
        registry.addViewController("/clientAccount").setViewName("clientAccount");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/forbidden").setViewName("forbidden");
        registry.addViewController("/").setViewName("listInto");
    }

}