package ru.netology;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class RegistrationByClientInfo {
    private final String city;
    private final String name;
    private final String phoneNumber;
    private final String firstMeetingDate;
    private final String secondMeetingDate;

}
