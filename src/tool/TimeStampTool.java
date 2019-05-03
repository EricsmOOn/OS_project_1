package tool;

import java.util.Date;

/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc: 全局时间控制器
 */
public class TimeStampTool {
    private static Date startTimeStamp;

    public static Integer getTimeStamp(){
        Date now = new Date();

        return Math.toIntExact((now.getTime() - startTimeStamp.getTime()) / 1000);
    }

    public static void InitTimeStampTool(){
        startTimeStamp = new Date();
    }

}
