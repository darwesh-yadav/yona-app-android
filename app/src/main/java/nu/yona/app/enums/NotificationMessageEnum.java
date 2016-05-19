/*
 *  Copyright (c) 2016 Stichting Yona Foundation
 *
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 *
 */

package nu.yona.app.enums;

import nu.yona.app.R;
import nu.yona.app.YonaApplication;

/**
 * Created by kinnarvasa on 12/05/16.
 */
public enum NotificationMessageEnum {

    /**
     * Buddy connect request accepted notification message enum.
     */
    BUDDY_CONNECT_REQUEST_ACCEPTED(NotificationEnum.BUDDYCONNECTREQUESTMESSAGE, StatusEnum.ACCEPTED, getString(R.string.buddyconnectrequested), R.drawable.icn_ok),
    /**
     * Buddy connect request rejected notification message enum.
     */
    BUDDY_CONNECT_REQUEST_REJECTED(NotificationEnum.BUDDYCONNECTREQUESTMESSAGE, StatusEnum.REJECTED, getString(R.string.buddyconnectrequested), 0),
    /**
     * Buddy connect request requested notification message enum.
     */
    BUDDY_CONNECT_REQUEST_REQUESTED(NotificationEnum.BUDDYCONNECTREQUESTMESSAGE, StatusEnum.REQUESTED, getString(R.string.buddyconnectrequested), 0),
    /**
     * Buddy connect request not requested notification message enum.
     */
    BUDDY_CONNECT_REQUEST_NOT_REQUESTED(NotificationEnum.BUDDYCONNECTREQUESTMESSAGE, StatusEnum.NOT_REQUESTED, "BUDDY_CONNECT_REQUEST_NOT_REQUESTED", 0),

    /**
     * Buddy connect response message rejected notification message enum.
     */
    BUDDY_CONNECT_RESPONSE_MESSAGE_REJECTED(NotificationEnum.BUDDYCONNECTRESPONSEMESSAGE, StatusEnum.REJECTED, getString(R.string.buddyresponserejected), R.drawable.icn_no),

    /**
     * Buddy connect response message accepted notification message enum.
     */
    BUDDY_CONNECT_RESPONSE_MESSAGE_ACCEPTED(NotificationEnum.BUDDYCONNECTRESPONSEMESSAGE, StatusEnum.ACCEPTED, getString(R.string.buddyresponseaccepted), R.drawable.icn_ok),

    BUDDY_DISCONNECT_MESSAGE_USER_REMOVED_BUDDY(NotificationEnum.BUDDYDISCONNECTMESSAGE, StatusEnum.USER_REMOVED_BUDDY, "User removed buddy", 0),

    DISCLOSUREREQUESTMESSAGE_ENUM_DISCLOSURE_REQUESTED(NotificationEnum.DISCLOSUREREQUESTMESSAGE, StatusEnum.DISCLOSURE_REQUESTED, "DISCLOSURE_REQUESTED", 0),

    DISCLOSUREREQUESTMESSAGE_ENUM_DISCLOSURE_ACCEPTED(NotificationEnum.DISCLOSUREREQUESTMESSAGE, StatusEnum.DISCLOSURE_ACCEPTED, "DISCLOSURE_ACCEPTED", 0),

    DISCLOSUREREQUESTMESSAGE_ENUM_DISCLOSURE_REJECTED(NotificationEnum.DISCLOSURERESPONSEMESSAGE, StatusEnum.DISCLOSURE_REJECTED, "DISCLOSURE_REJECTED", 0),

    DISCLOSURERESPONSEMESSAGE_ENUM_DISCLOSURE_ACCEPTED(NotificationEnum.DISCLOSURERESPONSEMESSAGE, StatusEnum.DISCLOSURE_ACCEPTED, "DISCLOSURE_ACCEPTED", 0),

    DISCLOSURERESPONSEMESSAGE_ENUM_DISCLOSURE_REJECTED(NotificationEnum.DISCLOSURERESPONSEMESSAGE, StatusEnum.DISCLOSURE_REJECTED, "DISCLOSURE_REJECTED", 0),

    BUDDY_DISCONNECT_MESSAGE_USER_ACCOUNT_DELETED(NotificationEnum.BUDDYDISCONNECTMESSAGE, StatusEnum.USER_ACCOUNT_DELETED, "User Account Deleted", 0),

    GOALCHANGEMESSAGE_ADDED(NotificationEnum.GOALCHANGEMESSAGE, StatusEnum.ADDED, "Goal Added", 0),

    GOALCHANGEMESSAGE_DELETED(NotificationEnum.GOALCHANGEMESSAGE, StatusEnum.DELETED, "Goal Deleted", 0),

    GOALCHANGEMESSAGE_CHANGED(NotificationEnum.GOALCHANGEMESSAGE, StatusEnum.CHANGED, "Goal Changed", 0),

    GOALCONFLICTMESSAGE_DISCLOSURE_REQUESTED(NotificationEnum.GOALCONFLICTMESSAGE, StatusEnum.DISCLOSURE_REQUESTED, "DISCLOSURE_REQUESTED", 0),

    GOALCONFLICTMESSAGE_DISCLOSURE_ACCEPTED(NotificationEnum.GOALCONFLICTMESSAGE, StatusEnum.DISCLOSURE_ACCEPTED, "DISCLOSURE_ACCEPTED", 0),

    GOALCONFLICTMESSAGE_DISCLOSURE_REJECTED(NotificationEnum.GOALCONFLICTMESSAGE, StatusEnum.DISCLOSURE_REJECTED, "DISCLOSURE_REJECTED", 0),

    /**
     * None none notification message enum.
     */
    NONE_NONE(NotificationEnum.NONE, StatusEnum.NONE, "NONE_NONE", 0);

    /**
     * The Notification enum.
     */
    NotificationEnum notificationEnum;
    /**
     * The Status enum.
     */
    StatusEnum statusEnum;
    /**
     * The User message.
     */
    String userMessage;
    /**
     * The Image id.
     */
    int imageId;

    NotificationMessageEnum(NotificationEnum notificationEnum, StatusEnum statusEnum, String userMessage, int imageId) {
        this.notificationEnum = notificationEnum;
        this.statusEnum = statusEnum;
        this.userMessage = userMessage;
        this.imageId = imageId;
    }

    /**
     * Gets string.
     *
     * @param id the id
     * @return the string
     */
    static String getString(int id) {
        return YonaApplication.getAppContext().getString(id);
    }

    /**
     * Gets notification message enum.
     *
     * @param notificationType the notification type
     * @param statusType       the status type
     * @return the notification message enum
     */
    public static NotificationMessageEnum getNotificationMessageEnum(String notificationType, String statusType) {
        return getNotificationMessageEnum(NotificationEnum.getNotificationEnum(notificationType), StatusEnum.getStatusEnum(statusType));
    }

    /**
     * Gets notification message enum.
     *
     * @param notificationEnum the notification enum
     * @param statusEnum       the status enum
     * @return the notification message enum
     */
    public static NotificationMessageEnum getNotificationMessageEnum(NotificationEnum notificationEnum, StatusEnum statusEnum) {
        for (NotificationMessageEnum v : values()) {
            if (v.getNotificationEnum() == notificationEnum && v.getStatusEnum() == statusEnum) {
                return v;
            }
        }
        return NONE_NONE;
    }

    /**
     * Gets user message.
     *
     * @return the user message
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Gets notification enum.
     *
     * @return the notification enum
     */
    public NotificationEnum getNotificationEnum() {
        return notificationEnum;
    }

    /**
     * Gets image id.
     *
     * @return the image id
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * Gets status enum.
     *
     * @return the status enum
     */
    public StatusEnum getStatusEnum() {
        return statusEnum;
    }
}
