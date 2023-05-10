package com.spb.validException.data.dto;

import com.spb.config.annotation.Telephone;
import com.spb.group.ValidationGroup1;
import com.spb.group.ValidationGroup2;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;


    @Telephone
    String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup2.class)
    int age;

    @Size(min = 0, max = 40)
    String description;

    @Positive(groups = ValidationGroup2.class)
    int count;

    @AssertTrue
    boolean booleanCheck;
}
