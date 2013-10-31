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

import com.liferay.mobile.pushnotifications.service.ClpSerializer;
import com.liferay.mobile.pushnotifications.service.DeviceLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Silvio Santos
 */
public class DeviceClp extends BaseModelImpl<Device> implements Device {
	public DeviceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Device.class;
	}

	@Override
	public String getModelClassName() {
		return Device.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _deviceId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setDeviceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deviceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deviceId", getDeviceId());
		attributes.put("userId", getUserId());
		attributes.put("applicationName", getApplicationName());
		attributes.put("platform", getPlatform());
		attributes.put("registerDate", getRegisterDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String deviceId = (String)attributes.get("deviceId");

		if (deviceId != null) {
			setDeviceId(deviceId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String applicationName = (String)attributes.get("applicationName");

		if (applicationName != null) {
			setApplicationName(applicationName);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		Long registerDate = (Long)attributes.get("registerDate");

		if (registerDate != null) {
			setRegisterDate(registerDate);
		}
	}

	@Override
	public String getDeviceId() {
		return _deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		_deviceId = deviceId;

		if (_deviceRemoteModel != null) {
			try {
				Class<?> clazz = _deviceRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceId", String.class);

				method.invoke(_deviceRemoteModel, deviceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_deviceRemoteModel != null) {
			try {
				Class<?> clazz = _deviceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_deviceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getApplicationName() {
		return _applicationName;
	}

	@Override
	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;

		if (_deviceRemoteModel != null) {
			try {
				Class<?> clazz = _deviceRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationName",
						String.class);

				method.invoke(_deviceRemoteModel, applicationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlatform() {
		return _platform;
	}

	@Override
	public void setPlatform(String platform) {
		_platform = platform;

		if (_deviceRemoteModel != null) {
			try {
				Class<?> clazz = _deviceRemoteModel.getClass();

				Method method = clazz.getMethod("setPlatform", String.class);

				method.invoke(_deviceRemoteModel, platform);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegisterDate() {
		return _registerDate;
	}

	@Override
	public void setRegisterDate(long registerDate) {
		_registerDate = registerDate;

		if (_deviceRemoteModel != null) {
			try {
				Class<?> clazz = _deviceRemoteModel.getClass();

				Method method = clazz.getMethod("setRegisterDate", long.class);

				method.invoke(_deviceRemoteModel, registerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeviceRemoteModel() {
		return _deviceRemoteModel;
	}

	public void setDeviceRemoteModel(BaseModel<?> deviceRemoteModel) {
		_deviceRemoteModel = deviceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _deviceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_deviceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeviceLocalServiceUtil.addDevice(this);
		}
		else {
			DeviceLocalServiceUtil.updateDevice(this);
		}
	}

	@Override
	public Device toEscapedModel() {
		return (Device)ProxyUtil.newProxyInstance(Device.class.getClassLoader(),
			new Class[] { Device.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeviceClp clone = new DeviceClp();

		clone.setDeviceId(getDeviceId());
		clone.setUserId(getUserId());
		clone.setApplicationName(getApplicationName());
		clone.setPlatform(getPlatform());
		clone.setRegisterDate(getRegisterDate());

		return clone;
	}

	@Override
	public int compareTo(Device device) {
		String primaryKey = device.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeviceClp)) {
			return false;
		}

		DeviceClp device = (DeviceClp)obj;

		String primaryKey = device.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{deviceId=");
		sb.append(getDeviceId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", applicationName=");
		sb.append(getApplicationName());
		sb.append(", platform=");
		sb.append(getPlatform());
		sb.append(", registerDate=");
		sb.append(getRegisterDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.mobile.pushnotifications.model.Device");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deviceId</column-name><column-value><![CDATA[");
		sb.append(getDeviceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationName</column-name><column-value><![CDATA[");
		sb.append(getApplicationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>platform</column-name><column-value><![CDATA[");
		sb.append(getPlatform());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registerDate</column-name><column-value><![CDATA[");
		sb.append(getRegisterDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _deviceId;
	private long _userId;
	private String _userUuid;
	private String _applicationName;
	private String _platform;
	private long _registerDate;
	private BaseModel<?> _deviceRemoteModel;
}