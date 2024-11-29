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
	public String order_satuts; 
	public String order_delivery;
	public Date order_creatAt;
	public Date order_updateAt;
}

