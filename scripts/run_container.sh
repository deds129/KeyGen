docker build -t key_gen .
docker run -p 8080:8080 key_gen
docker exec -it java_postgres bash