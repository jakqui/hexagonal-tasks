package com.hexagonal.tasks.domain.models;

import lombok.ToString;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@ToString
@RequiredArgsConstructor
public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;
}
