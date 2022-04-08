package top.xiaorang.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	private B b;

	public A() {
	}

	public void caculate() {
		System.out.println("计算....");
		throw new RuntimeException("故意发生异常");
	}

	public A(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}

	@Autowired
	public void setB(B b) {
		this.b = b;
	}
}
