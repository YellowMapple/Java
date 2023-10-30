# Java
```ruby

package IOStreamDay1;

import java.io.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\戢南山\\Desktop\\day1");
        File f2 = new File("C:\\Users\\戢南山\\Desktop\\copy1");
        copydir(f1, f2);

    }

    private static void copydir(File f1, File f2) throws IOException {
        f2.mkdir();
        File[] files = f1.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(f2, file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileOutputStream.close();
                fileInputStream.close();
            } else {
                copydir(file, new File(f2, file.getName()));
            }
        }
    }


}
```
