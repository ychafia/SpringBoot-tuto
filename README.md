# This repository contain a different tutorial of Spring boot & Java 8 :

Le but de ce projet est de développer une application, MSA, MicroService Architecture.

SpringBoot-tuto est une API Rest, qui expose des services web Restfull, et qui seront utilisés ultériement par Home-app
(https://github.com/ychafia/home-app)


* Mise en place des API Rest.
* Une application à trois couches ; @RestController, @Service, et DAO
* Gestion de exceptions.
* Les Responses des web services sont standarisées  : (CREATED, NOT_FOUND, FORBIDEN, ...) dans des ResponsesEntity
* Une systeme d'audit : grâce à @EntityListeners(AuditingEntityListener.class)
* Des tests unitaires  : avec les framework JUnit, Mockito. et un bon taux de couverture.
