# Containerized Application Deployment: Comparing Traditional CI vs Jib & Skaffold
This repository demonstrates the differences between a regular CI pipeline and using containerization-focused tools like Jib and Skaffold for deploying an application.

## Traditional CI Approach
The traditional CI approach involves the following steps:

- Maven Clean and Package: Run mvn clean package to build the application artifact.
- Docker Build and Push: Build a Docker image using docker build -t pmu/image . and push it to a registry with docker push pmu/image:1.0.0.
- Kubernetes Deployment: Create a deployment.yaml file and apply it using kubectl apply -f deployment.yaml to deploy the application to a Kubernetes cluster.
- Kubernetes Monitoring: Use kubectl get pods and kubectl logs to manage and monitor the deployed application.

## Jib and Skaffold Approach
The repository also showcases how Jib and Skaffold can simplify and streamline the containerization and deployment process:

- Jib: Jib is a containerization tool that can build Docker and OCI images for Java applications without a Docker daemon. It handles the image build and push steps in a more integrated manner.
- Skaffold: Skaffold is a workflow tool for Kubernetes development. It automates the build, push, and deploy steps, allowing for a more seamless development-to-production workflow.
By using Jib and Skaffold, the deployment process can be reduced to a single command, improving developer productivity and reliability.