Build the project to create the jar file:
mvn clean package

create image from Dockerfile
docker build -t demo-spring-boot-app .

Run the container to test if it works:
docker run -p 8080:8080 demo-spring-boot-app

tag and push the docker image on dockerhub
docker tag demo-spring-boot-app:latest {docker-hub-user}/demo-spring-boot-app:latest
docker push {docker-hub-user}/demo-spring-boot-app:latest

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

Jenkins Download and run on MAC
Install the latest LTS version: brew install jenkins-lts
Start the Jenkins service: brew services start jenkins-lts
Restart the Jenkins service: brew services restart jenkins-lts
Update the Jenkins version: brew upgrade jenkins-lts
http://localhost:8080