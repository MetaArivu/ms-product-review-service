package com.productreview.adapter.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productreview.adapter.entities.ProductReviewDetails;

import reactor.core.publisher.Flux;

@Repository
public interface ProductReviewRepository extends ReactiveMongoRepository<ProductReviewDetails, String> {

	public Flux<ProductReviewDetails> findByProductIdAndActive(String id, boolean active);
	

}
