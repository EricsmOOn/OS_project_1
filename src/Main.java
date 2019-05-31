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

        //读取配置文件 config.properties
        List list = FileTool.getInfo(FileTool.getProperties("filename"));



        System.out.println("======================算法开始======================\n");

        //时间戳初始化
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
