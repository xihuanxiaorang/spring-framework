package top.xiaorang.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiaorang.spring.bean.Person;

public class Entrance {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}
}
