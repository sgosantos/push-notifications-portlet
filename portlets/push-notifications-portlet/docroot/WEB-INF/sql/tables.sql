create table PushNotifications_Device (
	deviceId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	platform VARCHAR(75) null,
	token VARCHAR(250) null
);