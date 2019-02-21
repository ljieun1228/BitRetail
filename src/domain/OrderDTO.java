package domain;

import lombok.Data;

@Data
public class OrderDTO {

	private String orderId, 
				   customerId, 
				   employeeId, 
				   orderdate, 
				   shipperId;

}
