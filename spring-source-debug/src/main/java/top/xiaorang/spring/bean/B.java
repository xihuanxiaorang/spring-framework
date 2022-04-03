package top.xiaorang.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	private A a;

	public A getA() {
		return a;
	}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}
}
