echo -e "\\nStarting docker container rabbitMQ...\\n"
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
echo -e "\\nTo stop the event broker, execute: docker stop rabbitMQ\\n"
