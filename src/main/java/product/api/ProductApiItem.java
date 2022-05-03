package product.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductApiItem{

	@JsonProperty("website_link")
	private String websiteLink;

	@JsonProperty("image_link")
	private String imageLink;

	@JsonProperty("rating")
	private double rating;

	@JsonProperty("description")
	private String description;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("api_featured_image")
	private String apiFeaturedImage;

	@JsonProperty("product_type")
	private String productType;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("price")
	private String price;

	@JsonProperty("tag_list")
	private List<Object> tagList;

	@JsonProperty("name")
	private String name;

	@JsonProperty("price_sign")
	private Object priceSign;

	@JsonProperty("currency")
	private Object currency;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private Object category;

	@JsonProperty("product_colors")
	private List<Object> productColors;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("product_api_url")
	private String productApiUrl;

	@JsonProperty("product_link")
	private String productLink;

	public void setWebsiteLink(String websiteLink){
		this.websiteLink = websiteLink;
	}

	public String getWebsiteLink(){
		return websiteLink;
	}

	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}

	public String getImageLink(){
		return imageLink;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setApiFeaturedImage(String apiFeaturedImage){
		this.apiFeaturedImage = apiFeaturedImage;
	}

	public String getApiFeaturedImage(){
		return apiFeaturedImage;
	}

	public void setProductType(String productType){
		this.productType = productType;
	}

	public String getProductType(){
		return productType;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setTagList(List<Object> tagList){
		this.tagList = tagList;
	}

	public List<Object> getTagList(){
		return tagList;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPriceSign(Object priceSign){
		this.priceSign = priceSign;
	}

	public Object getPriceSign(){
		return priceSign;
	}

	public void setCurrency(Object currency){
		this.currency = currency;
	}

	public Object getCurrency(){
		return currency;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(Object category){
		this.category = category;
	}

	public Object getCategory(){
		return category;
	}

	public void setProductColors(List<Object> productColors){
		this.productColors = productColors;
	}

	public List<Object> getProductColors(){
		return productColors;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	public void setProductApiUrl(String productApiUrl){
		this.productApiUrl = productApiUrl;
	}

	public String getProductApiUrl(){
		return productApiUrl;
	}

	public void setProductLink(String productLink){
		this.productLink = productLink;
	}

	public String getProductLink(){
		return productLink;
	}

	@Override
 	public String toString(){
		return 
			"ProductApiItem{" + 
			"website_link = '" + websiteLink + '\'' + 
			",image_link = '" + imageLink + '\'' + 
			",rating = '" + rating + '\'' + 
			",description = '" + description + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",api_featured_image = '" + apiFeaturedImage + '\'' + 
			",product_type = '" + productType + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",price = '" + price + '\'' + 
			",tag_list = '" + tagList + '\'' + 
			",name = '" + name + '\'' + 
			",price_sign = '" + priceSign + '\'' + 
			",currency = '" + currency + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",product_colors = '" + productColors + '\'' + 
			",brand = '" + brand + '\'' + 
			",product_api_url = '" + productApiUrl + '\'' + 
			",product_link = '" + productLink + '\'' + 
			"}";
		}
}