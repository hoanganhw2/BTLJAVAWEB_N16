package objects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
public class Product {
	private int product_id;
	private String product_name; 
	private String product_image; 
	private String product_shortdesc;
	private String product_description;
	private float product_price;
	private float product_discount; 
	private int product_quantity; 
	private String product_target; 
	private int product_category;
	private Date product_creatAt;
	private Date product_updateAt;

	
	
	
	
	

}
