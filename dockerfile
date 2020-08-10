FROM frolvlad/alpine-java:jdk8-slim
WORKDIR /home/
VOLUME /tmp
ADD target/emp-portal-maven.jar /home/app.jar
ADD startproject.sh /home/startproject.sh
RUN chmod -R 775 /home/startproject.sh
CMD /home/startproject.sh