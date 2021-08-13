FROM openjdk:8

WORKDIR /tmp/app

COPY ./build/libs ./

ENTRYPOINT ["java", "-jar", "booking-0.0.1-SNAPSHOT.jar"]
