
public class HTMLSalesFormatter implements SalesFormatter{
	private static HTMLSalesFormatter singletonInstance;
	
	static public HTMLSalesFormatter getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatter();
		}
		return singletonInstance;
	}
	
	private HTMLSalesFormatter() {
		
	}
	
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("  <body>\n");
		sb.append("    <center><h2>Orders</h2></center>\n");
		for(Order orders : sales) {
			sb.append("    <hr>\n")
			  .append("    <h4>Total = ").append(orders.getTotalCost()).append("</h4>\n");
			  
			for(OrderItem orderItems : orders) {
				sb.append("      <p>\n")
				  .append("        <b>code:</b> ").append(orderItems.getProduct().getCode()).append("<br>\n")
				  .append("        <b>quantity:</b> ").append(orderItems.getQuantity()).append("<br>\n")
				  .append("        <b>price:</b> ").append(orderItems.getProduct().getPrice()).append("\n")
				  .append("      </p>\n");
			}
		}
		sb.append("  </body>\n");
		sb.append("</html>");
		return sb.toString();
	}
	
}
