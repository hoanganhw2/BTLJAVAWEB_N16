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
public class Order {
	public int order_id;
	public int order_userid;
	public float order_price; 
	public int order_satuts; 
	public int order_delivery;
	public String  order_fullname;
	public String  order_phone;
	public String  order_address;
	public Date order_creatAt;
	public Date order_updateAt;
}

