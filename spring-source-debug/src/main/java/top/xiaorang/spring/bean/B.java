package top.xiaorang.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	private A a;

	public B() {
	}

	public B(A a) {
		this.a = a;
	}

	public A getA() {
		return a;
	}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}
}
