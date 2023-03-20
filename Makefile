start-server:
	mvn clean
	mvn compile
	mvn spring-boot:run

watch-frontend:
	npm run --prefix frontend dev -- --open	

mongodb:
	docker-compose down
	docker-compose up
