package ValidateUtils;

public class ProductValidate {
	
	private static ProductValidate productValidate;

	public static ProductValidate getProductValidate() {
		if(productValidate  == null) {
			productValidate = new ProductValidate();
			return productValidate;
		}
		return productValidate;
	}
	// kiểm tra tên
	public boolean validateProductName(String ProductName) {
		boolean flag = true ;
		
		if(ProductName.trim().equals("") || ProductName.length() <6 || ProductName==null ){
			flag=false ;
		}	
		return flag ;
	}
	// Kiem tra gia
	public boolean validatePrice(String price) {
		boolean flag =true ;
		try {
			double pricef =Float.parseFloat(price);
			if(pricef <1) {
				flag=false;
			
			}
			
		} catch (NullPointerException e) {
			System.out.println("Có lỗi xảy ra :"+e.getMessage());
			flag = false;
			return flag;
		}
		return flag;
	}
	// Kiêm so luong 
	public boolean valideQuantity(String quantity) {
		boolean flag = true ;
		try {
			int quantityI =Integer.parseInt(quantity);
			if(quantityI < 0)  flag = false ;
		} catch (NumberFormatException e) {
			return false ;
		}
		return flag;
	}
	
}
