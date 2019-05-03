import pojo.Reader;
import pojo.Writer;
import tool.FileTool;
import tool.TimeStampTool;

import java.util.List;


/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc:
 */
public class Main {


    public static void main(String[] args) throws Exception {

        List list = FileTool.getInfo("a.txt");

        Thread.sleep(3000);

        System.out.println("======================程序开始======================\n");

        TimeStampTool.InitTimeStampTool();

        for(Object o:list){
            if(o instanceof Reader){
                new Thread((Reader)o).start();
            }
            if(o instanceof Writer){
                new Thread((Writer)o).start();
            }
        }

    }

}
