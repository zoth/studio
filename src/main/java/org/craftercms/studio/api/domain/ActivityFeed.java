package org.craftercms.studio.api.domain;

import java.io.Serializable;
import java.util.Date;

public class ActivityFeed implements Serializable {

    private static final long serialVersionUID = 4251603625791912910L;
    protected long id;
    protected Date modifiedDate;
    protected Date creationDate;
    protected String summary;
    protected String summaryFormat;
    protected String contentId;
    protected String contentType;
    protected String type;
    protected String userId;
    protected String siteNetwork;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Date getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(Date modifiedDate) { this.modifiedDate = modifiedDate; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getSummaryFormat() { return summaryFormat; }
    public void setSummaryFormat(String summaryFormat) { this.summaryFormat = summaryFormat; }

    public String getContentId() { return contentId; }
    public void setContentId(String contentId) { this.contentId = contentId; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getSiteNetwork() { return siteNetwork; }
    public void setSiteNetwork(String siteNetwork) { this.siteNetwork = siteNetwork; }
}
