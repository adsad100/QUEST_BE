package com.example.neighborhoodquest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "quest")
@Entity
@Table(name = "checkpoints")
public class Checkpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "latitude", nullable = false, precision = 10, scale = 7)
    private Double latitude;

    @Column(name = "longitude", nullable = false, precision = 10, scale = 7)
    private Double longitude;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @Column(name = "radius_m", nullable = false)
    private Integer radiusM;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
