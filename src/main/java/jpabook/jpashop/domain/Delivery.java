package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded // 내장 타입이라 써줘야 함.
    private Address address;

    @Enumerated(EnumType.STRING) // Ordinary 쓰면 숫자로 표현되는데 중간에 뭔가 추가되면 숫자가 밀려서 쓰면 안됨.
    private DeliveryStatus status; // READY, COMP
}
