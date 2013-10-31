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

package com.liferay.mobile.pushnotifications.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.mobile.pushnotifications.service.http.DeviceServiceSoap}.
 *
 * @author Silvio Santos
 * @see com.liferay.mobile.pushnotifications.service.http.DeviceServiceSoap
 * @generated
 */
public class DeviceSoap implements Serializable {
	public static DeviceSoap toSoapModel(Device model) {
		DeviceSoap soapModel = new DeviceSoap();

		soapModel.setDeviceId(model.getDeviceId());
		soapModel.setUserId(model.getUserId());
		soapModel.setApplicationName(model.getApplicationName());
		soapModel.setPlatform(model.getPlatform());
		soapModel.setRegisterDate(model.getRegisterDate());

		return soapModel;
	}

	public static DeviceSoap[] toSoapModels(Device[] models) {
		DeviceSoap[] soapModels = new DeviceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeviceSoap[][] toSoapModels(Device[][] models) {
		DeviceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeviceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeviceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeviceSoap[] toSoapModels(List<Device> models) {
		List<DeviceSoap> soapModels = new ArrayList<DeviceSoap>(models.size());

		for (Device model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeviceSoap[soapModels.size()]);
	}

	public DeviceSoap() {
	}

	public String getPrimaryKey() {
		return _deviceId;
	}

	public void setPrimaryKey(String pk) {
		setDeviceId(pk);
	}

	public String getDeviceId() {
		return _deviceId;
	}

	public void setDeviceId(String deviceId) {
		_deviceId = deviceId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getApplicationName() {
		return _applicationName;
	}

	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;
	}

	public String getPlatform() {
		return _platform;
	}

	public void setPlatform(String platform) {
		_platform = platform;
	}

	public long getRegisterDate() {
		return _registerDate;
	}

	public void setRegisterDate(long registerDate) {
		_registerDate = registerDate;
	}

	private String _deviceId;
	private long _userId;
	private String _applicationName;
	private String _platform;
	private long _registerDate;
}