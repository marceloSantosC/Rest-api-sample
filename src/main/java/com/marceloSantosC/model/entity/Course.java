package com.marceloSantosC.model.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Entity
@Table(name = "TB_COURSES")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable, GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "hours_duration")
    private Integer hoursDuration;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "knowledge_area", referencedColumnName = "id")
    private KnowledgeArea knowledgeArea;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_COURSES_INSTRUCTORS",
            joinColumns = @JoinColumn(name = "course"),
            inverseJoinColumns = @JoinColumn(name = "instructor")
    )
    @JsonIgnoreProperties({"courses"})
    private List<Instructor> instructors;

    @Override
    public void setPrimaryKey(Long id) {
        this.id = id;
    }
}
