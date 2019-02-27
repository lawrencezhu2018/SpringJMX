package xyz.cicy.jmx.student;

public class Student implements StudentInterface
{
	private String name;

	private String Id;

	private double score;

	public String getName()
	{
		return name;
	}

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


	public double getScore()
	{
		return score;
	}


	public void setScore(double score)
	{
		this.score = score;
	}
}
