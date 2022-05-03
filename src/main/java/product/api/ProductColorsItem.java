package product.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductColorsItem{

	@JsonProperty("colour_name")
	private String colourName;

	@JsonProperty("hex_value")
	private String hexValue;

	public void setColourName(String colourName){
		this.colourName = colourName;
	}

	public String getColourName(){
		return colourName;
	}

	public void setHexValue(String hexValue){
		this.hexValue = hexValue;
	}

	public String getHexValue(){
		return hexValue;
	}

	@Override
 	public String toString(){
		return 
			"ProductColorsItem{" + 
			"colour_name = '" + colourName + '\'' + 
			",hex_value = '" + hexValue + '\'' + 
			"}";
		}
}