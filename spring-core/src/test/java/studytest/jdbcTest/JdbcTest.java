package studytest.jdbcTest;


import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * Created by braveup on 2017/3/5.
 */
public class JdbcTest {
    /**
     * jdbc是java程序与数据库之间的交互
     */

    //加载数据库的驱动
    //两种方式1.直连 2.动态获取 3.字符串链接
    @Test
    public void getDriver() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/springstudy?connectTimeout=10000&socketTimeout=10000";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
        Statement statement = connection.createStatement();
        String sql = "insert into tb_study(id,name,score) values('1','test0','100')";
        statement.execute(sql);
        System.out.println("获取数据库的链接成功");
    }

    //动态的获取数据库的链接
    public static Connection getDriverTwo() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //加载驱动
        String drivers = "com.mysql.jdbc.Driver";
        Class<?> clazz = Class.forName(drivers);
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/springstudy?connectTimeout=10000&socketTimeout=10000";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        Connection connection = driver.connect(url, properties);
        System.out.println("链接成功");
        return connection;
    }

    public Connection getDriverByString() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //获取驱动
        String drivers = "com.mysql.jdbc.Driver";
        Class<?> clazz = Class.forName(drivers);
        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        String url = "jdbc:mysql://localhost:3306/springstudy?connectTimeout=10000&socketTimeout=10000";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("获取连接成功");
        return connection;
    }

    @Test
    public void jdbcTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection connection = getDriverByString();
        Statement statement = connection.createStatement();
        String sql = "insert into tb_study(id,name,score) values('2','test0','100')";
        statement.execute(sql);
    }

    //预编译的sql执行

    /**
     * PreparedStatement接口
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void test() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //获取数据库的链接
        Connection connection = getDriverByString();
        //获取预编译执行的对象
        PreparedStatement preparedStatement = null;
        //获取执行的结果
        ResultSet resultSet = null;
        //编写sql
        String sql = "select * from  tb_study  where id = ?";
        //初始化预编译对象
        preparedStatement = connection.prepareStatement(sql);
        //设置查询的条件
        preparedStatement.setInt(1, 2);
        resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("name" + resultSet.getInt(1));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
