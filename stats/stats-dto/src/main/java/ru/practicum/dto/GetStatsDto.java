package ru.practicum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetStatsDto {

    @NotBlank
    private String start;

    @NotBlank
    private String end;

    @NotBlank
    private List<String> uris;

    @NotBlank
    private boolean unique;

    public boolean getUnique() {
        return unique;
    }
}
