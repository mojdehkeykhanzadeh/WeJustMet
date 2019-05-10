# WeJustMet
# Team Members

| Name | ID |
| --- | --- |
| Rajalakshmi Babu | 011486345 |
| Mojdeh Keykhanzadeh | 008129589 |
| Nathan (Sangwon) |  |
| Tommy |  |



# Tasks
### Rajalakshmi Babu - Add Card API
### Mojdeh - Payment API , Android App (Add Card and Payment Screen)
### Nathan (Sangwon) - User Profile API
### Tommy - Order API

# Architecture Diagram
![image](https://user-images.githubusercontent.com/30476448/57498846-5cd89400-7292-11e9-9aac-5a00b9244779.png)

# Components Diagram
![Software Component Diagram](https://user-images.githubusercontent.com/14917279/57505383-0167cf80-72ad-11e9-805f-bec8eea24d8b.png)

# Deployment Diagram
![image](https://user-images.githubusercontent.com/30476448/57506537-eb5c0e00-72b0-11e9-9855-594af0727923.png)

# UI Mockups 

## Register User Screen

![image](https://user-images.githubusercontent.com/33049718/57508892-a38cb500-72b7-11e9-94a4-6832603a97ab.png)

## Manage Order Screen 

![image](https://user-images.githubusercontent.com/33049718/57508953-cfa83600-72b7-11e9-83c9-624bbd30cc2c.png)

## Add Card Screen

![image](https://user-images.githubusercontent.com/33049718/57508999-ee0e3180-72b7-11e9-93b1-9f2f2d1a258c.png)

## Payment Screen

![image](https://user-images.githubusercontent.com/33049718/57509035-0a11d300-72b8-11e9-8dea-e8d7b7ddae65.png)

# Steps to setup the backend project 
#### 1) Clone the project using the command- git clone {repository}
#### 2) Create jar file by running the command- mvn package
#### 3) Setup mongoDB credentials in application.properties file under resources
#### 4) Build the docker file using the command- docker image build -t starbucks:latest . 
#### 5) Log into AWS region using the command- aws ecr get-login --no-include-email --region us-east-1
#### 6) Create repository in AWS ECR
#### 7) Follow the command issued by AWS o push the docker image into AWS ECR
#### 8) Create cluster in AWS ECS
#### 9) Create Task definition by using the image
#### 10)Run the task in the cluster using the task definition


