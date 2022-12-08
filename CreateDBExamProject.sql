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
VALUES ('Låneadmin')
INSERT INTO Team ([Name])
VALUES ('LCAdmin')
INSERT INTO Team ([Name])
VALUES ('Hire Purchase')

INSERT INTO TaskCategory (CategoryType)
VALUES ('Privatlån')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Bolån')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Billån')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Stora Företagslån')
INSERT INTO TaskCategory (CategoryType)
VALUES ('Företagslån')

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
VALUES ('p201ejh', 'snäll', '2022-11-28', 'p201ejhl@swedbank.se', '070-7654321', 1)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId, ReportsTo)
VALUES ('p901hpc', 'kokkaffe', '2022-11-28', 'p901hpc@swedbank.se', '070-3333333', 2, 1)
INSERT INTO [User] (Username, [Password], CreatedDate, Email, PhoneNumber, TeamId, ReportsTo)
VALUES ('p901fxe', 'bandhåll', '2022-11-28', 'p901fxe@swedbank.se', '070-1234567', 1, 2)
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


insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-15', '2022-12-05', null, null, 'Bostadsköp', 'Sara ska köpa en lägenhet och undrar om hon kan få ett brygglån.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-01-13', '2022-02-07', null, null, 'Flytta billån', 'Kund ska sälja sin bil och vill flytta billånet till köparen.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-05-21', '2022-11-21', null, null, 'Köp av bostad', 'Köp av bostad utomlands. Vad krävs för att kunna köpa lägenhet i Spanien', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-06', '2022-11-12', null, null, 'IVEA', 'Hjälpa kunden att se över sina lån för verksamheten i Sverige.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-02-02', '2022-10-08', null, null, 'Företagslån till Silverfynd', 'Kunden behöver utöka sina lån för att klara av re-branding', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-06-20', '2022-12-22', null, null, 'Lånelöft bostad', 'Kunden ska köpa lägenhet i Stockholm och behöver utöka sitt lånelöfte. Behöver se över kunden KALK', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-01-31', '2022-07-30', null, null, 'Lånelöfte', 'Kund ska köpa stuga i Norrland och finansiera detta med försäljning av sin bostad i Stockholm. Men köpet av stugan ska hanteras först.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-02', '2023-01-12', '2022-05-12', null, 'Bostadsköp till barn', 'Kundens barn ska flytta till Lund och studera. Föräldrarna ska hjälpa till att finansiera lägnehetsköpet.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-07-03', '2023-01-18', '2022-07-07', '2022-10-03', 'Brights ska utvekla sin verksamhet', 'Kunden ska starta verksamhet i Finland och behöver hjälp med att kontakta banken där', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-06-05', '2022-09-30', null, '2022-06-29', 'Utlandsresa', 'Kund vill se över möjligheterna att finasiera familjens utlandsresa. Kunden vill ha återkoppling innan månaden är slut.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-03-14', '2022-11-07', null, null, 'Bostad', 'Kunden har två lån som han vill slå ihop till ett och sätta en gemensam ränta på', 3, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-26', '2022-12-02', null, '2022-08-31', 'Bilån', 'Kunden har finansierat sin bil med hjälp av lån. Nu har bile gått sönder och han vill ha hjälp med att se över lånet.', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-11-02', '2023-05-26', '2023-08-08', '2023-09-08', 'SWECO ', 'SWECO ska implementera en ny huvudbok och vill ha hjälp med alternativ till lån för att finansiera detta.', 3, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-05-30', '2022-09-22', null, '2022-10-02', 'Privatlån', 'Kunden har tagit ett privåt lån för två år sedan och har nu svårtigheter att betala tillbaka. Behöver hjälp med att se över sina alternativ.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-07-09', '2022-11-03', null, '2022-11-22', 'Bostad', 'Kunden har haft en vattenskada och vill utöka sitt bostadslån för att finansiera detta.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-04-01', '2023-01-06', '2023-02-06', null, 'Privatlån', 'Kunden har satts i personlig konkurs och behöver hjälp med att se över sin belåning och möjligheten att slå ihop sina lån', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-02-12', '2022-12-06', null, null, 'Starta företag', 'Kunden ska starta upp en enskild firma och vill ha hjälp att starta upp ett konto och ta ett företagslån till uppstarten.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-06-18', '2023-04-30', null, null, 'Kundportalen', 'Kunder vll kunna se sina saldon snabbt när de kommer in på internetbanken', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-09-19', '2023-05-30', '2022-10-19', null, 'LC&I', ' Skapa möjlighet att chatta med kundcenter direkt via Internetbanken. Finns redan för privatkunder men ska implementeras på LC&I också.', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-08-04', '2023-01-30', null, null, 'Apotek ska bytta logga', 'Apoteket ska byta logga och behöver se över finansieringen för detta.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-07', '2022-10-06', '2023-01-30', null, 'Kund ska köpa bil', 'Kunden har fått ett lånelöft för finansiering av bil, men eftersom det är 1 år gamalt behöver det uppdateras.', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-01-18', '2022-11-03', null, '2023-01-04', 'Bostad', 'Kunden ska bli sambo och ska skriva över hälften av bostaden och lånet på sin sambo', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-07-15', '2022-08-22', null, null, 'Samla sina krediter', 'Kunden har haft problem att betala av sina krediter och ska nu samla sina lån på ett och samma. Vi behöver kontakta alla andra kreditgivare och se över möjlighetn att skriva över lånen till oss.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-03-01', '2022-08-26', '2023-01-09', null, 'Företagssplitt', 'Ett litet företag i södra Sverige ska dela upp sin verskamhet och därmed även de lån som gemensamt står på ägarna.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-04-19', '2022-11-16', null, null, 'Bilolycka', 'Kunden har varit med om en bilolycka. Bilen som kördes är totalförstörd och den var finansierad med hjälpa att lån från oss. Kunde vill ha kontakt med någon som kan hjälpa till att kolla på hans möjligheter.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-09-27', '2022-11-01', null, '2023-05-16', 'Handpenning', 'Vi behöver skriva ihop en tsxt om vad som gäller när kunder ska ta privatlån för att finansiera sina bostadslån', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-06-03', '2022-12-17', null, null, 'Lastbil', 'Kunden har en gård där kunden vill köpa in traktor. Det ska bara användas i privat bruk.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-09-20', '2023-06-24', null, '2023-01-27', 'Kompisar vill köpa lägnehet tillsammans', 'Kunden vill köpa en lägenhet tillsammans med sin kompis. Kunden vill ha info om vad som krävs för att det ska gp igneom', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-11-14', '2023-07-31', null, null, 'Privatlån till nyproduktion', 'Kunden ska köpa en nyproduktion och behöver ett lån för att finanseria bokningsavgiften', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-07-15', '2022-11-13', '2022-11-29', null, 'Företagslån', 'Det måste finnas tydligare info på sidan för företagslån om vart man vänder sig med frågor om utökat lån.', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-03-18', '2022-11-10', '2023-01-05', '2022-12-08', 'Lån till företag', 'Litet förtag i Nacka behöver utöka sitt lån för att sarta upp en filial i Umeå', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-09-07', '2022-12-14', null, null, 'Företagslån', 'Företaget vill ha en genomgång av internetbanken', 3, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-20', '2022-05-17', null, '2022-04-27', 'Lån till företag ', 'Företag ska utveckla sin verksamhet och behöver utökade företagslån.', 3, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-11-02', '2023-03-23', null, null, 'Bostadslån', 'Kunden ska hjälpa sin mamma som är pensionär och löpe henne en bostad i Gävle', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-08-21', '2023-03-15', null, '2023-08-13', 'Amortering av bostadslån', 'Kunden vill mionska sin amortering till 1 %', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-09-25', '2022-12-04', null, '2023-06-16', 'Amortering', 'Kunden vill amortera av sitt lån på 10 år. Hur går de tillväga?', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-06-05', '2022-11-10', null, '2023-03-12', 'Billån', 'Kunden vill förlänga löptiden på sitt lån och betala av det på 15 år istället.', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-04-08', '2023-02-18', '2022-12-09', null, 'Stora företagslån', 'Kunden vill korrigera vilka som står som firamtecknare .', 4, 1);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (1, '2022-07-16', '2022-08-26', null, null, 'Lån till handpenning', 'Kunden vill både ta ett bostadslån (det ligger upplagt separat) men även ett privat lån för att täcka delar av handpenningen', 4, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (3, '2022-08-08', '2023-01-19', null, '2023-01-27', 'Lån för bil', 'Billån behöver utökas för att täcka kostnaden av en dyrare bil än beräknat.', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (5, '2022-04-12', '2022-10-25', null, '2023-03-08', 'Lån till företag', 'Företag i västra Sverige behöver utöka sitt lån för att täcka kostander som uppkommit i och med vattenskada', 4, 3);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-04-24', '2022-06-13', '2022-08-31', null, 'Stora företagslån', 'Kunden har sedan tidigare en stor del av sin låneportfölj hos oss, och nu vill de flytta över en del till annan bank.', 4, 2);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (2, '2022-06-07', '2022-08-17', '2023-02-28', null, 'Bostadsköp', 'Kunden ska köpa ett hus utanför Göteborg och behöver ett lånelöfte inför det.', 3, 4);
insert into Tasks (TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId) values (4, '2022-02-20', '2022-06-12', null, null, 'Köp av bostadsrätt', 'Kunden ska köpa en lägenhet inann de sålt sitt uvarande boende.', 3, 4);
