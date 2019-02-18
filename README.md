# Adapter-Akka

* the OBP-API project should checkout `feature/remote_akka`, if it is not send pull request, you can find it at [oldbig rep](https://github.com/oldbig/OBP-API/tree/feature/remote_akka)
* the default.props file in OBP-API should have the follow settings
```
connector=akka_vDec2018
akka_connector.hostname=127.0.0.1
akka_connector.port=2662
```

currently, only "Get Adapter Info (general)" endpoint is works.
in the project folder, execute follow command to pacakge and start project

```
  mvn package
  cd target
  java -jar akka-adapter-0.0.1-SNAPSHOT.jar
```
