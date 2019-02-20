package domain;

public class OrderDTO {

	private String orderId, 
				   customerId, 
				   employeeId, 
				   orderdate, 
				   shipperId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [orderId=" + orderId + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", orderdate=" + orderdate + ", shipperId=" + shipperId + "]";
	}
}
