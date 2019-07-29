package fishapp.models;

import fishapp.models.forms.TripForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "trip_table")
public class TripModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;
    private String fishery;
    private LocalDate date;
    private int timeFrom;
    private int timeTo;
    private String notice;

    public TripModel(TripForm form) {
        city = form.getCity();
        fishery = form.getFishery();
        date = form.getFormateDate();
        timeFrom = form.getTimeFrom();
        timeTo = form.getTimeTo();
        notice = form.getNotice();
    }
}
