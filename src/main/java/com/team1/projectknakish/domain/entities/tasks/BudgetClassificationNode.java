package com.team1.projectknakish.domain.entities.tasks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "budget_classification_nodes")
public class BudgetClassificationNode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    @Lob
    private String name;

    @Column(nullable = false)
    private ClassificationLevel classificationLevel;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private BudgetClassificationNode parent;
}
