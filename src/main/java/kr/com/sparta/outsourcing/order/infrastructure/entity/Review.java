package kr.com.sparta.outsourcing.order.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "review")
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "star", nullable = false)
    private Byte star;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
