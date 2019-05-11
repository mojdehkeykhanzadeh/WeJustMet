# WeJustMet
# Team Members

| Name | ID |
| --- | --- |
| Rajalakshmi Babu | 011486345 |
| Mojdeh Keykhanzadeh | 008129589 |
| Nathan (Sangwon) | 013748306 |
| Tommy Yao | 005080843 |



# Tasks
### Rajalakshmi Babu - Add Card API
### Mojdeh - Payment API , Android App (Add Card and Payment Screen)
### Nathan (Sangwon) - User Profile API
### Tommy - Order API

# Feature Set
### APIs for AddCard
### APIs for Payment
### APIs for User
### APIs for Order
### Android Mobile Application
### AWS ECS Deployment

# Design Decision
Our decision decision to implement each API was to use the Observer pattern. Even though our architecture was MVC pattern, our application has similarity with the Observer pattern. Since in the Observer pattern, the observer notifies updates to the subject, we designed our APIs receiving all the updated information to the related fields. For example, when an user makes payement, the user uses the same card information and card key from the AddCard API. </br>
For the Android application, we used the Singleton pattern. If an user started the application, it would store the specific information for the user such as user ID, and card number. Once the application is completed, a new user needs to be registered with a new user ID.

# Architecture Diagram (MVC Pattern)
![image](https://user-images.githubusercontent.com/30476448/57498846-5cd89400-7292-11e9-9aac-5a00b9244779.png)

# Components Diagram
![Software Component Diagram](https://user-images.githubusercontent.com/14917279/57505383-0167cf80-72ad-11e9-805f-bec8eea24d8b.png)

# Deployment Diagram
![image](https://user-images.githubusercontent.com/30476448/57506537-eb5c0e00-72b0-11e9-9855-594af0727923.png)

# UI Mockups 

## Register User Screen

![image](https://user-images.githubusercontent.com/33049718/57538375-24ba6b00-72fd-11e9-870e-d9959feeb4da.png)

## Manage Order Screen 

![image](https://user-images.githubusercontent.com/33049718/57538465-516e8280-72fd-11e9-9e09-8d32cd982222.png)

## Add Card Screen

![image](https://user-images.githubusercontent.com/33049718/57538117-91813580-72fc-11e9-8559-e57579695bd4.png)

## Payment Screen

![image](https://user-images.githubusercontent.com/33049718/57538178-b2498b00-72fc-11e9-8042-137579f49f04.png)

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

# Steps to run Android App
#### 1)Build Project by Running 
- Clean Project 
-  Make Project
#### 2) Create New Virtual Device ( version Oreo 8) and run the app


