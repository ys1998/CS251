public class Arg{
	public static void main(String[] args){
		int length=0,sum=0;
		for(String arg : args){
			length++;
			sum+=Integer.parseInt(arg);
		}
		System.out.println(length+", "+sum);
	}
}