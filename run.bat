
::In case you change your local environment variable by some way, refresh the command terminal with the updated value
call refreshenv

:: Run a fresh new container
call mvn clean -Dmaven.test.skip=true package
docker-compose build --no-cache
docker-compose up
