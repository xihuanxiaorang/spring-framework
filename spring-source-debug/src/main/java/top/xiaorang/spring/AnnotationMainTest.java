package top.xiaorang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.xiaorang.spring.bean.Person;
import top.xiaorang.spring.config.AppConfig;

public class AnnotationMainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}
}
