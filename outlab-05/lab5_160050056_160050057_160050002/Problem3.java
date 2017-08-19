import java.net.Socket;
import java.net.*;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;
import java.io.*;
import java.security.*;

public class problem3{
	private static void get(String args) throws IOException{

		String host = "https://www.cse.iitb.ac.in";
		String path = "/~safeer/get_hash.php";
		String query = "?input=" + args;
		
		//Much better way to obtain the host address
		//String urlString = host + path; 
		//URL url = new URL(urlString);
		//url.getHost(); instead of "www.cse.iitb.ac.in"

		SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket("www.cse.iitb.ac.in", 443);
		
		//Or, in short:
		//SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("www.cse.iitb.ac.in", 443);
		
		//This won't work:
		//Socket socket = new Socket("www.cse.iitb.ac.in", 80);

		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		out.println("GET " + path + query + " text/html"); 
		out.println();
		out.flush();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
					socket.getInputStream()));

		String line;

		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}

		out.close();
		in.close();
	}
	
	private static void post(String args) throws IOException{
  
  //Left to  correct this

		String host = "https://www.cse.iitb.ac.in";
		String path = "/~safeer/post_hash.php";
		String query = "input=" + args;

		SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket("www.cse.iitb.ac.in", 443);
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		out.println("POST " + path + " text/html");
		//out.println("Content-Type: application/x-www-form-urlencoded-1");
		//out.println("charset=iso-8859-1");
		//out.println("Content-Length: " + query.length()); 
		out.println();
		out.println(query);
		//out.println();
		out.flush();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
					socket.getInputStream()));

		String line;

		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}

		out.close();
		in.close();
	}

	public static void main(String[] args) throws IOException{
		get(args[0]);
		post(args[0]);
	}

}
