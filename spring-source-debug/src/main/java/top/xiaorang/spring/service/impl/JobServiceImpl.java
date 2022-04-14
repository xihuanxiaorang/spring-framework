package top.xiaorang.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiaorang.spring.entity.Jobs;
import top.xiaorang.spring.entity.Order;
import top.xiaorang.spring.mapper.JobMapper;
import top.xiaorang.spring.service.JobService;
import top.xiaorang.spring.service.OrderService;

import java.util.List;

/**
 * @author liulei
 */
@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private OrderService orderService;

	@Override
	public List<Jobs> selectJobs() {
		return jobMapper.selectJobs();
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void saveJobs(Jobs jobs) {
		try {
			jobMapper.saveJobs(jobs);
			orderService.saveOrder(new Order(4, "spring"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
