FROM java:8
VOLUME /tmp
ADD target/sprinboot-jwt-mongo-demo-0.0.1-SNAPSHOT.jar springboot-jwt-mongo-demo.jar
EXPOSE 8090
RUN bash -c 'touch /springboot-jwt-mongo-demo.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/studentsinformation", "-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-jwt-mongo-demo.jar"]