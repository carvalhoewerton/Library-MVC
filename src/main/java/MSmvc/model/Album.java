package MSmvc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_album")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String coverUrl;
    private String genre;
    private Integer year;
    private String spotify;
    private String review;


}
