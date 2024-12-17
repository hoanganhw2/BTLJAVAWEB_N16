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
public class CartItem {
	private int cartitem_id;
	private int cartitem_cartid;
	private int cartitem_productid; 
	private int cartitem_quantity;
	private float cartitem_price;
	private Date cartitem_creatAt; 
	private Date cartitem_updateAt;
	
}
