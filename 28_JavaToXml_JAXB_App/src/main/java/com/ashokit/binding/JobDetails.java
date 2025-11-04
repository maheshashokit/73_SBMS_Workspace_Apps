package com.ashokit.binding;

public class JobDetails {

	private String jobId;

	private String jobBand;

	public JobDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public JobDetails(String jobId, String jobBand) {
		super();
		this.jobId = jobId;
		this.jobBand = jobBand;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobBand() {
		return jobBand;
	}

	public void setJobBand(String jobBand) {
		this.jobBand = jobBand;
	}

	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", jobBand=" + jobBand + "]";
	}	
}
