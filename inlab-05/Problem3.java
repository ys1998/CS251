public class Problem3 {
    public static void main(String args[]) {
        String inp = System.console().readLine();
        String[] input = inp.split(",");
        int h = Integer.parseInt(input[input.length - 1].trim());
        String[] temp = input[input.length - 2].split(" ");
        int l = Integer.parseInt(temp[temp.length - 1].trim());
        System.out.println(inp.substring(l, h+1));
    }
}