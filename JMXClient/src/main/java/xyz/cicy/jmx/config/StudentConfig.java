package xyz.cicy.jmx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import xyz.cicy.jmx.student.Student;
import xyz.cicy.jmx.student.StudentInterface;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;

@ComponentScan(basePackages = "xyz.cicy.*")
@Configuration
public class StudentConfig
{
	@Bean
	public MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean() throws MalformedURLException
	{
		MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean = new MBeanServerConnectionFactoryBean();
		mBeanServerConnectionFactoryBean.setServiceUrl
				("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/student");

		return mBeanServerConnectionFactoryBean;
	}

	@Bean
	public MBeanProxyFactoryBean mBeanProxyFactoryBean(MBeanServerConnection server) throws
			MalformedObjectNameException
	{
		MBeanProxyFactoryBean mBeanProxyFactoryBean = new MBeanProxyFactoryBean();
		mBeanProxyFactoryBean.setObjectName("xyz.cicy.jmx.student:type=Student,name=student");
		mBeanProxyFactoryBean.setProxyInterface(StudentInterface.class);
		mBeanProxyFactoryBean.setServer(server);

		return mBeanProxyFactoryBean;
	}

}
