//https://stackoverflow.com/questions/24416930/java-malformed-url-exception
//http://www.jguru.com/faq/view.jsp?EID=32388
//https://stackoverflow.com/questions/14551194/how-are-parameters-sent-in-an-http-post-request

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
		out.println("GET " + path + query + " HTTP/1.0"); 
		out.println("Host: www.cse.iitb.ac.in");
		out.println();
		out.flush();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
					socket.getInputStream()));

		String line;

		while ((line = in.readLine()) != null) {
			if(line.length() > 5 && line.substring(0,4).equals("Hash")) System.out.println(line);
		}

		out.close();
		in.close();
	}
	
	private static void post(String args) throws IOException{

		String host = "https://www.cse.iitb.ac.in";
		String path = "/~safeer/post_hash.php";
		String query = "input=" + args;

		SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket("www.cse.iitb.ac.in", 443);
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		out.println("POST " + path + " HTTP/1.0");
		out.println("Host: www.cse.iitb.ac.in");
		out.println("Content-Type: application/x-www-form-urlencoded");
		out.println("Content-Length: " + query.length()); 
		out.println();
		out.println(query);
		//out.println();
		out.flush();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
					socket.getInputStream()));

		String line;

		while ((line = in.readLine()) != null) {
			if(line.length() > 5 && line.substring(0,4).equals("Hash")) System.out.println(line);
		}

		out.close();
		in.close();
	}

	public static void main(String[] args) throws IOException{
		System.out.println("Sending GET request: ");
		get(args[0]);
		System.out.println("Sending POST request: ");
		post(args[0]);
	}

}
