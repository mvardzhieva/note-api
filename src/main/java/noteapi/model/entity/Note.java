package noteapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noteapi.model.dto.AddRequestNoteDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private LocalDateTime createdAt;

    public Note(AddRequestNoteDTO addNoteDTO) {
        this.text = addNoteDTO.getText();
        this.createdAt = LocalDateTime.now();
    }

}
