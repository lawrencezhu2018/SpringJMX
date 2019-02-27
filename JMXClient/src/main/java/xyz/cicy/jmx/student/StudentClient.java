package xyz.cicy.jmx.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentClient
{
	@Autowired
	private StudentInterface student;

	public String getName()
	{
		return student.getName();
	}

	public void setName(String name)
	{
		student.setName(name);
	}

}
