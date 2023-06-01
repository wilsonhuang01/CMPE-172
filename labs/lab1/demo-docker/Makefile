clean:
	mvn clean

compile:
	mvn compile

run:
	mvn spring-boot:run

build:
	mvn package

run-jar:
	java -jar target/demo-docker-1.0.jar

# Docker

docker-build: jar
	docker build --platform=linux/amd64 -t demo-docker .
	docker images

docker-run: docker-build
	docker run --name demo-docker1 --platform=linux/amd64 -td -p 80:8080 demo-docker
	docker ps

docker-clean:
	docker stop demo-docker
	docker rm demo-docker
	docker rmi demo-docker

docker-shell:
	docker exec -it demo-docker bash
