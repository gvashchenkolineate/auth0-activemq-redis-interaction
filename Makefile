ps:
	cd ./docker && docker-compose ps

up:
	cd ./docker && docker-compose up -d

redis:
	cd ./docker && docker-compose up -d redis

down:
	cd ./docker && docker-compose down

redis-cli:
	cd ./docker && docker-compose run redis redis-cli -h redis
	# https://redis.io/topics/rediscli