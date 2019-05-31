package pojo;

import tool.FileTool;
import tool.Sem;
import tool.TimeStampTool;

/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc:
 */
public class Writer extends Character implements Runnable {

    private int i = 1;

    public Writer(Integer threadNumber, Integer startTime, Integer holdingTime) {
        super(threadNumber, startTime, holdingTime);
    }

    @Override
    public synchronized void run() {
        System.out.printf("线程 %02d 于时间 >> %02d << 创建成功\n", this.getThreadNumber(),TimeStampTool.getTimeStamp());
        try {
            write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write() throws InterruptedException {
        while (true) {

            if (TimeStampTool.getTimeStamp() >= (this.getStartTime())) {
                if(i == 1){
                    i--;
                    System.out.printf("                                "+
                            "线程 %02d 于时间 >> %02d << 请求写入\n", this.getThreadNumber(),TimeStampTool.getTimeStamp());
                }

                Sem.wsem.acquire();


                System.out.printf("                                                                "
                        +"线程 %02d 于时间 >> %02d << 开始写入\n", this.getThreadNumber(), TimeStampTool.getTimeStamp());
                Thread.sleep(this.getHoldingTime() * 1000);
                System.out.printf("                                                                                                "
                                +"线程 %02d 于时间 >> %02d << 写入完毕\n",this.getThreadNumber(),TimeStampTool.getTimeStamp());


                Sem.wsem.release();
                break;

            }
        }
    }
}
