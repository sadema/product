FROM openjdk:8-alpine
RUN mkdir /usr/local/share/inschrijving-product
COPY artifacts/product-0.1.1-SNAPSHOT.jar /usr/local/share/inschrijving-product
EXPOSE 8083
CMD ["java", "-jar", "/usr/local/share/inschrijving-product/product-0.1.1-SNAPSHOT.jar"]
