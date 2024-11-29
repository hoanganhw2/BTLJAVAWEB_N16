package objects;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private int cart_id;
	private int cart_userid; 
	private int cart_sum; 
	private Date cart_creatAt;
	private Date cart_updateAt;
	
	
}

