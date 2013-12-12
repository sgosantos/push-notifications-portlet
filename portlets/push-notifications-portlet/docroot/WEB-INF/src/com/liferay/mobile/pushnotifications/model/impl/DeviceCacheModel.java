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

import java.util.Date;

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
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", platform=");
		sb.append(platform);
		sb.append(", token=");
		sb.append(token);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Device toEntityModel() {
		DeviceImpl deviceImpl = new DeviceImpl();

		deviceImpl.setDeviceId(deviceId);
		deviceImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			deviceImpl.setCreateDate(null);
		}
		else {
			deviceImpl.setCreateDate(new Date(createDate));
		}

		if (platform == null) {
			deviceImpl.setPlatform(StringPool.BLANK);
		}
		else {
			deviceImpl.setPlatform(platform);
		}

		if (token == null) {
			deviceImpl.setToken(StringPool.BLANK);
		}
		else {
			deviceImpl.setToken(token);
		}

		deviceImpl.resetOriginalValues();

		return deviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		deviceId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		platform = objectInput.readUTF();
		token = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(deviceId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (platform == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(platform);
		}

		if (token == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(token);
		}
	}

	public long deviceId;
	public long userId;
	public long createDate;
	public String platform;
	public String token;
}