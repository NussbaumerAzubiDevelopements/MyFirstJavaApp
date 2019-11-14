import java.util.Date;

class Tasks {

    int taskId, persId;
    String description;
    char status;
    boolean deleteFlag;
    Date createDate, startDate, completionDate;

    public Tasks(int taskId, int persId, String description, char status, boolean deleteFlag, Date createDate, Date startDate, Date completionDate) {
        this.taskId = taskId;
        this.persId = persId;
        this.description = description;
        this.status = status;
        this.deleteFlag = deleteFlag;
        this.createDate = createDate;
        this.startDate = startDate;
        this.completionDate = completionDate;
    }

    public Tasks() {
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskId=" + taskId +
                ", persId=" + persId +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", deleteFlag=" + deleteFlag +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", completionDate=" + completionDate +
                '}';
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getPersId() {
        return persId;
    }

    public void setPersId(int persId) {
        this.persId = persId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}