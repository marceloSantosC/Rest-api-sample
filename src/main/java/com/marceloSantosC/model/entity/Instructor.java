package com.marceloSantosC.model.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "TB_INSTRUCTORS")
@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Instructor implements Serializable, GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long rg;

    private Long cpf;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_INSTRUCTORS_KNOWLEDGE_AREAS",
            joinColumns = {@JoinColumn(name = "instructor")},
            inverseJoinColumns = {@JoinColumn(name = "knowledge_area")}
    )
    private List<KnowledgeArea> knowledgeAreas;

    @ManyToMany(mappedBy = "instructors", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"instructors"})
    private Set<Course> courses;

    @Override
    public void setPrimaryKey(Long id) {
        this.id = id;
    }
}
