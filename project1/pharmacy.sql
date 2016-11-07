Create table Pharmacy
(
Name varchar(30) not null, 
Address varchar(100) not null,
Phone_no varchar(15),
Primary key(name, address)
 );

insert into Pharmacy values('CVS', 'Fremont Blvd Monterey CA 93940', '831-123-1234');
insert into Pharmacy values('Walgreens', 'E.Williams St Salinas CA 93905', '831-234-2345'); 
insert into Pharmacy values('Rite Aid', 'Reservation Rd Marina CA 93933', '831-345-3456');
insert into Pharmacy values('Walmart', 'La Playa Ave Sand City CA 93955', '831-523-8759');
