import java.util.Iterator;
public class PlainTextSalesFormatter implements SalesFormatter{
	private static PlainTextSalesFormatter singletonInstance;
	
	static public PlainTextSalesFormatter getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}
	
	private PlainTextSalesFormatter() {
		
	};
	
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();
		int orderNumber = 1;
		for(Order orders : sales) {
			sb.append("------------------------\n")
			  .append("Order ")
			  .append(orderNumber++).append("\n\n");
			for(OrderItem orderItems : orders){
				
				sb.append(orderItems.getQuantity())
				  .append(" ")
				  .append(orderItems.getProduct().getCode())
				  .append(" ")
				  .append(orderItems.getProduct().getPrice())
				  .append("\n");
			}
			sb.append("\n");
			sb.append("Total = ").append(orders.getTotalCost());
			sb.append("\n");
			
		}
		return sb.toString();
		
	}
	
	
}
