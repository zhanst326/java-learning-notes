
public class XMLSalesFormatter implements SalesFormatter{
	private static XMLSalesFormatter singletonInstance;
	
	static public XMLSalesFormatter getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new XMLSalesFormatter();
		}
		return singletonInstance;
	}
	
	private XMLSalesFormatter() {
		
	}
	
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();
		sb.append("<Sales>\n");
		
		for(Order orders : sales) {
			sb.append("  <Order Total=").append("\"").append(orders.getTotalCost()).append("\">\n");
			for(OrderItem orderItems : orders) {
				sb.append("    <OrderItem quantity=").append("\"").append(orderItems.getQuantity()).append("\"")
				  .append(" ").append("price=").append("\"").append(orderItems.getProduct().getPrice()).append("\">").append(orderItems.getProduct().getCode()).append("</OrderItem>\n");
				  
			}	
			sb.append("  </Order>\n");
		}
		sb.append("<Sales>\n");
		return sb.toString();	
		
	}
	
}
