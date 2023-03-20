FROM FCIIT_REGISTRY_PROXY/eclipse-temurin:17-jdk-alpine as build
RUN mkdir /opt/app
ADD . /opt/app/build
WORKDIR /opt/app/build
RUN chmod +x ./mvnw
RUN ./mvnw clean package
RUN cp ./target/pond-as-0.0.1-SNAPSHOT.jar /opt/app/app.jar
RUN rm -r /opt/app/build


FROM FCIIT_REGISTRY_PROXY/eclipse-temurin:17-jre-alpine as run
RUN mkdir /opt/app
WORKDIR /opt/app
COPY --from=build /opt/app/app.jar .
ENV JVM_ARGS=""
ENV APP_ARGS=""
ENV PROFILES=""
ENV PORT=80
EXPOSE 80
CMD java ${JVM_ARGS} -jar app.jar ${APP_ARGS} --server.port=${PORT} --spring.profiles.active=${PROFILES}
