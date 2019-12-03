echo -e "\\nStarting docker container postgresDB...\\n"
docker run --rm --name postgres -d -p 5432:5432 postgres
echo -e "\\nTo stop the database, execute: docker stop postgresDB\\n"
