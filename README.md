# Current Time RestService

This Service shows up current time and you can setup dealyed service response with loop and sleep time

HOw to run

1. Copy RestService\executableJar\currenttime-1.0.0.jar to your desired folder

2. From you desirefolder run command - 
	java -jar currenttime-1.0.0.jar 

3. This will start service at http://localhost:8080 port

4. If you deploying to PCF or Keuberties it will be http://<serverhost>:8080 port

5. Test service by calling below url from browser

http://localhost:8080/time/greetings

Output - 
Hello Guest Greetings! Current Time is 2021/Oct/07 21:48:10


OR 

http://localhost:8080/time/greetings?name=Sachin

Output - 

Hello Sachin Greetings! Current Time is 2021/Oct/07 21:49:24



6. To Simulate dealyed respnse time, hit 

http://localhost:8080/time/currentTime

Output - 

Service looped 100 times & each loop iteration slept for 500 milliseconds

Current Time :2021/Oct/07 21:51:24

Service took almost 50476 ms time in total.

OR 

you can customozed loop and sleep count to have own dealyed response time

http://localhost:8080/time/currentTime?loopCount=10&sleepCount=100

Output - 

Service looped 10 times & each loop iteration slept for 100 milliseconds

Current Time :2021/Oct/07 21:53:06

Service took almost 1096 ms time in total.