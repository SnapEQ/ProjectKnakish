package com.team1.projectknakish.domain.entities.dict;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "paragraphs")
public class Paragraph {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 3, unique = true)
    private String code;

    @Column(nullable = false)
    @Lob
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "expense_group_id", nullable = false)
    ExpenseGroup expenseGroup;
}
