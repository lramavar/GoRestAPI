# GoRestAPI
A java application to connect to gorest api and perform action on users.

IDE : IntelliJ 

Framework : Maven project 

HTTP Client used : Retrofit 

Auth Type: OAuth Bearer token

Unit Testing : JUnit 5

Mocking Framework : Mockito 

Used Postman to test GoRest API Calls and understand request and responses


## Sample Output : 

1 : Page 3 list of users

ID : 5923
 Name : Mrs. Suryakantam Iyengar
 Email : iyengar_mrs_suryakantam@harris-harber.biz
 Gender : male
 Status : active
ID : 5922
 Name : Enakshi Namboothiri VM
 Email : vm_enakshi_namboothiri@grant.name
 Gender : male
 Status : active
ID : 5919
 Name : Anang Mehra
 Email : anang_mehra@rippin.co
 Gender : male
 Status : active
ID : 5918
 Name : Sarada Asan
 Email : sarada_asan@streich.info
 Gender : female
 Status : inactive
ID : 5915
 Name : Dhanvin Patil
 Email : dhanvin_patil@legros-damore.co
 Gender : female
 Status : inactive
ID : 5914
 Name : Aanand Shukla
 Email : aanand_shukla@toy.co
 Gender : female
 Status : active
ID : 5912
 Name : Gopaal Guneta DC
 Email : dc_guneta_gopaal@mosciski-vandervort.com
 Gender : female
 Status : active
ID : 5911
 Name : Darshan Rana
 Email : darshan_rana@hoeger.biz
 Gender : male
 Status : active
ID : 5910
 Name : Avantika Ahluwalia
 Email : avantika_ahluwalia@keebler.org
 Gender : male
 Status : active
ID : 5909
 Name : Chandra Verma
 Email : chandra_verma@beahan-collins.name
 Gender : female
 Status : active
 
Nov 29, 2022 3:17:55 PM gorest.usermanagement.Application getUserDetails
INFO: 2 : Total Pages in response : 575

Nov 29, 2022 3:17:55 PM gorest.usermanagement.Application main
INFO: 4. Last user after sorting :Sarada Asan

ID : 5918
 Name : Test User
 Email : sarada_asan@streich.info
 Gender : female
 Status : inactive
Nov 29, 2022 3:17:56 PM gorest.usermanagement.Application updateUser
INFO: 5 New updated user : Test User

Nov 29, 2022 3:17:56 PM gorest.usermanagement.Application deleteUser
INFO: 6 User with user id : 5918 was deleted.

Nov 29, 2022 3:17:57 PM gorest.usermanagement.Application getUserById
INFO: User Not Found ! 
 Request failed with response code : 404
 
 ## References : 
 1) https://rapidapi.com/blog/how-to-use-an-api-with-java/
 2) https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 3) https://square.github.io/retrofit/
 4) https://www.javacodemonk.com/retrofit-oauth2-bearer-token-authentication-okhttp-android-3b702350
 5) https://www.vogella.com/tutorials/JUnit/article.html
 6) https://mincong.io/2020/04/19/mockito-junit5/
 7) https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/
