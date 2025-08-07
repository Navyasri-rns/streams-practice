package com.example.Streams.Map_FlatMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

}
