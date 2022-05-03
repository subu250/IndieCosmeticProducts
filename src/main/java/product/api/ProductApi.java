package product.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductApi{

	@JsonProperty("ProductApi")
	private List<ProductApiItem> productApi;

	public void setProductApi(List<ProductApiItem> productApi){
		this.productApi = productApi;
	}

	public List<ProductApiItem> getProductApi(){
		return productApi;
	}

	@Override
 	public String toString(){
		return 
			"ProductApi{" + 
			"productApi = '" + productApi + '\'' + 
			"}";
		}
}