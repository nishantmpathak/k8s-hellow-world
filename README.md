Build the project to create the jar file:
mvn clean package

Run the container to test if it works:
docker run -p 8080:8080 demo-spring-boot-app

Start Minikube or ensure your local Kubernetes cluster is running:
minikube start

Apply the deployment and service configuration:
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml

Verify the deployment and service:
kubectl get deployments
kubectl get services

Get the Minikube IP:
minikube ip

Access your application:
Open a browser and go to http://<minikube-ip>:30007/hello.

Above did not work for me I need make tunneling below command worked for me. It started browser with some new IP id
Sometimes Minikube may need a tunnel to expose services. Run:
minikube service demo-spring-boot-app

If we do any change in config-map, we need redeploy the pods to see changes
kubectl rollout restart deployment demo-spring-boot-app