package com.finalproject.RoutineCatalogService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    private User user;
    private FollowUp followUp;

}
