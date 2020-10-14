::In case you change your local environment variable by some way, refresh the command terminal with the updated value
call refreshenv
call mvn clean -Dmaven.test.skip=true package
docker build -t gcr.io/%PROJECT_ID%/api:latest .
docker push gcr.io/%PROJECT_ID%/api:latest
