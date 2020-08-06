package beans;
import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderId;
	private String productName;
	private float price;
	private float quantity;
	
	public Order() {
	}
	
	public Order(String orderId, String productName, float price, float quantity) {
		Objects.requireNonNull(orderId);
		Objects.requireNonNull(productName);
	    Objects.requireNonNull(price);
	    Objects.requireNonNull(quantity);
		
		this.setOrderId(orderId);
		this.setProductName(productName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
