package repository;

import config.JdbcConnection;
import domain.Me;
import dto.SignupDto;

import java.sql.*;

public class UserRepository {
    public static Me me;



    public boolean login(String id, String password)  {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from users where username = ? and password = ? ";
        Integer id1 = null;
        String name= null;
        boolean ret=false;
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.setString(2,password);
            ResultSet resultSet =psmt.executeQuery();
            while(resultSet.next())
            {
                ret=true;
               id1=  resultSet.getInt("id");
               name = resultSet.getString("name");
               me = new Me(id1,name);
                System.out.println("환영합니다.");
                System.out.println(id1+" " +name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("conn 닫기 실패");
        }
        return ret;


    }
    public void insertUsers(SignupDto dto){
        Connection conn  = new JdbcConnection().getJdbc();
        String sql = "insert into users(username, password, name)\n" + "values(?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,dto.getUsername());
            psmt.setString(2,dto.getPassword());
            psmt.setString(3,dto.getName());
            if(psmt.executeUpdate()==0)
            {
                System.out.println("insert err");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
