package objectDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItemDTO {
	private int id;
	private int cart_id;
	private int product_id;
	private String name;
	private String image;
	private float price ;
	private int quantity;
	
}
