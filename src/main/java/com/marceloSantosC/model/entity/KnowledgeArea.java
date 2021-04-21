package com.marceloSantosC.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TB_KNOWLEDGE_AREAS")
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeArea implements Serializable, GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Override
    public void setPrimaryKey(Long id) {
        this.id = id;
    }
}
