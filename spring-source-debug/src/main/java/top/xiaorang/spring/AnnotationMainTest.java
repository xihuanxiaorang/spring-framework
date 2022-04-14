package top.xiaorang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.xiaorang.spring.bean.Person;
import top.xiaorang.spring.config.AppConfig;
import top.xiaorang.spring.entity.Jobs;
import top.xiaorang.spring.entity.Order;
import top.xiaorang.spring.service.JobService;
import top.xiaorang.spring.service.OrderService;

import java.util.List;

public class AnnotationMainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
		JobService jobService = ctx.getBean(JobService.class);
		jobService.saveJobs(new Jobs("Designer", "Graphic Designer", 15000, 25000));
		List<Jobs> jobs = jobService.selectJobs();
		jobs.forEach(System.out::println);
	}
}
