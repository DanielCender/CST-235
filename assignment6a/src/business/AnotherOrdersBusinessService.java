package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	private List<Order> orders;
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
    	this.orders = new ArrayList<Order>();
		this.orders.add(new Order("1", "Nails", 43, 1.50f));
		this.orders.add(new Order("2", "screwdriver", 1, 23));
		this.orders.add(new Order("3", "Plywood", 1, 50));
		this.orders.add(new Order("4", "Hammer", 1, 800.50f));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void sendOrder(Order order) {}

}
