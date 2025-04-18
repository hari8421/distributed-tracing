# distributed-tracing

Distributed tracing using Zipkin, sleuth,
Spring boot 3.4 + Java 21

Spring boot application contains a simple API to save and retrive data from a Mongo DB container, pls run the application and hit the API's. You should be able to see the traces on Zipkin UI, follow below steps to run Zipkin in local server.

Run Zipkin server using command - docker run -d -p 9411:9411 openzipkin/zipkin

Zipkin dashboard can be accessed in - http://localhost:9411/zipkin/

