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

package com.liferay.mobile.pushnotifications.service.impl;

import com.google.android.gcm.server.*;

import com.liferay.mobile.pushnotifications.model.Device;
import com.liferay.mobile.pushnotifications.model.impl.DeviceImpl;
import com.liferay.mobile.pushnotifications.service.base.DeviceServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Silvio Santos
 */
public class DeviceServiceImpl extends DeviceServiceBaseImpl {

	public List<Device> getDevices(long userId) throws SystemException {
		return devicePersistence.findByUser(userId);
	}

	public void registerDevice(
			String deviceId, String applicationName, String platform)
		throws PortalException, SystemException {

		Device device = new DeviceImpl();

		User user = getUser();

		device.setDeviceId(deviceId);
		device.setUserId(user.getUserId());
		device.setApplicationName(applicationName);
		device.setPlatform(platform);
		device.setRegisterDate(System.currentTimeMillis());

		deviceLocalService.addDevice(device);
	}

	public void sendMessage(long userId)
		throws IOException, PortalException, SystemException {

		sendMessage(userId, null, null, 2419200, false);
	}

	public void sendMessage(
			long userId, String collapseKey, String data, int timeToLive,
			boolean delayWhileIdle)
		throws IOException, PortalException, SystemException {

		List<Device> devices = devicePersistence.findByUser(userId);

		if (devices.isEmpty()) {
			throw new PortalException(
				"No device id found for userId " + userId);
		}

		List<String> deviceIds = getDeviceIds(devices);

		Message message = buildMessage(
			collapseKey, data, timeToLive, delayWhileIdle);

		Sender sender = new Sender(getApiKey());

		MulticastResult multicastResult = sender.send(message, deviceIds, 5);

		handleResponse(devices, multicastResult);
	}

	public void unregisterDevice(String deviceId)
		throws PortalException, SystemException {

		deviceLocalService.deleteDevice(deviceId);
	}

	protected Message buildMessage(
		String collapseKey, String data, int timeToLive,
		boolean delayWhileIdle) {

		Message.Builder builder = new Message.Builder();

		if (data != null) {
			builder.addData("data", data);
		}

		if (collapseKey != null) {
			builder.collapseKey(collapseKey);
		}

		if ((timeToLive >= 0) || (timeToLive <= MAX_TIME_TO_LIVE)) {
			builder.timeToLive(timeToLive);
		}

		builder.delayWhileIdle(delayWhileIdle);

		return builder.build();
	}

	protected String getApiKey() {
		return com.liferay.util.portlet.PortletProps.get(API_KEY);
	}

	protected List<String> getDeviceIds(List<Device> devices) {
		List<String> deviceIds = new ArrayList<String>();

		for (Device device : devices) {
			deviceIds.add(device.getDeviceId());
		}

		return deviceIds;
	}

	protected void handleError(Device device, String error)
		throws SystemException {

		if (error.equals(Constants.ERROR_NOT_REGISTERED) ||
			error.equals(Constants.ERROR_INVALID_REGISTRATION)) {

			deviceLocalService.deleteDevice(device);
		}
	}

	protected void handleResponse(
		List<Device> devices, MulticastResult multicastResult) {

		if ((multicastResult.getCanonicalIds() == 0) &&
			(multicastResult.getFailure() == 0)) {

			return;
		}

		List<Result> results = multicastResult.getResults();

		int size = results.size();

		for (int i = 0; i < size; i++) {
			Result result = results.get(i);

			String messageId = result.getMessageId();
			String canonicalId = result.getCanonicalRegistrationId();

			Device device = devices.get(i);

			try {
				if (Validator.isNotNull(messageId) &&
					Validator.isNotNull(canonicalId)) {

					deviceLocalService.deleteDevice(device);

					device.setDeviceId(canonicalId);

					deviceLocalService.addDevice(device);

					continue;
				}

				String error = result.getErrorCodeName();

				if (Validator.isNotNull(error)) {
					handleError(device, error);
				}
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	protected final String API_KEY = "gcm.api.key";

	protected final int MAX_TIME_TO_LIVE = 2419200;

}