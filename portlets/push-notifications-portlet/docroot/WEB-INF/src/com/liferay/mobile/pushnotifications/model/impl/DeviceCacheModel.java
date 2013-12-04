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

package com.liferay.mobile.pushnotifications.model.impl;

import com.liferay.mobile.pushnotifications.model.Device;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Device in entity cache.
 *
 * @author Silvio Santos
 * @see Device
 * @generated
 */
public class DeviceCacheModel implements CacheModel<Device>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{deviceId=");
		sb.append(deviceId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", applicationName=");
		sb.append(applicationName);
		sb.append(", platform=");
		sb.append(platform);
		sb.append(", registerDate=");
		sb.append(registerDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Device toEntityModel() {
		DeviceImpl deviceImpl = new DeviceImpl();

		if (deviceId == null) {
			deviceImpl.setDeviceId(StringPool.BLANK);
		}
		else {
			deviceImpl.setDeviceId(deviceId);
		}

		deviceImpl.setUserId(userId);

		if (applicationName == null) {
			deviceImpl.setApplicationName(StringPool.BLANK);
		}
		else {
			deviceImpl.setApplicationName(applicationName);
		}

		if (platform == null) {
			deviceImpl.setPlatform(StringPool.BLANK);
		}
		else {
			deviceImpl.setPlatform(platform);
		}

		deviceImpl.setRegisterDate(registerDate);

		deviceImpl.resetOriginalValues();

		return deviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		deviceId = objectInput.readUTF();
		userId = objectInput.readLong();
		applicationName = objectInput.readUTF();
		platform = objectInput.readUTF();
		registerDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (deviceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceId);
		}

		objectOutput.writeLong(userId);

		if (applicationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationName);
		}

		if (platform == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(platform);
		}

		objectOutput.writeLong(registerDate);
	}

	public String deviceId;
	public long userId;
	public String applicationName;
	public String platform;
	public long registerDate;
}