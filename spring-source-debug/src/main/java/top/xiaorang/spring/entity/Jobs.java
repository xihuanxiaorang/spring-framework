package top.xiaorang.spring.entity;

/**
 * @author liulei
 */
public class Jobs {
	private String jobId;
	private String jobTitle;
	private String minSalary;
	private String maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "Jobs{" +
				"jobId='" + jobId + '\'' +
				", jobTitle='" + jobTitle + '\'' +
				", minSalary='" + minSalary + '\'' +
				", maxSalary='" + maxSalary + '\'' +
				'}';
	}
}
