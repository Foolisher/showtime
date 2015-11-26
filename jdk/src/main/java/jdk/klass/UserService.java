package jdk.klass;

/**
 * Created by wanggen on 15/11/21.
 */
public class UserService implements IUserService {

    @Override
    public String hello() {
        return "name wg";
    }
}
