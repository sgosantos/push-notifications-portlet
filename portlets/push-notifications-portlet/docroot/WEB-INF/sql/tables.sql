create table PushNotifications_Device (
	deviceId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	token VARCHAR(75) null
);