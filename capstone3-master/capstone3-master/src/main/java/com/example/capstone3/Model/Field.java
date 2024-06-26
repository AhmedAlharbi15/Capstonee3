package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 10, max = 50, message = "name should range between 10 to 50")
//    @Pattern(regexp = "^[A-Za-z]+$")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL unique")
    private String name;
    @NotEmpty(message = "location should not be empty")
    @Column(columnDefinition = "VARCHAR(80) not null")
    private String location;
    @NotEmpty(message = "dimension should not be empty")
    @Column(columnDefinition = "VARCHAR(30) not null")
    private String dimensions;

    @ManyToOne
    @JoinColumn(name = "organizer_id", referencedColumnName = "id")
    @JsonIgnore
    private Organizer organizer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "field")
    private Set<MatchModel> matches;
}
