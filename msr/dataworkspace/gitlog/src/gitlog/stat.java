package gitlog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class stat {
	 Connection conn;
	   Process process;
	public stat(){
		 SQLcon connect = new SQLcon("githublog");
		 conn = connect.getConn();
	}
	
	public static void main(String[] args) {
		stat s = new stat();
		try {
			s.putstat("jdtlog");
			//d.putstat("jdtlog");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public void putstat(String tablename) throws Exception {
		String select = "select * from "+tablename;
		//Statement statement = conn.createStatement() ;
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		//cdCommand("cd "+path);
		while(rs.next()){
			String commit = rs.getString(1);
			//调用命令行
			String cmd = "sh /Users/alice/Documents/getstat.sh " + commit;
			ArrayList<String> stat = shell.getstat(cmd);
			
			for(String str:stat){
				System.out.println("str:"+str);
			}
			System.out.println("That's the end");
			
			String update = "update "+tablename +" set file_change=?,file_change_number=?,insertion=?,deletions=? where commit=?;";
			System.out.println(update);
			PreparedStatement ps2 = conn.prepareStatement(update);
			ps2.setString(1, stat.get(0));
			ps2.setInt(2, Integer.parseInt(stat.get(1)));
			ps2.setInt(3, Integer.parseInt(stat.get(2)));
			ps2.setInt(4, Integer.parseInt(stat.get(3)));
			ps2.setString(5, commit);
			ps2.execute();
		}
	}
	
}
