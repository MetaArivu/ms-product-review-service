package com.productreview.adapter.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(value = "product_review_details")
public class ProductReviewDetails extends BaseEntity {

	@Indexed
	private String productId;
	private String reviewerName;
	private String description;
	private Integer rating;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public static String invalidMsg() {
		return "Please enter valid Product Review data (LoginId/Name)";
	}

	@Override
	public String toString() {
		return id + "|" + productId + "|" + reviewerName + "|" + description + " " + rating;
	}

	@JsonIgnore
	@Override
	public boolean isValid() {
		return true;
	}

}
