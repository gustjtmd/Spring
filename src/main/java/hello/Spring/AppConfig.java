package hello.Spring;

import hello.Spring.discount.DiscountPolicy;
import hello.Spring.discount.FixDiscountPolicy;
import hello.Spring.discount.RateDiscountPolicy;
import hello.Spring.member.MemberRepository;
import hello.Spring.member.MemberService;
import hello.Spring.member.MemberServiceImpl;
import hello.Spring.member.MemoryMemberRepository;
import hello.Spring.order.OrderService;
import hello.Spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        //1번
        System.out.println("call AppConfig.orderService");
       return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        //2번? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
