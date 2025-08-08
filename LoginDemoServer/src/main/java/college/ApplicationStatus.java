package college;

import java.sql.Timestamp;

public class ApplicationStatus {
    private String applicationId;
    private String status;
    private Timestamp lastUpdated;
    private String comments;

    // Constructor
    public ApplicationStatus() {}

    // Getter
    public String getApplicationId() {
        return applicationId;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public String getComments() {
        return comments;
    }

    // Setters
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ApplicationStatus{" +
                "applicationId='" + applicationId + '\'' +
                ", status='" + status + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", comments='" + comments + '\'' +
                '}';
    }
}
