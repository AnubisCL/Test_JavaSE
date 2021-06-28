package cn.test.exer2;

import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void test(){
        Dao<User> userDao = new Dao<>();

        //.save()
        userDao.save("001",new User(1,12,"AA"));
        userDao.save("002",new User(2,22,"bb"));
        userDao.save("003",new User(3,33,"CC"));

        //.update()
        userDao.update("002",new User(2,22,"BB"));

        //.delete()
        userDao.delete("003");

        //.list()
        List<User> list = userDao.list();
        //System.out.println(list);
        //Java8 新特性：
        list.forEach(System.out::println);

        //.get()
        User user = userDao.get("001");
        System.out.println("001 => " + user.toString());

    }
}
