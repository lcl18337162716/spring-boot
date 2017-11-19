package com.lcl.manager;

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
 * @author liuchaolong
 * @version V1.0
 * @Title: Swagger2文档
 * @Package com.lcl.manager
 * @Description: Swagger2文档配置  http://localhost:8080/manage/swagger-ui.html
 * @date 2017/11/9
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lcl.manager"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Manager利用swagger构建api文档")
                .description("个人小练习demo")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
