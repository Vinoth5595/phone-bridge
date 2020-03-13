# Phone Bridge Project (Microservices)

docker-compose up (To start MongoDB & Apache Kafka)

docker-compose down (To stop MongoDB & Apache Kafka)

Start the application in the below order.

| Application  | Description | Port |
| ------------- | ------------- | ------------- |
| phonebridge-discovery  | Phone bridge eureka server  | 8761  |
| phonebridge-config-server  | Phone bridge config server  | 8888  |
| phonebridge-portal  | Portal service & campaign service  | 8080  |
| phonebridge-authserver  | Phone bridge auth server  | 8081  |
| phone-bridge-ui  | User interface for phone bridge application  | 4200  |
| phonebridge-common  | Project with common files  | NA  |

