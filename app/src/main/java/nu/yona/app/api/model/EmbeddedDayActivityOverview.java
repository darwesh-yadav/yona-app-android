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

public class EmbeddedDayActivityOverview {
    @SerializedName("yona:dayActivityOverviews")
    @Expose
    private List<YonaDayActivityOverview> yonaDayActivityOverviews = new ArrayList<YonaDayActivityOverview>();

    /**
     *
     * @return
     * The yonaDayActivityOverviews
     */
    public List<YonaDayActivityOverview> getYonaDayActivityOverviews() {
        return yonaDayActivityOverviews;
    }

    /**
     *
     * @param yonaDayActivityOverviews
     * The yona:dayActivityOverviews
     */
    public void setYonaDayActivityOverviews(List<YonaDayActivityOverview> yonaDayActivityOverviews) {
        this.yonaDayActivityOverviews = yonaDayActivityOverviews;
    }

}