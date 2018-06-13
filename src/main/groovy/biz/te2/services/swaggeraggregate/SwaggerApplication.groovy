package biz.te2.services.swaggeraggregate

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class SwaggerApplication {
	static void main(String[] args) {
		SpringApplication.run(SwaggerApplication, args)
	}
}
