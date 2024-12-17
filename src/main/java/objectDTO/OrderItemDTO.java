package objectDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDTO {
	public int id;
	public int orderid;
	public int productid; 
	public String image ;
	public String productname;
	public float price; 
	public int quantity;

}
