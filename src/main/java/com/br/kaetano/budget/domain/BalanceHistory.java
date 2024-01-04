package com.br.kaetano.budget.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "balance_history")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceHistory {

    @Id
    @GenericGenerator(name = "UUIDGenerator", type = org.hibernate.id.uuid.UuidGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
