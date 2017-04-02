package jvm.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavassistTest {


    @Test
    public void test1() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass ctClass = cp.get("jvm.javassist.UserService");
        for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
            ctMethod.insertBefore("System.out.println(this);");
        }

        ctClass.toBytecode(new DataOutputStream(new FileOutputStream("UserService.class")));

        Class aClass = ctClass.toClass();

        UserService userService = (UserService)aClass.newInstance();

        userService.say("wg");

    }

}
