package domain;

import lombok.Data;

@Data
public class CustomerDTO {
	
	private String rnum,
				   customerId, 
				   customerPw, 
				   customerName, 
				   address, 
				   city, 
				   postalCode,
				   ssn,
				   phone,
				   gender,
				   photo
				  ;
}
