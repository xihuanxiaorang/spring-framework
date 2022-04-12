package top.xiaorang.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiaorang.spring.entity.Jobs;
import top.xiaorang.spring.mapper.JobMapper;
import top.xiaorang.spring.service.JobService;

import java.util.List;

/**
 * @author liulei
 */
@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobMapper jobMapper;

	@Override
	public List<Jobs> selectJobs() {
		return jobMapper.selectJobs();
	}

	public JobMapper getJobMapper() {
		return jobMapper;
	}

	public void setJobMapper(JobMapper jobMapper) {
		this.jobMapper = jobMapper;
	}
}
