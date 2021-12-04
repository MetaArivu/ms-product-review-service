# Product Review Micro Service

## BUILD & Run Locally
- mvn clean install
- mvn spring-boot:run 
  - This will start server on port 6063


## API

- Welcome API
  - curl --location --request GET 'http://localhost:6063/product-review-service/welcome'

- Add New Product Review
  - Get Product ID From Product API
  - curl --location --request POST 'http://localhost:6063/product-review-service/api/v1/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfQURNSU4iXSwic3ViIjoiNjFhYWY2NmFjNGE5ODE2YTM2OGUyNTAyfG5haTF0aWsuZ290ZSIsImlhdCI6MTYzODU5NDE2MCwiZXhwIjoxNjM4NjIyOTYwfQ.rx_Ggv1LwKu4P4LMno4QAS3rXyBZFi0WqTkzoHVGpUuN-D12VSslFDzgjMtJvn3DkzBDFxAwD6OHAKEf68bg8A' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productId":"61ab15738241c00664e89344",
    "reviewerName":"ketan.gote",
    "description":"Awesome Product",
    "rating":4
}'

- Reviews By Product ID
  - curl --location --request GET 'http://localhost:6063/product-review-service/api/v1/61ab15738241c00664e89344' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfQURNSU4iXSwic3ViIjoiNjFhYWY2NmFjNGE5ODE2YTM2OGUyNTAyfG5haTF0aWsuZ290ZSIsImlhdCI6MTYzODU5NDE2MCwiZXhwIjoxNjM4NjIyOTYwfQ.rx_Ggv1LwKu4P4LMno4QAS3rXyBZFi0WqTkzoHVGpUuN-D12VSslFDzgjMtJvn3DkzBDFxAwD6OHAKEf68bg8A'


## License  

Copyright © [MetaMagic Global Inc](http://www.metamagicglobal.com/), 2021-22.  All rights reserved.

Licensed under the Apache 2.0 License.

**Enjoy!**

