package top.xiaorang.spring.service;

import top.xiaorang.spring.entity.Order;

import java.util.List;

/**
 * @author liulei
 */
public interface OrderService {
	/**
	 * 查询所有的订单
	 * @return 订单集合
	 */
	List<Order> selectOrders();

	/**
	 * 保存订单
	 * @param order 订单
	 */
	void saveOrder(Order order);
}
