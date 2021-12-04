package com.productreview.adapter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productreview.adapter.entities.ProductReviewDetails;
import com.productreview.adapter.repository.ProductReviewRepository;
import com.productreview.domainlayer.service.ProductReviewService;
import com.productreview.server.exceptions.InvalidInputException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ProductReviewServiceImpl.class);

	@Autowired
	private ProductReviewRepository prodRepo;
  

	@Override
	public Flux<ProductReviewDetails> reviewByProductId(String _prodId) {
		log.info("Find Product Review By Product Id=" + _prodId);

		if (_prodId == null) {
			Flux<ProductReviewDetails> fallback = Flux.error(new InvalidInputException("Invalid Id: " + _prodId));
			return fallback;
		}
		return prodRepo.findByProductIdAndActive(_prodId, true);
	}

	@Override
	public Mono<ProductReviewDetails> save(ProductReviewDetails _prod) {

		log.info("Save Product Review Details=" + _prod);

		if (_prod == null || !_prod.isValid()) {
			Mono<ProductReviewDetails> fallback = Mono.error(new InvalidInputException(ProductReviewDetails.invalidMsg()));
			return fallback;
		}

		return prodRepo.save(_prod);
	}

 
}
