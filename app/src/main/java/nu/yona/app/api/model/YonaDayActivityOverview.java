/*
 *  Copyright (c) 2016 Stichting Yona Foundation
 *
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 *
 */

package nu.yona.app.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kinnarvasa on 06/06/16.
 */

public class YonaDayActivityOverview {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("timeZoneId")
    @Expose
    private String timeZoneId;
    @SerializedName("dayActivities")
    @Expose
    private List<DayActivity> dayActivities = new ArrayList<DayActivity>();
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The timeZoneId
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     *
     * @param timeZoneId
     * The timeZoneId
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    /**
     *
     * @return
     * The dayActivities
     */
    public List<DayActivity> getDayActivities() {
        return dayActivities;
    }

    /**
     *
     * @param dayActivities
     * The dayActivities
     */
    public void setDayActivities(List<DayActivity> dayActivities) {
        this.dayActivities = dayActivities;
    }

    /**
     *
     * @return
     * The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The _links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

}