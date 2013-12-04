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

package com.liferay.mobile.pushnotifications.messaging;

import com.liferay.mobile.pushnotifications.android.GCMUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import java.io.IOException;

import java.util.List;

/**
 * @author Silvio Santos
 */
public class NotificationMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {
		List<Long> userIds = (List<Long>)message.get("userIds");
		String collapseKey = message.getString("collapseKey");
		String data = message.getString("data");
		int timeToLive = message.getInteger("timeToLive");
		boolean delayWhileIdle = message.getBoolean("delayWhileIdle");

		for (long userId : userIds) {
			try {
				GCMUtil.sendNotification(
					userId, collapseKey, data, timeToLive, delayWhileIdle);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}