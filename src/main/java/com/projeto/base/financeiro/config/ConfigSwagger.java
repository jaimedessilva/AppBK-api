package com.projeto.base.financeiro.config;

import com.projeto.base.financeiro.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigSwagger {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.projeto.base.financeiro.controller"))
                .paths(PathSelectors.ant("/*"))
                .build().apiInfo(metaInfo());
    }
    private ApiInfo metaInfo (){
        return new ApiInfoBuilder()
                .title("App BK Api")
                .description("Bank Account API Developed By: Jaime Dev: \n" +
                        "GitHub: https://github.com/jaimedessilva/AppBK-api")
                .version("1.0")
                .build();
    }

}
