package top.xiaorang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.xiaorang.spring.bean.Person;
import top.xiaorang.spring.config.AppConfig;
import top.xiaorang.spring.entity.Jobs;
import top.xiaorang.spring.service.JobService;

import java.util.List;

public class AnnotationMainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
		JobService jobService = ctx.getBean(JobService.class);
		List<Jobs> jobs = jobService.selectJobs();
		jobs.forEach(System.out::println);
	}
}
