package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by cjl20 on 2015/10/22.
 */
@Configuration
public class ContactConfig {

    @Bean
    public ViewResolver viewResolver() {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        // XHTML is the default mode, but we will set it anyway for better understanding of code
        templateResolver.setTemplateMode("XHTML");
        // 设置模板的前置路径
        templateResolver.setPrefix("views/");
        //设置模板统一的后缀名
        templateResolver.setSuffix(".html");

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine);

        return viewResolver;
    }
}
