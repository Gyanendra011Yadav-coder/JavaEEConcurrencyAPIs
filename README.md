The Java EE Concurrency API provides a set of high-level constructs for concurrent programming in Java EE applications. It defines a standard way for developers to write scalable, concurrent applications in a consistent and easily understandable way. The API includes features such as managed executors, managed scheduled executors, and context services. The Concurrency API is available in Java EE 7 and later versions.

# Build
mvn clean package && docker build -t com.mycompany/JavaEEConcurrency .

# RUN

docker rm -f JavaEEConcurrency || true && docker run -d -p 8080:8080 -p 4848:4848 --name JavaEEConcurrency com.mycompany/JavaEEConcurrency 
