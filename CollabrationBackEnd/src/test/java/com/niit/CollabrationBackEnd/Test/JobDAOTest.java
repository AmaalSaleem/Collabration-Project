package com.niit.CollabrationBackEnd.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollabrationBackEnd.DAO.JobDAO;
import com.niit.CollabrationBackEnd.Model.Job;


public class JobDAOTest {

	@Autowired
	private static  JobDAO jobDAO;
	
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDao");
	}
	@Ignore
	@Test
	public void addjob()
	{
		Job job=new Job();
		job.setJobdesc("Devops");
		job.setJobprofile("Web App developer");
		job.setSalary(1000);
		job.setQualification("bca");
		job.setCompany("cyberpark");
		job.setCompanydesc("calicut");
		
		assertTrue("Problem in inserting job",jobDAO.addjob(job));		
	}
@Ignore
	@Test
	public void getJob()
	{
		Job job=jobDAO.getjob(4);
		System.out.println(job.getJobdesc());
		
		
	}
	
@Ignore
	@Test
	public void getAllJobs()
	{
		
		ArrayList<Job> job=(ArrayList<Job>)jobDAO.getAlljobs();
		for(Job j:job)
		{
			System.out.println(j.getJobdesc());
			
		}
		
	}
@Ignore
@Test
public void updateJob()
{

	Job job=jobDAO.getjob(4);
	job.setJobdesc(" developer");
	assertTrue("problem in updating Job",jobDAO.updatejob(job));
	
}
@Ignore
	@Test
	public void deletejob()
	{
		
		Job job=jobDAO.getjob(4);
		assertTrue("problem in deleting Job",jobDAO.deletejob(job));
	}

}
