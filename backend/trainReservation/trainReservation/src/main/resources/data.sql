insert into Admin(id,userName,email,password) values
(10001,'Parthi','parthi22@gmail.com','P@arthi22'),
(10002,'Rahul','rahul34@gmail.com','Rahul@34'),
(10003,'Tom','tommark567@gmail.com','Tom567@');

insert into train_details(train_id,trainName,trainClass,capacity,coachNo,timing) values
(50001,'Vaigai Express','3 AC,CC,14 2S,5UR/GS,2 SLR',300,1,CURRENT_TIMESTAMP),
(50002,'Pandian Express','AC First Class(1A), AC 2Tier (2A), AC 2Tier (3A) ,Sleeper Class(SL)',400,2,CURRENT_TIMESTAMP);

insert into payment_details(payment_id,payment_type) values
(30001,'Card'),
(30002,'UPI'),
(30003,'Cash');

insert into passenger_details(id,pnr,payment_details_payment_id,train_details_train_id,email,userName,password,address,age,gender) values
(1,'T529872',30001,50001,'parthi22@gmail.com','Parthi22','P@arthi22','trichy',24,'Male'),
(2,'T543261',30002,50002,'tommark567@gmail.com','Tom567','Tom567@','Madurai',25,'Male'),
(3,'T541234',30003,50002,'rahul34@gmail.com','Rahul34','Rahul@34','Dindigul',45,'Male');

insert into food_details(food_id,passenger_details_id,food_type,food_name,quantity) values
(20001,1,'Veg','Dosa',2),
(20002,1,'Non-Veg','Biriyani',1),
(20003,2,'Veg','Curd Rise',3);

insert into route_details(route_id,train_details_train_id,route) values
(40001,50001,'Chennai To Trichy'),
(40002,50002,'Madurai To Coimbator'),
(40003,50001,'Trichy To Dindigul');

