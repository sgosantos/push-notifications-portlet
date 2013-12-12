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

package com.liferay.mobile.pushnotifications.util;

import com.liferay.util.portlet.PortletProps;

/**
 * @author Bruno Farache
 * @author Silvio Santos
 */
public class PortletPropsValues {

	public static final String ANDROID_API_KEY = PortletProps.get(
		PortletPropsKeys.ANDROID_API_KEY);

	public static final String IOS_CERT_PASSWORD = PortletProps.get(
		PortletPropsKeys.IOS_CERT_PASSWORD);

	public static final String IOS_CERT_PATH = PortletProps.get(
		PortletPropsKeys.IOS_CERT_PATH);

	public static final String IOS_SANDBOX = PortletProps.get(
		PortletPropsKeys.IOS_SANDBOX);

}