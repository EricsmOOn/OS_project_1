package tool;

import java.util.concurrent.Semaphore;

/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc:
 */
public class Sem {

    public final static Semaphore wsem = new Semaphore(1);
    public final static Semaphore x = new Semaphore(1);
    public static Integer readCount = 0;

}
