package biz.te2.services.swaggeraggregate.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix="documentation.swagger")
class SwaggerServicesConfig {
    List<SwaggerService> services

    static class SwaggerService {
        String name
        String url
        String version
    }
}