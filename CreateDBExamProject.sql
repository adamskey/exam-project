DROP DATABASE examproject


CREATE DATABASE examproject;

USE examproject;

CREATE TABLE Roles (
ID int IDENTITY(1, 1) PRIMARY KEY,
[Name] varchar(255)
)

CREATE TABLE Team (
ID int IDENTITY(1, 1) PRIMARY KEY,
[Name] varchar(255)
)

CREATE TABLE [User] (
ID int IDENTITY(1, 1) PRIMARY KEY,
Username varchar(255),
[Password] varchar(255),
CreatedDate date,
Email varchar(255),
PhoneNumber varchar(255),
ReportsTo int FOREIGN KEY REFERENCES [User](ID),
TeamId int FOREIGN KEY REFERENCES Team(ID)
)

CREATE TABLE UserRoles(
UserID int FOREIGN KEY REFERENCES [User](ID),
RoleID int FOREIGN KEY REFERENCES Roles(ID)
)

CREATE TABLE TaskCategory(
ID int IDENTITY(1, 1) PRIMARY KEY,
CategoryType varchar(255)
)

CREATE TABLE [Priority] (
ID int IDENTITY(1, 1) PRIMARY KEY,
PriorityName varchar(50)
)

CREATE TABLE Tasks (
ID int IDENTITY(1, 1) PRIMARY KEY,
TaskCategoryId int FOREIGN KEY REFERENCES TaskCategory(ID),
CreatedTimestamp datetime,
Due datetime,
Edited datetime,
Completed datetime,
Title varchar(255),
[Description] varchar(2500),
AssignedTo int FOREIGN KEY REFERENCES [User](ID),
[PriorityId] int FOREIGN KEY REFERENCES [Priority](ID)
)

CREATE TABLE TaskCategoryTeam (
TaskCategoryId int FOREIGN KEY REFERENCES TaskCategory(ID),
TeamId int FOREIGN KEY REFERENCES Team(ID)
)


INSERT INTO Roles ([Name])
VALUES ('ROLE_USER')
INSERT INTO Roles ([Name])
VALUES ('ROLE_MODERATOR')
INSERT INTO Roles ([Name])
VALUES ('ROLE_ADMIN')

INSERT INTO Team ([Name])
VALUES ('L�neadmin')
INSERT INTO Team ([Name])
VALUES ('LCAdmin')
INSERT INTO Team ([Name])
VALUES ('Hire Purchase')

INSERT INTO TaskCategory (CategoryType)
VALUES ('Privatl�n')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Bol�n')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Bill�n')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Stora F�retagsl�n')
INSERT INTO TaskCategory (CategoryType)
VALUES ('F�retagsl�n')

INSERT INTO [Priority] (PriorityName)
VALUES ('Critical')
INSERT INTO [Priority] (PriorityName)
VALUES ('High')
INSERT INTO [Priority] (PriorityName)
VALUES ('Medium')
INSERT INTO [Priority] (PriorityName)
VALUES ('Low')

INSERT INTO TaskCategoryTeam (TaskCategoryId, TeamId)
VALUES (1, 1)
INSERT INTO TaskCategoryTeam (TaskCategoryId, TeamId)
VALUES (2, 1)
INSERT INTO TaskCategoryTeam (TaskCategoryId, TeamId)
VALUES (5, 1)
INSERT INTO TaskCategoryTeam (TaskCategoryId, TeamId)
VALUES (3, 3)
INSERT INTO TaskCategoryTeam (TaskCategoryId, TeamId)
VALUES (4, 2)

INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId)
VALUES ('p901mjl', 'kajsborv', '2022-11-28', 'p901mjl@swedbank.se', '070-6666666', 2)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId)
VALUES ('p201ejh', 'sn�ll', '2022-11-28', 'p201ejhl@swedbank.se', '070-7654321', 1)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId, ReportsTo)
VALUES ('p901hpc', 'kokkaffe', '2022-11-28', 'p901hpc@swedbank.se', '070-3333333', 2, 1)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId, ReportsTo)
VALUES ('p901fxe', 'bandh�ll', '2022-11-28', 'p901fxe@swedbank.se', '070-1234567', 1, 2)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber)
VALUES ('p901ale', 'gejmboj', '2022-11-28', 'p901ale@swedbank.se', '070-1337707')

INSERT INTO UserRoles (UserID, RoleId)
VALUES (1, 1)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (1, 2)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (2, 1)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (2, 2)
INSERT INTO UserRoles (UserID, RoleId)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (4, 1)
VALUES (3, 1)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (5, 1)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (5, 2)
INSERT INTO UserRoles (UserID, RoleId)
VALUES (5, 3)


insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-15', '2022-12-05', null, null, 'Bostadsk�p', 'Sara ska k�pa en l�genhet och undrar om hon kan f� ett bryggl�n.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-01-13', '2022-02-07', null, null, 'Flytta bill�n', 'Kund ska s�lja sin bil och vill flytta bill�net till k�paren.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-05-21', '2022-11-21', null, null, 'K�p av bostad', 'K�p av bostad utomlands. Vad kr�vs f�r att kunna k�pa l�genhet i Spanien', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-06', '2022-11-12', null, null, 'IVEA', 'Hj�lpa kunden att se �ver sina l�n f�r verksamheten i Sverige.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-02-02', '2022-10-08', null, null, 'F�retagsl�n till Silverfynd', 'Kunden beh�ver ut�ka sina l�n f�r att klara av re-branding', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-06-20', '2022-12-22', null, null, 'L�nel�ft bostad', 'Kunden ska k�pa l�genhet i Stockholm och beh�ver ut�ka sitt l�nel�fte. Beh�ver se �ver kunden KALK', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-01-31', '2022-07-30', null, null, 'L�nel�fte', 'Kund ska k�pa stuga i Norrland och finansiera detta med f�rs�ljning av sin bostad i Stockholm. Men k�pet av stugan ska hanteras f�rst.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-02', '2023-01-12', '2022-05-12', null, 'Bostadsk�p till barn', 'Kundens barn ska flytta till Lund och studera. F�r�ldrarna ska hj�lpa till att finansiera l�gnehetsk�pet.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-07-03', '2023-01-18', '2022-07-07', '2022-10-03', 'Brights ska utvekla sin verksamhet', 'Kunden ska starta verksamhet i Finland och beh�ver hj�lp med att kontakta banken d�r', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-06-05', '2022-09-30', null, '2022-06-29', 'Utlandsresa', 'Kund vill se �ver m�jligheterna att finasiera familjens utlandsresa. Kunden vill ha �terkoppling innan m�naden �r slut.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-14', '2022-11-07', null, null, 'Bostad', 'Kunden har tv� l�n som han vill sl� ihop till ett och s�tta en gemensam r�nta p�', 3, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-26', '2022-12-02', null, '2022-08-31', 'Bil�n', 'Kunden har finansierat sin bil med hj�lp av l�n. Nu har bile g�tt s�nder och han vill ha hj�lp med att se �ver l�net.', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-11-02', '2023-05-26', '2023-08-08', '2023-09-08', 'SWECO ', 'SWECO ska implementera en ny huvudbok och vill ha hj�lp med alternativ till l�n f�r att finansiera detta.', 3, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-05-30', '2022-09-22', null, '2022-10-02', 'Privatl�n', 'Kunden har tagit ett priv�t l�n f�r tv� �r sedan och har nu sv�rtigheter att betala tillbaka. Beh�ver hj�lp med att se �ver sina alternativ.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-07-09', '2022-11-03', null, '2022-11-22', 'Bostad', 'Kunden har haft en vattenskada och vill ut�ka sitt bostadsl�n f�r att finansiera detta.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-04-01', '2023-01-06', '2023-02-06', null, 'Privatl�n', 'Kunden har satts i personlig konkurs och beh�ver hj�lp med att se �ver sin bel�ning och m�jligheten att sl� ihop sina l�n', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-02-12', '2022-12-06', null, null, 'Starta f�retag', 'Kunden ska starta upp en enskild firma och vill ha hj�lp att starta upp ett konto och ta ett f�retagsl�n till uppstarten.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-06-18', '2023-04-30', null, null, 'Kundportalen', 'Kunder vll kunna se sina saldon snabbt n�r de kommer in p� internetbanken', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-09-19', '2023-05-30', '2022-10-19', null, 'LC&I', ' Skapa m�jlighet att chatta med kundcenter direkt via Internetbanken. Finns redan f�r privatkunder men ska implementeras p� LC&I ocks�.', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-08-04', '2023-01-30', null, null, 'Apotek ska bytta logga', 'Apoteket ska byta logga och beh�ver se �ver finansieringen f�r detta.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-07', '2022-10-06', '2023-01-30', null, 'Kund ska k�pa bil', 'Kunden har f�tt ett l�nel�ft f�r finansiering av bil, men eftersom det �r 1 �r gamalt beh�ver det uppdateras.', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-01-18', '2022-11-03', null, '2023-01-04', 'Bostad', 'Kunden ska bli sambo och ska skriva �ver h�lften av bostaden och l�net p� sin sambo', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-07-15', '2022-08-22', null, null, 'Samla sina krediter', 'Kunden har haft problem att betala av sina krediter och ska nu samla sina l�n p� ett och samma. Vi beh�ver kontakta alla andra kreditgivare och se �ver m�jlighetn att skriva �ver l�nen till oss.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-03-01', '2022-08-26', '2023-01-09', null, 'F�retagssplitt', 'Ett litet f�retag i s�dra Sverige ska dela upp sin verskamhet och d�rmed �ven de l�n som gemensamt st�r p� �garna.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-04-19', '2022-11-16', null, null, 'Bilolycka', 'Kunden har varit med om en bilolycka. Bilen som k�rdes �r totalf�rst�rd och den var finansierad med hj�lpa att l�n fr�n oss. Kunde vill ha kontakt med n�gon som kan hj�lpa till att kolla p� hans m�jligheter.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-09-27', '2022-11-01', null, '2023-05-16', 'Handpenning', 'Vi beh�ver skriva ihop en tsxt om vad som g�ller n�r kunder ska ta privatl�n f�r att finansiera sina bostadsl�n', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-06-03', '2022-12-17', null, null, 'Lastbil', 'Kunden har en g�rd d�r kunden vill k�pa in traktor. Det ska bara anv�ndas i privat bruk.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-09-20', '2023-06-24', null, '2023-01-27', 'Kompisar vill k�pa l�gnehet tillsammans', 'Kunden vill k�pa en l�genhet tillsammans med sin kompis. Kunden vill ha info om vad som kr�vs f�r att det ska gp igneom', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-11-14', '2023-07-31', null, null, 'Privatl�n till nyproduktion', 'Kunden ska k�pa en nyproduktion och beh�ver ett l�n f�r att finanseria bokningsavgiften', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-07-15', '2022-11-13', '2022-11-29', null, 'F�retagsl�n', 'Det m�ste finnas tydligare info p� sidan f�r f�retagsl�n om vart man v�nder sig med fr�gor om ut�kat l�n.', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-03-18', '2022-11-10', '2023-01-05', '2022-12-08', 'L�n till f�retag', 'Litet f�rtag i Nacka beh�ver ut�ka sitt l�n f�r att sarta upp en filial i Ume�', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-09-07', '2022-12-14', null, null, 'F�retagsl�n', 'F�retaget vill ha en genomg�ng av internetbanken', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-20', '2022-05-17', null, '2022-04-27', 'L�n till f�retag ', 'F�retag ska utveckla sin verksamhet och beh�ver ut�kade f�retagsl�n.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-11-02', '2023-03-23', null, null, 'Bostadsl�n', 'Kunden ska hj�lpa sin mamma som �r pension�r och l�pe henne en bostad i G�vle', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-08-21', '2023-03-15', null, '2023-08-13', 'Amortering av bostadsl�n', 'Kunden vill mionska sin amortering till 1 %', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-09-25', '2022-12-04', null, '2023-06-16', 'Amortering', 'Kunden vill amortera av sitt l�n p� 10 �r. Hur g�r de tillv�ga?', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-06-05', '2022-11-10', null, '2023-03-12', 'Bill�n', 'Kunden vill f�rl�nga l�ptiden p� sitt l�n och betala av det p� 15 �r ist�llet.', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-04-08', '2023-02-18', '2022-12-09', null, 'Stora f�retagsl�n', 'Kunden vill korrigera vilka som st�r som firamtecknare .', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-07-16', '2022-08-26', null, null, 'L�n till handpenning', 'Kunden vill b�de ta ett bostadsl�n (det ligger upplagt separat) men �ven ett privat l�n f�r att t�cka delar av handpenningen', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-08', '2023-01-19', null, '2023-01-27', 'L�n f�r bil', 'Bill�n beh�ver ut�kas f�r att t�cka kostnaden av en dyrare bil �n ber�knat.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-04-12', '2022-10-25', null, '2023-03-08', 'L�n till f�retag', 'F�retag i v�stra Sverige beh�ver ut�ka sitt l�n f�r att t�cka kostander som uppkommit i och med vattenskada', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-04-24', '2022-06-13', '2022-08-31', null, 'Stora f�retagsl�n', 'Kunden har sedan tidigare en stor del av sin l�neportf�lj hos oss, och nu vill de flytta �ver en del till annan bank.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-06-07', '2022-08-17', '2023-02-28', null, 'Bostadsk�p', 'Kunden ska k�pa ett hus utanf�r G�teborg och beh�ver ett l�nel�fte inf�r det.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-20', '2022-06-12', null, null, 'K�p av bostadsr�tt', 'Kunden ska k�pa en l�genhet inann de s�lt sitt uvarande boende.', 3, 4);
