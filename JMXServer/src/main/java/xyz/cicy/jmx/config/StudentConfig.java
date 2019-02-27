package xyz.cicy.jmx.config;

import org.springframework.context.annotation.*;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.JMException;
import java.io.IOException;

@ComponentScan(basePackages = "xyz.cicy.*")
@Configuration
@EnableMBeanExport()
public class StudentConfig
{
	@Bean
	@DependsOn(value = "rmiRegistry")
	public ConnectorServerFactoryBean connectorServerFactoryBean() throws JMException, IOException
	{
		ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
		connectorServerFactoryBean.setObjectName("connector:name=rmi");
		connectorServerFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/student");
		return connectorServerFactoryBean;
	}

	@Bean(name = "rmiRegistry")
	public RmiRegistryFactoryBean rmiRegistryFactoryBean()
	{
		RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
		rmiRegistryFactoryBean.setPort(1099);

		return rmiRegistryFactoryBean;
	}

	@Bean(value = "server")
	public MBeanServerFactoryBean mBeanServerFactoryBean()
	{
		return new MBeanServerFactoryBean();
	}

}
