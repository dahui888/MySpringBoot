package com.zlp.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.zlp.common.swagger.BaseSwaggerConfig;
import com.zlp.common.swagger.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Profile({"local", "dev", "test"})
public class Swagger2Config extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackages(Arrays.asList("com.zlp.controller"))
                .title("swagger接口文档")
                .description("swagger接口文档相关接口文档")
                .contactName("LiPing.Zou")
                .version("1.0")
                .enableSecurity(Boolean.TRUE)
                .build();
    }
}

