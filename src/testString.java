/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:测试类
 *创建时间:2016年6月5日下午9:35:46
 */
public class testString {
		public static void main(String[] args) {
			String a = "abc \"abc\"  \'abc\' ";
			System.out.println(a);
			String newb = a.replace("\'", "");
			System.out.println(newb);
			String newa = a.replace("\"","");
			System.out.println(newa);
		}
}
