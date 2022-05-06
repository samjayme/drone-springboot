#DRONE MEDICATION DELIVERY PROGRAM
This  program is an abstract model for DRONES. A fleet of drones is created to be able to deliver items to any specified location. 
each drone can only carry items lesser than or equal to it weight limit in grams and eah drone is grouped based on MODEL ranging from HEAVYWEIGHT
,CRUISE WEIGHT and LIGHTWEIGHT
.Drone state includes IDLE,LOADING,LOADED, DELIVERED and a drone is allowed to load if it's battery level in percentage is above 25% and state is IDLE.
.The program has scheduled routine check periodically to check for drones battery level  
The medication/s to be delivered are also weighted in grams  and can be loaded to the drones in as group.  


## INSTALLATION:
Using any of your favourite java editor(ECLIPSE,INTELLIJ IDEA e.t.c) download or  clone the file and open in the editor. As this is a spring boot MAVEN program ,
necessary plugins and dependencies would be installed alongside the file in the editor
## #USAGE:
The program is developed using spring MVC(MODEL,VIEW,CONTROL)ARCHITECTURE ,AOP(ASPECT ORIENTED PROGRAMING),three layer architecture pattern.  
The program is group into packages based on cross-cutting concerns, (ENTITY,SERVICE,REPOSITORY,CONTROLLER,EXCEPTION,SCHEDULER)  
The entity package contains an abstract attributes of the DRONES and MEDICATIONS, service package is for business logic for the program requirements,repository package contains an interface for connecting to teh DATABASE(MYSQL)  
controller package contains a class defined for each endpoint for service layer. 

  
1. REGISTER DRONE endpoint http-method(POST)
2. GET AVAILABLE DRONE endpoint http-method(GET)
3. LOAD DRONE WITH MEDICATION endpoint http-method(GET)
4. CHECK BATTERY PERCENT endpoint http-method(GET)  

Set the program to be running as a spring boot project and test each of the endpoints in the VIEW(controller)Layer using your favourite API testing tool e.g POSTMAN,INSOMNIA,SWAGGER UI.  
On the API test tool copy the URL for each of the end points and hit the api  (http:Localhost:8080/Drone/register)
