package com.niit.CollabrationBackEnd.DAOImpl;

import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollabrationBackEnd.DAO.JobDAO;
import com.niit.CollabrationBackEnd.Model.Job;
import com.niit.CollabrationBackEnd.Model.JobApplications;

@Repository("jobDao")
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	public JobDAOImpl() {
		super();
	}

	

		@Transactional
	public boolean applyJob(JobApplications jobapplications){
		try
		{
		sessionFactory.getCurrentSession().save(jobapplications);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
		
	}



	@Transactional
	public boolean addjob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}



	@Transactional
	public boolean updatejob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().update(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}



	@Transactional
	public boolean deletejob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}



	@Transactional
	public Job getjob(int jobId) {
		Session session=sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobId);
		session.close();
		return job;
		
	}



	@Transactional
	public ArrayList<Job> getAlljobs() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Job> jobList=(ArrayList<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;

	}



	@Transactional
	public ArrayList<JobApplications> myjobs(int myid) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<JobApplications> jobapllicationlist=(ArrayList<JobApplications>)session.createQuery("from JobApplications where user_id="+myid).list();
		session.close();
		return jobapllicationlist;
	}



	@Transactional
	public ArrayList<JobApplications> checkIfApplied(int jobid, int myid) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<JobApplications> checkifapplied=(ArrayList<JobApplications>)session.createQuery("from JobApplications where user_id="+myid+" and jobid="+jobid).list();
	session.close();
	return checkifapplied;
	}



	@Transactional
	public ArrayList<JobApplications> jobapps(int jobid) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
