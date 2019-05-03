package tool;

import pojo.Reader;
import pojo.Writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: OS_project_1
 * @CoderName: Eric Wong
 * @Date: 2019/5/3
 * @Desc:
 */
public class FileTool {

    public static List getInfo(String path) throws Exception {
        StringBuilder txt = getDataFromTxt(path);
        System.out.print("======================读入信息======================");
        System.out.println(txt);
        System.out.println("======================读取结束======================\n");
        return toCharacter(txt.toString());
    }

    /**
     * @return java.lang.StringBuilder
     * @Description 读取文件到StringBuilder
     * @parameters
     */
    public static StringBuilder getDataFromTxt(String path) throws Exception {
        if (!new File(path).exists()) {
            throw new Exception("不存在" + path + "此文件");
        }
        StringBuilder sb = new StringBuilder();
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((s = br.readLine()) != null) {
                //System.lineSeparator() --> 获取系统的回车符
                sb.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }


    /**
     * @Description
     * 字符串注入Students POJO
     * @parameters  [info]
     * @return
     */
    public static List toCharacter(String info) {
        List c = new ArrayList<>();
        String[] strings = info.split("\n");
        String s = "";

        for(int i = 2;i < strings.length;i++){
            s = strings[i].replaceAll(" +",",");
            String[] split = s.split(",");

            if(split[2].equals("R")){
                c.add(new Reader(Integer.parseInt(split[1]),Integer.parseInt(split[3]),Integer.parseInt(split[4])));
            }

            if(split[2].equals("W")){
                c.add(new Writer(Integer.parseInt(split[1]),Integer.parseInt(split[3]),Integer.parseInt(split[4])));
            }

        }

        return c;
    }


}
