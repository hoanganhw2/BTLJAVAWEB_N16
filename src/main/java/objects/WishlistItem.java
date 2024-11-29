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
public class WishlistItem {
	private int wishlistitem_id;
	private int wishlistitem_userid; 
	private int wishlistitem_productid; 
	private Date wishlistitem_createAt; 
	private Date wishlistitem_updateAt;
}
