ps:
	cd ./docker && docker-compose ps

up:
	cd ./docker && docker-compose up -d

redis:
	cd ./docker && docker-compose up -d redis

activemq:
	cd ./docker && docker-compose up -d activemq

down:
	cd ./docker && docker-compose down

redis-cli:
	cd ./docker && docker-compose run redis redis-cli -h redis
	# https://redis.io/topics/rediscli

activemq-cli:
	cd ./docker && docker-compose run activemq activemq-admin -–amqurl tcp://activemq:61616
	# https://activemq.apache.org/activemq-command-line-tools-reference