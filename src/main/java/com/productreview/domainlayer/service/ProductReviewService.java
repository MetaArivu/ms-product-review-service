package com.productreview.domainlayer.service;

import com.productreview.adapter.entities.ProductReviewDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductReviewService {

	public Flux<ProductReviewDetails> reviewByProductId(String _prodId);
	
	public Mono<ProductReviewDetails> save(ProductReviewDetails _prodReview);
	
	
}
