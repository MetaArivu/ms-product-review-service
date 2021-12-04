package com.productreview.adapter.controller.v1;

import static com.productreview.APPConstant.V1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productreview.adapter.dto.Response;
import com.productreview.adapter.entities.ProductReviewDetails;
import com.productreview.domainlayer.service.ProductReviewService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(V1)
public class ProductReviewController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ProductReviewController.class);

	@Autowired
	private ProductReviewService svc;

 
	@PostMapping(value = "/")
	public Mono<ResponseEntity<Response<ProductReviewDetails>>> save(@RequestBody ProductReviewDetails _prod) {

		return svc.save(_prod).map(prod -> {
			return new ResponseEntity<Response<ProductReviewDetails>>(
					new Response<ProductReviewDetails>(true, "Record Saved Successully", prod), HttpStatus.OK);
		}).defaultIfEmpty(new ResponseEntity<Response<ProductReviewDetails>>(
				new Response<ProductReviewDetails>(false, "Record Not Saved Successully"), HttpStatus.NOT_FOUND));

	}
	
	@GetMapping(value = "/{id}")
	public Mono<ResponseEntity<Response<List<ProductReviewDetails>>>> reviewByProductId(@PathVariable("id") String id) {

		return svc.reviewByProductId(id).collectList()
				.map(list -> new ResponseEntity<Response<List<ProductReviewDetails>>>(
						new Response<List<ProductReviewDetails>>(true, "Record retrieved successully", list), HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Response<List<ProductReviewDetails>>>(
						new Response<List<ProductReviewDetails>>(false, "Record not found"), HttpStatus.NOT_FOUND));

	}
}
