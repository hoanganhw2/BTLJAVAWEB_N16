package objects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
	public int orderitem_id; 
	public int orderitem_orderid; 
	public int orderitem_productid;
	public float orderitem_price; 
	public int orderitem_quantity; 
	public Date orderitem_creatAt;
	public Date orderitem_updateAt;
}
