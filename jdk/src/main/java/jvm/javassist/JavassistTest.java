package jvm.javassist;

import javassist.*;
import org.junit.Test;

import java.io.*;

/**
 * Created by wanggen on 15/11/21.
 */
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

        userService.say();

    }

}