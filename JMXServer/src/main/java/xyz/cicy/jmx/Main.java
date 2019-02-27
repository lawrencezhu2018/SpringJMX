package xyz.cicy.jmx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.jmx.config.StudentConfig;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfig.class);

		Thread.sleep(600000000);
	}
}
