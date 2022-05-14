package noteapi.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Component
public class AddRequestNoteDTO {
    @NotBlank(message = "You cannot create an empty note.")
    @Size(min = 1, max = 255, message = "Text cannot exceed 255 characters.")
    private String text;
}
