
#Kubernetes

##Prerequisite
Your need a static IP address for the ingress controller. 
It's currently setup with Google Cloud, as ``bbhorty-ip-adress``. If the provider change, please read the documentation and moidify the ingress accordingly

##Kubernetes secret
Secret are used to make the kubernetes configuration files github compatible, since secret must be hidden.
You need at least to setup the database environment variable seen in the [README.md](README.md)
```
kubectl create secret generic mysql-db --from-literal=url=%MYSQL_HOST% --from-literal=port=%MYSQL_PORT% --from-literal=username=%MYSQL_USER% --from-literal=password=%MYSQL_PWD%
```
## Setup API on Kubernetes with Google Cloud
You can now apply the config file to your kubernetes server.
Please ensure the deployment file is parametrized with the right docker repository.


```
cd kubernetes
cd deployments
kubectl apply -f kube_deployment_api.yaml
cd ..
cd hpa
kubectl apply -f kube_horizontal_pod_scaling.yaml
cd ..
cd services
kubectl apply -f kube_service_api.yaml
cd ..
cd ingress
kubectl apply -f kube_ingress_api.yaml
cd ..
cd ..
```

##Congratulation

Now, the api is now exposed to your IP address.
