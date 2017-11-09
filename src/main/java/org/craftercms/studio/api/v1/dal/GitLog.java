/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2017 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.craftercms.studio.api.v1.dal;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class GitLog implements Serializable {
    private static final long serialVersionUID = -1250934049379625992L;

    private long id;
    private String siteId;
    private String commitId;
    private ZonedDateTime commitDate;
    private int processed;
    private int verified;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }

    public String getCommitId() { return commitId; }
    public void setCommitId(String commitId) { this.commitId = commitId; }

    public ZonedDateTime getCommitDate() { return commitDate; }
    public void setCommitDate(ZonedDateTime commitDate) { this.commitDate = commitDate; }

    public int getProcessed() { return processed; }
    public void setProcessed(int processed) { this.processed = processed; }

    public int getVerified() { return verified; }
    public void setVerified(int verified) { this.verified = verified; }
}
