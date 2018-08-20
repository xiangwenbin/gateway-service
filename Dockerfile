FROM java:8
ENV HTTP_PORT 8100
ENV TZ Asia/Shanghai
ENV JAVA_OPTIONS ''
COPY target/gateway-service-*-SNAPSHOT.jar /urs/local/www/gateway-service.jar
WORKDIR /urs/local/www/
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME [ "/home/logs/gateway-service" ]
EXPOSE 8100
#容器启动时候启动命令
ENTRYPOINT java $JAVA_OPTIONS -Dspring.profiles.active=$PROFILE_ACTIVE -jar gateway-service.jar 
#ENTRYPOINT ["java","-jar", "gateway-service.jar"]
LABEL version="1.0.0" author="wbxiang@zhcpa.cn"