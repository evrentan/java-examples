package evrentan.examples.javarecordexample.spring.spring;

import evrentan.examples.javarecordexample.spring.config.CommonConfig;
import evrentan.examples.javarecordexample.spring.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {CommonConfig.class, WebConfig.class})
public class JavaRecordExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaRecordExampleApplication.class, args);
  }

}
