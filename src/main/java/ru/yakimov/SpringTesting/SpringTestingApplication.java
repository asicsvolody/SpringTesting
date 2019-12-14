package ru.yakimov.SpringTesting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.yakimov.SpringTesting.tester.Test;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringTestingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringTestingApplication.class, args);
		Test tester = applicationContext.getBean(Test.class);
		tester.testing();
	}
}
