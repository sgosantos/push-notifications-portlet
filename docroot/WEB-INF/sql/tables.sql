create table PushNotifications_Device (
	deviceId VARCHAR(200) not null primary key,
	userId LONG,
	applicationName VARCHAR(75) null,
	platform VARCHAR(75) null,
	registerDate LONG
);