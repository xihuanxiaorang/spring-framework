package top.xiaorang.spring.factorybean;

import org.springframework.beans.factory.SmartFactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author liulei
 * @date 2022/4/1
 */
public class ConnectionFactory implements SmartFactoryBean<Connection> {
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Override
	public Connection getObject() throws Exception {
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public Class<?> getObjectType() {
		return Connection.class;
	}

	@Override
	public boolean isEagerInit() {
		return true;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
