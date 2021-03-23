# spring-boot-kafka-docker
An application with spring boot, kafka and docker

# To run it
* Create the docker images running `docker-compose up -d`
* Run the application
* Go to http://localhost:8081/graphiql to play with the graphql, example of mutation
```
# Example of including an organization, 
# When including an organization, a new kafka message will be sent with the new name
mutation {
  newOrganization (organization:{name:"newOrg"}) {
    id
    name
  }
}
```

* Go to http://localhost:8081/kafka/messages to check the kafka messages sent
* Go to http://localhost:8081/kafka/produce?message=Message%20sent%20by%20my%20App to send a message
