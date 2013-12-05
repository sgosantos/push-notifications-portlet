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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Device}.
 * </p>
 *
 * @author Silvio Santos
 * @see Device
 * @generated
 */
public class DeviceWrapper implements Device, ModelWrapper<Device> {
	public DeviceWrapper(Device device) {
		_device = device;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deviceId", getDeviceId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("token", getToken());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long deviceId = (Long)attributes.get("deviceId");

		if (deviceId != null) {
			setDeviceId(deviceId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}
	}

	/**
	* Returns the primary key of this device.
	*
	* @return the primary key of this device
	*/
	@Override
	public long getPrimaryKey() {
		return _device.getPrimaryKey();
	}

	/**
	* Sets the primary key of this device.
	*
	* @param primaryKey the primary key of this device
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_device.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the device ID of this device.
	*
	* @return the device ID of this device
	*/
	@Override
	public long getDeviceId() {
		return _device.getDeviceId();
	}

	/**
	* Sets the device ID of this device.
	*
	* @param deviceId the device ID of this device
	*/
	@Override
	public void setDeviceId(long deviceId) {
		_device.setDeviceId(deviceId);
	}

	/**
	* Returns the user ID of this device.
	*
	* @return the user ID of this device
	*/
	@Override
	public long getUserId() {
		return _device.getUserId();
	}

	/**
	* Sets the user ID of this device.
	*
	* @param userId the user ID of this device
	*/
	@Override
	public void setUserId(long userId) {
		_device.setUserId(userId);
	}

	/**
	* Returns the user uuid of this device.
	*
	* @return the user uuid of this device
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _device.getUserUuid();
	}

	/**
	* Sets the user uuid of this device.
	*
	* @param userUuid the user uuid of this device
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_device.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this device.
	*
	* @return the create date of this device
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _device.getCreateDate();
	}

	/**
	* Sets the create date of this device.
	*
	* @param createDate the create date of this device
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_device.setCreateDate(createDate);
	}

	/**
	* Returns the token of this device.
	*
	* @return the token of this device
	*/
	@Override
	public java.lang.String getToken() {
		return _device.getToken();
	}

	/**
	* Sets the token of this device.
	*
	* @param token the token of this device
	*/
	@Override
	public void setToken(java.lang.String token) {
		_device.setToken(token);
	}

	@Override
	public boolean isNew() {
		return _device.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_device.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _device.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_device.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _device.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _device.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_device.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _device.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_device.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_device.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_device.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DeviceWrapper((Device)_device.clone());
	}

	@Override
	public int compareTo(
		com.liferay.mobile.pushnotifications.model.Device device) {
		return _device.compareTo(device);
	}

	@Override
	public int hashCode() {
		return _device.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.mobile.pushnotifications.model.Device> toCacheModel() {
		return _device.toCacheModel();
	}

	@Override
	public com.liferay.mobile.pushnotifications.model.Device toEscapedModel() {
		return new DeviceWrapper(_device.toEscapedModel());
	}

	@Override
	public com.liferay.mobile.pushnotifications.model.Device toUnescapedModel() {
		return new DeviceWrapper(_device.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _device.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _device.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_device.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeviceWrapper)) {
			return false;
		}

		DeviceWrapper deviceWrapper = (DeviceWrapper)obj;

		if (Validator.equals(_device, deviceWrapper._device)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Device getWrappedDevice() {
		return _device;
	}

	@Override
	public Device getWrappedModel() {
		return _device;
	}

	@Override
	public void resetOriginalValues() {
		_device.resetOriginalValues();
	}

	private Device _device;
}