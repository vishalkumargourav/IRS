package in.ezeon.rm;

import in.ezeon.command.AdminCommand;
import in.ezeon.domain.AdminLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class AdminCommandRowMapper implements RowMapper<AdminLogin> {

    @Override
    public AdminLogin mapRow(ResultSet rs, int i) throws SQLException {
        AdminLogin adminCommand=new AdminLogin();
        adminCommand.setAdminId(rs.getInt("adminId"));
        adminCommand.setFirstName(rs.getString("firstName"));
        adminCommand.setLastName(rs.getString("lastName"));
        adminCommand.setUserName(rs.getString("userName"));
        adminCommand.setPassword(rs.getString("password"));
        return adminCommand;
          }
    
}
