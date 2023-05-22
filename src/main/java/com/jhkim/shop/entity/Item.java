package com.jhkim.shop.entity;

import com.jhkim.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="item", schema = "test") // Item 클래스를 entity로 선언합니다. 또한 @Table 어노테이션을 통해 어떤 테이블과 매핑될지를 지정합니다. item 테이블과 매핑되도록 name을 item으로 지정합니다.
@Getter
@Setter
@ToString
public class Item {

    // entity로 선언한 클래스는 반드시 기본키를 가져야함. 기본키가 되는 멤버변수에 @id 어노테이션을 붙여줍니다.
    // 그리고 테이블에 매핑될 컬럼의 이름을 @Column 어노테이션을 통해 설정해줍니다. item 클래스의 id 변수와 item테이블의 item_id 컬럼이 매핑되도록합니다.
    // 마지막으로 @GeneratedValue 어노테이션을 통해 기본키 생성 전략을 AUTO로 지정
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            // 상품코드

    // @Column 어노테이션의 nullable 속성을 이용해서 항상 값이 있어야하는 필드는 not null 설정을 합니다.
    // String 필드는 default 값으로 255가 설정돼 있습니다. 각 String 필드마다 필요한 길이를 length 속성에 default 값을 세팅합니다.
    @Column(nullable = false,length = 50)
    private String itemNm;      // 상품명
    @Column(name = "price", nullable = false)
    private int price;          // 가격

    @Column(nullable = false)
    private int stockNumber;    // 재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;      // 상품 판매 상태
    private LocalDateTime regTime;          // 등록시간
    private LocalDateTime updateTime;       // 수정시간
}
