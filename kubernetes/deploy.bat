::General Setup
@echo off

cd namespace
kubectl apply -f bbhorty.yaml
cd ..

cd ingress
kubectl apply -f ingress.yaml
cd ..

::Api
cd api

cd deployment
kubectl apply -f deployment.yaml
cd ..

cd hpa
kubectl apply -f hpa.yaml
cd ..

cd service
kubectl apply -f service.yaml
cd ..

cd ..

:: Grafana

cd grafana

cd deployment
kubectl apply -f deployment.yaml
cd ..

cd configmap
kubectl apply -f configmap.yaml
cd ..

cd service
kubectl apply -f service.yaml
cd ..

cd ..