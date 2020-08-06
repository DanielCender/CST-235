package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/jms/queue/Order")
	private Queue queue;
	
	@Inject
	OrdersDataService service;

	private List<Order> orders;

	/**
	 * Default constructor.
	 */
	public OrdersBusinessService() {
		this.orders = new ArrayList<Order>();
//		this.orders.add(new Order("1", "Nails", 43, 1.50f));
//		this.orders.add(new Order("2", "screwdriver", 1, 23));
	}

	/**
	 * @see OrdersBusinessInterface#test()
	 */
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	@Override
	public List<Order> getOrders() {
		return service.getAll();
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void sendOrder(Order order) {
		System.out.println("Queue: " + queue.toString());
		// Send a Message for an Order
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			
			connection.close();
		} catch (JMSException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
