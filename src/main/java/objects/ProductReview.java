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
public class ProductReview {
	public int productreview_id; 
	public int productreview_userid;
	public int productreview_productid; 
	public boolean productreview_status; 
	public String productreview_content;
	public int productreview_ratingscore;
	public Date productreview_createAt;
	public Date productreview_updateAt;
}
