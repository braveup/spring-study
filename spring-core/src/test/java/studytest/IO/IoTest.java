package studytest.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by braveup on 2017/3/5.
 */
public class IoTest {
    @Test
    public void testIo() {
        File dir = new File("E:\\xiangmu");
        getAllFile(dir);
    }

    private void getAllFile(File dir) {
        System.out.println("dir" + dir);
        //1.获取该文件下的所有文件
        File[] str = dir.listFiles();
        for (File file1 : str) {
            if (file1.isDirectory()) {
                getAllFile(file1);
            } else {
                System.out.println("file" + file1);
            }
        }
    }
    //文件流的作用是打开文件，在用字节流或者字符流将信息写入，最终关闭资源
    @Test
    public  void  test() throws FileNotFoundException {
        File  file=new File ("E://test");
        if (!file.exists()){
            file.mkdir();
        }
        FileOutputStream  fileOutputStream=new FileOutputStream("E://test/a.txt",true);
        OutputStream  outputStream=new BufferedOutputStream(fileOutputStream);
        //如何增量的写入
        String str="hellow";
        try {
         outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                new RuntimeException(e);
            }
        }

    }


}
