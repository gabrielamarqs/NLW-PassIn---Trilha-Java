package com.gabriela.marques.nlw.pass.in.services;

import com.gabriela.marques.nlw.pass.in.domain.attendee.Attendee;
import com.gabriela.marques.nlw.pass.in.domain.checkin.CheckIn;
import com.gabriela.marques.nlw.pass.in.dto.attendee.AttendeeDetails;
import com.gabriela.marques.nlw.pass.in.dto.attendee.AttendeesListResponseDTO;
import com.gabriela.marques.nlw.pass.in.repositories.AttendeeRepository;
import com.gabriela.marques.nlw.pass.in.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final CheckinRepository checkInRepository;

    public List<Attendee> getAllAttendeesFromEvent(String eventId) {
        List<Attendee> attendeesList = attendeeRepository.findByEventId(eventId);
        return attendeesList;
    }

    public AttendeesListResponseDTO getEventAttendee(String eventId) {
        List<Attendee> attendeesList = this.getAllAttendeesFromEvent(eventId);
        List<AttendeeDetails> attendeesDetailsList = attendeesList.stream().map(attendee -> {
            Optional<CheckIn> checkIn = this.checkInRepository.findByAttendeeId(attendee.getId());
            LocalDateTime checkedInAt = checkIn.isPresent() ? checkIn.get().getCreatedAt() : null;
            return new AttendeeDetails(attendee.getId(), attendee.getName(), attendee.getEmail(), attendee.getCreatedAt(), checkedInAt);
        }).toList();
        return new AttendeesListResponseDTO(attendeesDetailsList);
    }
}
