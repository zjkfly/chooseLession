package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Zuel
{
	public static void main(String arg[]) throws IOException
	{
		Map<String, String> cookie = new HashMap<>();
		LinkedList<String> p_qxrxk = new LinkedList<>();
		LinkedList<String> p_qxrxk_kxh = new LinkedList<>();

		String name = "201504000103";// 学号
		String pwd = "OMCIUD";// 密码
		p_qxrxk.add("B0400540");
		p_qxrxk_kxh.add("9");
		int waitTime = 20000;// 请求等待时间，毫秒

		/* Don't change the following code */
		String login = "http://202.114.224.81:7777/pls/wwwbks/bks_login2.login";
		String chooseLession = "http://202.114.224.81:7777/pls/wwwbks/xk.CourseInput";
		int length = p_qxrxk.size();
		cookie = Jsoup.connect(login).data("pwd", pwd, "stuid", name).timeout(waitTime).execute().cookies();
		System.out.println(cookie);
		for (int i = 0; i < length; i++)
		{
			Document document = Jsoup.connect(chooseLession)
					.data("p_qxrxk", p_qxrxk.get(i), "p_qxrxk_kxh", p_qxrxk_kxh.get(i)).cookies(cookie)
					.timeout(waitTime).execute().parse();
			System.out.println(document.data());
		}
	}
}