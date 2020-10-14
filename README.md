#How to run the API

##First Setup Environment Variable

###Database

```
setx MYSQL_HOST "localhost"
setx MYSQL_PORT "3306"
setx MYSQL_USER "admin"
setx MYSQL_PWD "pwd"
```

## Run the api locally

Execute ``run.bat``

## Cloud deployment (Google)
This part expect your database is already exposed on the cloud


### 1: Register

Let your console to connect to your account
```
gcloud auth configure-docker
```

### 2: Setup Project ID

```
setx GOOGLE_PROJECT_ID "project_id"
setx PROJECT_ID %GOOGLE_PROJECT_ID%
```

### 3: Push your image

You can now push your docker image to the google repository. If you change this provider, please ensure you also change the deployment file.
Use ``docker push`` to use it.

### 4: Setup Kubernetes

Please read the [KUBERNETES.md](KUBERNETES.md) to have all the details. 

### 5: Deploy

run ``deploy.bat``


