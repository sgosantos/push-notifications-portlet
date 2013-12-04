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

import com.liferay.mobile.pushnotifications.model.Device;
import com.liferay.mobile.pushnotifications.model.impl.DeviceImpl;
import com.liferay.mobile.pushnotifications.service.base.DeviceServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * @author Silvio Santos
 */
public class DeviceServiceImpl extends DeviceServiceBaseImpl {

	@Override
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

	@Override
	public void unregisterDevice(String deviceId)
		throws PortalException, SystemException {

		deviceLocalService.deleteDevice(deviceId);
	}

}