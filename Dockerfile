FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/compojure-api-strong-coercions.jar /compojure-api-strong-coercions/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/compojure-api-strong-coercions/app.jar"]
