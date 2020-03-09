# Phone Bridge Project (Microservices)

Docker commands to start mongodb before starting the application.

docker run -d -p 27017:27017 mongo  (For portal service)

docker run -d -p 27018:27017 mongo  (For user management service)

| Application  | Description | Port |
| ------------- | ------------- | ------------- |
| phonebridge-common  | Project with common files  | NA  |
| phonebridge-portal  | Portal service & campaign service  | 8080  |
| phone-bridge-ui  | User interface for phone bridge application  | 4200  |
| phonebridge-usermanagement  | Phone bridge user management  | 8081  |
| phonebridge-discovery  | Phone bridge eureka server  | 8761  |


![quote](https://www.success.com/wp-content/uploads/legacy/sites/default/files/new3.jpg)

