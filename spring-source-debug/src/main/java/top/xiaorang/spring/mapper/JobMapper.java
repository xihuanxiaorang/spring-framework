package top.xiaorang.spring.mapper;

import top.xiaorang.spring.entity.Jobs;

import java.util.List;

/**
 * @author liulei
 */
public interface JobMapper {
	/**
	 * 查询所有的职位
	 *
	 * @return 职位集合
	 */
	List<Jobs> selectJobs();

	/**
	 * 保存职位
	 * @param jobs 职位
	 */
	void saveJobs(Jobs jobs);
}
