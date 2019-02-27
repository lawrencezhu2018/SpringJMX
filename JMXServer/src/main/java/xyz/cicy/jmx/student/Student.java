package xyz.cicy.jmx.student;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "xyz.cicy.jmx.student:type=Student,name=student")
public class Student implements StudentInterface
{
	private String name;

	private String Id;

	private double score;

	@ManagedAttribute
	public String getName()
	{
		return name;
	}

	@ManagedAttribute
	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return Id;
	}

	public void setId(String id)
	{
		Id = id;
	}

	@ManagedOperation
	public double getScore()
	{
		return score;
	}

	@ManagedOperation
	public void setScore(double score)
	{
		this.score = score;
	}
}
