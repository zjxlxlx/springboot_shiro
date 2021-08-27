package com.tofindwork.work.entity;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    private int permissionId;

    private String name;

    private String url;
}
