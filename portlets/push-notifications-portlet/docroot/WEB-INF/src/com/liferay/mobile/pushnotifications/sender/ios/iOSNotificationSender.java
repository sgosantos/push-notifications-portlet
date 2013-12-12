/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.mobile.pushnotifications.sender.ios;

import com.liferay.mobile.pushnotifications.model.Device;
import com.liferay.mobile.pushnotifications.sender.BaseNotificationSender;
import com.liferay.mobile.pushnotifications.service.DeviceLocalServiceUtil;
import com.liferay.mobile.pushnotifications.util.PortletPropsValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;
import com.notnoop.apns.PayloadBuilder;

import java.io.IOException;

import java.util.List;

/**
 * @author Silvio Santos
 */
public class iOSNotificationSender extends BaseNotificationSender {

	public static void send(
			long userId, String data, String alert, int badge, String sound)
		throws IOException, PortalException, SystemException {

		List<Device> devices = DeviceLocalServiceUtil.getUserDevices(
			userId, PLATFORM);

		if (devices.isEmpty()) {
			return;
		}

		List<String> tokens = getTokens(devices);

		String message = buildMessage(data, alert, badge, sound);

		getService().push(tokens, message);
	}

	protected static String buildMessage(
		String alert, String data, int badge, String sound) {

		PayloadBuilder payload = PayloadBuilder.newPayload();

		if (alert != null) {
			payload.alertBody(alert);
		}

		if (data != null) {
			payload.customField("data", data);
		}

		payload.badge(badge);

		if (sound != null) {
			payload.sound(sound);
		}

		return payload.build();
	}

	protected static final String PLATFORM = "ios";

	private static ApnsService getService() {
		if (_apns == null) {
			String path = PortletPropsValues.IOS_CERT_PATH;
			String password = PortletPropsValues.IOS_CERT_PASSWORD;
			boolean sandbox = Boolean.valueOf(PortletPropsValues.IOS_SANDBOX);

			ApnsServiceBuilder builder = com.notnoop.apns.APNS.newService();

			builder.withCert(path, password);

			if (sandbox) {
				builder.withSandboxDestination();
			}

			_apns = builder.build();
		}

		return _apns;
	}

	private static ApnsService _apns;

}