package junit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.potal.service.MemberService;

public class Test6 {
	public static void main(String[] args) throws Exception {
			ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring*.xml");
			MemberService memberService =ioc.getBean(MemberService.class);
			for (int i = 1; i <= 50; i++) {
				Member member = new Member();
				member.setLoginacct("text"+i);
				member.setUserpswd("123");
				member.setUsername("text"+i);
				member.setEmail("text"+i+"@.liu.com");
				member.setAuthstatus("0");
				member.setUsertype("1");
				
				
			}
			
		}

	}


