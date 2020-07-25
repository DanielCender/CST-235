package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	// List<Orders>, but instructions infer that it means this, right?...
	private ArrayList<Order> orders;
	
	public Orders() {
		this.orders = new ArrayList<Order>();
		this.orders.add(new Order("1", "Nails", 43, 1.50f));
		this.orders.add(new Order("2", "screwdriver", 1, 23));
		this.orders.add(new Order("3", "Plywood", 1, 50));
		this.orders.add(new Order("4", "Hammer", 1, 800.50f));
	}

	public ArrayList<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
