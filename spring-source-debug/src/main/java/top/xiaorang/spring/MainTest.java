package top.xiaorang.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiaorang.spring.entity.Jobs;
import top.xiaorang.spring.mapper.JobMapper;

import java.util.List;

public class MainTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		A a = ctx.getBean("a", A.class);
//		System.out.println(a);
//		a.caculate();
//		Person person = ctx.getBean(Person.class);
//		System.out.println(person);
//		Connection connection = ctx.getBean("connection", Connection.class);
//		System.out.println(connection);
//		Connection connection2 = ctx.getBean("connection", Connection.class);
//		System.out.println(connection2);
//		Object bean = ctx.getBean("&connection");
//		System.out.println(bean);
		JobMapper jobMapper = ctx.getBean("jobMapper", JobMapper.class);
		List<Jobs> jobs = jobMapper.selectJobs();
		jobs.forEach(System.out::println);
	}
}
