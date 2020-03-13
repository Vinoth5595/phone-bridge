# phone bridge config server

While application is running, we can commit the property changes to github and use the below url to update the changes commited in the github to the application without restarting. We can also automate the same using Github webhook. But, we have to deploy it in the cloud to achieve that. 

| Application  | Description | Swagger URL |
| ------------- | ------------- | ------------- |
| phonebridge-usermanagement  | Phone bridge config server property refresh URL (POST request)  | http://localhost:8888/actuator/bus-refresh  |


