package domain;

public class ShipperDTO {

		private String shipperId, shipperName, phone;

		public String getShipperId() {
			return shipperId;
		}

		public void setShipperId(String shipperId) {
			this.shipperId = shipperId;
		}

		public String getShipperName() {
			return shipperName;
		}

		public void setShipperName(String shipperName) {
			this.shipperName = shipperName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "ShipperDTO [shipperId=" + shipperId + ", shipperName=" + shipperName + ", phone=" + phone + "]";
		}

		
}
