package gitlog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
	
    Connection conn;
    
    public static void main(String[] agrs){
   	 insert in = new insert();
   	 try {
			//in.insertInto("/Users/alice/Desktop/uihistory/uilog.txt","uilog");
   		 //in.insertInto("/Users/alice/Desktop/binhistory/binlog.txt", "binlog");
   		in.insertInto("/Users/alice/Desktop/lshistory/lslog.txt", "lslog");
   		// in.insertInto("/Users/alice/Desktop/corehistory/corelog.txt", "corelog");
   		in.insertInto("/Users/alice/Desktop/debughistory/debuglog.txt", "debuglog");
   		//in.insertInto("/Users/alice/Desktop/jdthistory/jdtlog.txt", "jdtlog");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public insert(){
   	 SQLcon connect = new SQLcon("githublog");
	 conn = connect.getConn();
    }
   
	public  void insertInto (String filename,String tablename) throws IOException {
	
		File f = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line ;
		while(!((line = br.readLine())==null)){
			System.out.println(line);
			String[] split =line.split(" w_w_z ");
			String commit = split[0];
			System.out.println(commit);
			String author = split[1];
			String committer = split[2];
			String commit_date = split[3];
			String state = split[4];
			String sql = "insert into "+tablename +" VAlUE ('"+commit+"','"+author+"','"+committer+
					"','"+commit_date+"','"+state+"');";
			System.out.println(sql);
			insertintotable(sql);
		}
	}
	
	private void insertintotable(String sql) {
		try {
			Statement statement = conn.createStatement() ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
