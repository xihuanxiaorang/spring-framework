package top.xiaorang.spring.service;

import top.xiaorang.spring.entity.Jobs;

import java.util.List;

/**
 * @author liulei
 */
public interface JobService {
	/**
	 * 查询所有的职位
	 *
	 * @return 职位集合
	 */
	List<Jobs> selectJobs();
}
