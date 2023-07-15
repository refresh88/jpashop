package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional  // 테스트에 요게 있으면 테스트 후에 rollback을 해버림.
//    @Rollback(false)    // 요거 넣으면  rollback 안함.
//    void testMember() {
//        //given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        //then
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        assertThat(findMember).isEqualTo(member);
//        System.out.println("findMember == member: " + (findMember == member));
//    }
}