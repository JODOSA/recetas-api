.PHONY: *

up:
	docker compose up -d

build:
	docker compose build --no-cache

ssh:
	docker exec -it --user 1000 recetas-api-php-1 bash

ssh-root:
	docker exec -it recetas-api-php-1 bash
