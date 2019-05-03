package pojo;

import tool.Sem;
import tool.TimeStampTool;


/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc: 读者
 */
public class Reader extends Character implements Runnable {
    private int i =1;

    public Reader(Integer threadNumber, Integer startTime, Integer holdingTime) {
        super(threadNumber, startTime, holdingTime);
    }

    @Override
    public synchronized void run() {
        System.out.printf("线程 %02d 于时间 >> %02d << 创建成功\n", this.getThreadNumber(),TimeStampTool.getTimeStamp());
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void read() throws InterruptedException {
        while (true) {

            if (TimeStampTool.getTimeStamp() >= (this.getStartTime())) {
                if(i == 1){
                    i--;
                    System.out.printf("                                "+
                            "线程 %02d 于时间 >> %02d << 请求读取\n", this.getThreadNumber(),TimeStampTool.getTimeStamp());
                }

                Sem.x.acquire();
                Sem.readCount++;
                if (Sem.readCount == 1) {
                    Sem.wsem.acquire();
                }
                Sem.x.release();


                System.out.printf("                                                                "+
                        "线程 %02d 于时间 >> %02d << 开始读取\n", this.getThreadNumber(),TimeStampTool.getTimeStamp());
                Thread.sleep(this.getHoldingTime() * 1000);
                System.out.printf("                                                                                                "
                                +"线程 %02d 于时间 >> %02d << 读取完毕\n",this.getThreadNumber(), TimeStampTool.getTimeStamp());


                Sem.x.acquire();
                Sem.readCount--;
                if (Sem.readCount == 0) {
                    Sem.wsem.release();
                }
                Sem.x.release();

                break;
            }
        }
    }

}
