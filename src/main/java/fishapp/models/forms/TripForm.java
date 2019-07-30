package fishapp.models.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
public class TripForm {

    @Getter
    private Long id;
    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 20, message = "{Size.TripForm.city}")
    private String city;
    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 20, message = "{Size.TripForm.fishery}")
    private String fishery;
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "{Pattern.TripForm.date}")
    private String date;
    @Getter
    @Setter
    @NotNull
    @Range(min = 0, max = 24, message = "{Range.TripForm.timeFrom}")
    private Integer timeFrom;
    @Getter
    @Setter
    @NotNull
    @Range(min = 0, max = 24, message = "{Range.TripForm.timeTo}")
    private Integer timeTo;
    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 600, message = "{Size.TripForm.note}")
    private String note;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate() {
        return LocalDate.parse(date, formatter);
    }
}
