package klass;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.junit.Test;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/1/8.
 */
public class JavassistTest {

    @Test
    public void t1() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("klass.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        Class c = cc.toClass();
        Hello h = (Hello) c.newInstance();
        h.say();
    }


}

class Hello {
    public void say() {
        System.out.println("hello");
    }
}
