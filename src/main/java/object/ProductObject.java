package object;

public class ProductObject {
	private int product_id;
	private String product_name;
	private String product_image;
	private String product_shortdesc;
	private String product_description;
	private String product_price;
	private String product_discount;
	private String product_quantity;
	private String product_target;
	private String product_category;
	private String product_createAt;
	private String product_updateAt;
	
	public ProductObject(int product_id, String product_name, String product_image, String shortdesc, String product_description,
			String product_price, String product_discount, String product_quantity, String product_target, String product_category, String product_createAt, String product_updateAt) {

		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_shortdesc = product_shortdesc;
		this.product_description = product_description;
		this.product_price = product_price;
		this.product_discount = product_discount;
		this.product_quantity = product_quantity;
		this.product_target = product_target;
		this.product_category = product_category;
		this.product_createAt = product_createAt;
		this.product_updateAt = product_updateAt;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setUser_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_shortdesc() {
		return product_shortdesc;
	}

	public void setUser_shortdesc(String product_shortdesc) {
		this.product_shortdesc = product_shortdesc;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setUser_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(String product_discount) {
		this.product_discount = product_discount;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_target() {
		return product_target;
	}

	public void setProduct_target(String product_target) {
		this.product_target = product_target;
		
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
	public String getProduct_createAt() {
		return product_createAt;
	}

	public void setProduct_createAt(String product_createAt) {
		this.product_createAt = product_createAt;
	}

	public String getProduct_updateAt() {
		return product_createAt;
	}

	public void setProduct_updateAt(String product_updateAt) {
		this.product_updateAt = product_updateAt;
	}

	@Override
	public String toString() {
		return "ProductObject [product_id=" + product_id + ", product_name=" + product_name + ", product_image="
				+ product_image + ", product_shortdesc=" + product_shortdesc + ", product_description="
				+ product_description + ", product_price=" + product_price + ", product_discount=" + product_discount
				+ ", product_quantity=" + product_quantity + ", product_target=" + product_target
				+ ", product_category=" + product_category + ", product_createAt=" + product_createAt
				+ ", product_updateAt=" + product_updateAt + "]";
	}


	
}
