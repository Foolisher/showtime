package jdk.klass;

import com.google.common.base.Strings;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Desc:
 * Created by wanggen on 2015-11-28 下午7:38.
 */
public class ClassLoaderTest {


    @Test
    public void test1() throws IOException {

        URL resource = Strings.class.getResource("");

        String path = resource.getPath().substring(0, resource.getPath().indexOf("!"));

        JarFile jarFile = new JarFile(path);
//        JarFile jarFile = new JarFile(path.replace("file:", ""));

        Enumeration<JarEntry> entries = jarFile.entries();



        System.out.println(jarFile);
    }

}
