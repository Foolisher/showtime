package jdk.klass;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by wanggen on 15/11/21.
 */
public class KlassTest {


    @Test
    public void test(){

        ServiceLoader<IUserService> loader = ServiceLoader.load(IUserService.class);
        Iterator<IUserService> iterator = loader.iterator();

    }

    public static void main(String[] args){
        for (IUserService iUserService : ServiceLoader.load(IUserService.class)) {
            System.out.println(iUserService);
        }

    }

}
