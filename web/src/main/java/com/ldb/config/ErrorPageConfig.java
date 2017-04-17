package com.ldb.config;


import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by ldb on 2017/2/7.
 */
@Configuration
public class ErrorPageConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorPage/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorPage/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorPage/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }

}
