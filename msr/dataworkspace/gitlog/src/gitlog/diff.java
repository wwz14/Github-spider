package gitlog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class diff {
	   Connection conn;
	   Process process;
	public diff(){
		 SQLcon connect = new SQLcon("githublog");
		 conn = connect.getConn();
	}
	
	public static void main(String[] args) {
		diff d = new diff();
		try {
			//d.putdiff("binlog");
			d.putdiff("jdtlog");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	public void putdiff(String tablename) throws Exception {
		String select = "select * from "+tablename;
		//Statement statement = conn.createStatement() ;
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		//cdCommand("cd "+path);
		while(rs.next()){
			String commit = rs.getString(1);
			//调用命令行
			String cmd = "sh /Users/alice/Documents/getdiff.sh " + commit;
			String difference = shell.getdifference(cmd);
			System.out.println(difference);
			
			String update = "update "+tablename +" set detail=? where commit=?;";
			PreparedStatement ps2 = conn.prepareStatement(update);
			ps2.setString(1, difference);
			ps2.setString(2, commit);
			ps2.execute();
		}
	}
	
	
	}

