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
public class Category {
	public int category_id; 
	public String category_name;
	public String category_image;
	public Date category_createAt; 
	public Date category_updateAt;
}