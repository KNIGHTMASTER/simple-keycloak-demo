[![Build Status](https://travis-ci.org/KNIGHTMASTER/spring-zipkin-example.svg)](https://travis-ci.org/KNIGHTMASTER/spring-zipkin-example/)

# simple-keycloak-demo
SpringBoot Demo Application Integrated with KeyCloak 

This projects shows how to use Keycloak Central Authentication Service and Related Application
There are several ways how to use Authentication with Keycloak :
1. Using Keycloak adapter as Mentioned Here : http://www.keycloak.org/docs/3.0/securing_apps/topics/overview/what-are-client-adapters.html and Here : http://www.keycloak.org/docs/3.0/securing_apps/topics/overview/supported-platforms.html
2. Using Token Authorization with OAuth2.0 as Mentioned Here : https://docs.jboss.org/author/display/teiid812final/OAuth2+based+security+for+OData+using+KeyCloak

### Client One
Client One is a Simple Web Application that will be authenticated through Native Java Adapter for Keycloak
All URL after path :"/products/" will be accessible for role user
All URL after path :"/admin/" will be accessible for role admin

### Client Two
Client Two is Simple Web Application that will consume protected Data from `Rest-App`.
Client Two consume the protected Data from "/productFromRest" using Native Adapter via API call
Client Two consume the protected Data from "/productFromAccessToken" via Token Request. This example can be used by any programming languages especially that is not supported by keycloak adapters

### Rest App
Rest App is Simple Rest Application protected by Keycloak