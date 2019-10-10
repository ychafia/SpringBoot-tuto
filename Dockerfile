FROM openjdk:8
ADD target/docker-msa-project.war docker-msa-project.war
EXPOSE 9095
ENTRYPOINT ["java", "-jar", "docker-msa-project.war"]