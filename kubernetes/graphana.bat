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