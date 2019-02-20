package domain;

public class OrderDetailDTO {

	private String orderdetailId, 
				   orderId, 
				   productId, 
				   quantity;


	public String getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(String orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [orderdetailId=" + orderdetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}
}
