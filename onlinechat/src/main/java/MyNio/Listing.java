package MyNio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Liuqi
 * Date: 2016/10/16
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Listing {
    public static void main(String[] args) {
        Path path = Paths.get("user/bin/zip");
        System.out.println(path.getFileSystem());
        System.out.println(path.getRoot());
        System.out.println(path.getNameCount());
    }

    public static void findJava() {
        Path path = Paths.get("D:\\项目\\springmvc_mybatis1208\\src\\cn\\itcast\\ssm\\controller");
        DirectoryStream<Path> stream = null;
        try {
            stream = Files.newDirectoryStream(path, "*.java");
            for (Path p : stream) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void findJava1() throws IOException {
        Path path = Paths.get("D:\\项目\\springmvc_mybatis1208\\src\\cn\\itcast\\ssm\\controller");
        Files.walkFileTree(path, new FindJavaVistor());

    }

    private static class FindJavaVistor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (dir.toString().endsWith(".java")) {
                System.out.println(dir.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
