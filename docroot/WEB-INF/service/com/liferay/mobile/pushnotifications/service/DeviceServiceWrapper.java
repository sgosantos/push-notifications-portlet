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

package com.liferay.mobile.pushnotifications.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DeviceService}.
 *
 * @author Silvio Santos
 * @see DeviceService
 * @generated
 */
public class DeviceServiceWrapper implements DeviceService,
	ServiceWrapper<DeviceService> {
	public DeviceServiceWrapper(DeviceService deviceService) {
		_deviceService = deviceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _deviceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_deviceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _deviceService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void registerDevice(java.lang.String deviceId,
		java.lang.String applicationName, java.lang.String platform)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_deviceService.registerDevice(deviceId, applicationName, platform);
	}

	@Override
	public void unregisterDevice(java.lang.String deviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_deviceService.unregisterDevice(deviceId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeviceService getWrappedDeviceService() {
		return _deviceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeviceService(DeviceService deviceService) {
		_deviceService = deviceService;
	}

	@Override
	public DeviceService getWrappedService() {
		return _deviceService;
	}

	@Override
	public void setWrappedService(DeviceService deviceService) {
		_deviceService = deviceService;
	}

	private DeviceService _deviceService;
}