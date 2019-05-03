package pojo;

/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc: 角色
 */
public class Character {

    private Integer threadNumber;//线程号

    private Integer startTime;//开始时间

    private Integer holdingTime;//持续时间

    public Character(Integer threadNumber, Integer startTime, Integer holdingTime) {
        this.threadNumber = threadNumber;
        this.startTime = startTime;
        this.holdingTime = holdingTime;
    }

    public Integer getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(Integer threadNumber) {
        this.threadNumber = threadNumber;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(Integer holdingTime) {
        this.holdingTime = holdingTime;
    }
}
