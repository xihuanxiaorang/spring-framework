package top.xiaorang.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiaorang.spring.entity.Order;
import top.xiaorang.spring.mapper.OrderMapper;
import top.xiaorang.spring.service.OrderService;

import java.util.List;

/**
 * @author liulei
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> selectOrders() {
		return orderMapper.selectOrders();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void saveOrder(Order order) {
		orderMapper.saveOrder(order);
		throw new RuntimeException("故意抛出异常~~");
	}
}
