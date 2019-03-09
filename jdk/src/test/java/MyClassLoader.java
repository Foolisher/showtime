/**
 * Created by fuxiao(¸¶Ð¦) on 2019/1/8.
 */
public class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
