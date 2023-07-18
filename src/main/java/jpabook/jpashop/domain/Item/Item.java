package jpabook.jpashop.domain.Item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // 한 테이블에 다 떄려넣음.
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//
    /**
     * 왜 이 domain에 굳이 stockQuantity에 관련된 비즈니스 로직을 넣었는가?
     * 보통 데이터를 가지고 있는쪽에 비즈니스 메서드가 있는것이 가장 좋음.
     * 그래야 응집력이 있음.
     * 재고를 넣고 빼는 로직을 사용하고 있는데 사용되는 데이터는 stockQuantity 인데,
     * 이를 가지고 있는게 Item 엔티티이니, 여기에 비즈니스 메서드를 넣어주는게 관리하기가 좋다.
     *
     * stockQuantity를 변경해야될 일이 있으면 setter를 쓰는게 아니라
     * 이런 핵심 비즈니스 메서드를 사용해서 바꿔야 함.
     * 이게 가장 객체 지향적인거임.
     *
     */

    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) throw new NotEnoughStockException("need more stock");
        this.stockQuantity = restStock;
    }
}
