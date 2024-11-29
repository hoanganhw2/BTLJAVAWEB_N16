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
public class Role {
	public int role_id;
	public String role_name;
	public String role_description;
	public Date role_createAt;
	public Date role_updateAt;
	
	
}
