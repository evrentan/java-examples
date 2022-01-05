package evrentan.examples.javarecordexample.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = "com.tan.myjavarecordexample")
@EnableMongoRepositories(value = "com.tan.myjavarecordexample.repository")
@EntityScan(value = "com.tan.myjavarecordexample.entity")
public class CommonConfig {
}
