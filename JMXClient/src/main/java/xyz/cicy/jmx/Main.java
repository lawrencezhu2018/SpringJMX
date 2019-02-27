package xyz.cicy.jmx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.jmx.config.StudentConfig;
import xyz.cicy.jmx.student.StudentClient;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfig.class);

		StudentClient studentClient=context.getBean(StudentClient.class);
		System.out.println(studentClient.getName());
	}
}
