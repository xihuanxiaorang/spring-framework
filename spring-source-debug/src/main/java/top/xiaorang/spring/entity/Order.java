package top.xiaorang.spring.entity;

/**
 * @author liulei
 */
public class Order {
	private Integer orderId;
	private String orderName;

	public Order() {
	}

	public Order(Integer orderId, String orderName) {
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId='" + orderId + '\'' +
				", orderName='" + orderName + '\'' +
				'}';
	}
}
