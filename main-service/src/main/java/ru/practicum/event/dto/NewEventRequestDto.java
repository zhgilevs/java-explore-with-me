package ru.practicum.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.practicum.event.entity.Location;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class NewEventRequestDto {

    @NotBlank(message = "Field: title. Error: must not be blank")
    @Size(min = 3, max = 120, message = "Field: title. Error: size must be >= 3 and <= 120 characters")
    private String title;

    @NotBlank(message = "Field: annotation. Error: must not be blank")
    @Size(min = 20, max = 2000, message = "Field: annotation. Error: size must be >= 20 and <= 2000 characters")
    private String annotation;

    @NotBlank(message = "Field: description. Error: must not be blank")
    @Size(min = 20, max = 7000, message = "Field: description. Error: size must be >= 20 and <= 7000 characters")
    private String description;

    @Positive
    private long category;

    @NotNull
    private Location location;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String eventDate;
    private Integer participantLimit;
    private Boolean paid;
    private Boolean requestModeration;
}