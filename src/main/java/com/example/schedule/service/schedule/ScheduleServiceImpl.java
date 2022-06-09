package com.example.schedule.service.schedule;



import com.example.schedule.DAO.schedule.ScheduleDAOImpl;
import com.example.schedule.DTO.schedule.req.ScheduleCreate;
import com.example.schedule.DTO.schedule.req.ScheduleUpdate;
import com.example.schedule.DTO.schedule.resp.ScheduleDTO;
import com.example.schedule.model.*;
import com.example.schedule.repository.*;
import com.example.schedule.service.audience.IAudienceService;
import com.example.schedule.service.group.IGroupService;
import com.example.schedule.service.subject.ISubjectService;
import com.example.schedule.service.teacher.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements IScheduleService{

    private final ScheduleDAOImpl dao;

    private final ScheduleRep rep;

    private final IGroupService groupService;

    private final ITeacherService teacherService;

    private final ISubjectService subjectService;

    private final IAudienceService audienceService;



    @Override
    public Schedule create(Schedule schedule) {
        return dao.create(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return dao.update(schedule);
    }

    @Override
    public ScheduleDTO createDTO(ScheduleCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Schedule.builder()
                                .id(id)
                                .numberOfWeek(entity.getNumberOfWeek())
                                .dayOfWeek(entity.getDayOfWeek())
                                .lessonNumber(entity.getLessonNumber())
                                .startOfLesson(entity.getStartOfLesson())
                                .groups(Group.builder()
                                        .id(entity.getGroupsId())
                                        .build())
                                .audiences(Audience.builder()
                                        .id(entity.getAudiencesId())
                                        .build())
                                .subjects(Subject.builder()
                                        .id(entity.getSubjectsId())
                                        .build())
                                .teachers(Teacher.builder()
                                        .id(entity.getTeachersId())
                                        .build())
                        .build())
        );
    }

    @Override
    public ScheduleDTO updateDTO(ScheduleUpdate entity) {

        Schedule schedule = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Schedule.builder()
                                .id(schedule.getId())
                                .numberOfWeek(entity.getNumberOfWeek())
                                .dayOfWeek(entity.getDayOfWeek())
                                .lessonNumber(entity.getLessonNumber())
                                .startOfLesson(entity.getStartOfLesson())
                                .groups(schedule.getGroups())
                                .teachers(schedule.getTeachers())
                                .subjects(schedule.getSubjects())
                                .audiences(schedule.getAudiences())
                                .build()
                )
        );
    }

    @Override
    public ScheduleDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<ScheduleDTO> getAll(Integer page, Integer size) {

        Page<Schedule> schedules = rep.findAll(PageRequest.of(page, size));

        var schedulesDTOs = schedules.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<ScheduleDTO>(schedulesDTOs);
    }

    private ScheduleDTO convertToDTO(Schedule entity){
        return ScheduleDTO.builder()
                .id(entity.getId())
                .numberOfWeek(entity.getNumberOfWeek())
                .dayOfWeek(entity.getDayOfWeek())
                .lessonNumber(entity.getLessonNumber())
                .startOfLesson(entity.getStartOfLesson())
                .groupsId(groupService.convertToDTOString(entity.getGroups().getId()))
                .audiencesId(audienceService.convertToDTOString(entity.getAudiences().getId()))
                .subjectsId(subjectService.convertToDTOString(entity.getSubjects().getId()))
                .teachersId(teacherService.convertToDTOString(entity.getTeachers().getId()))
                .build();
    }

/*
    public Schedule createDTO(ScheduleDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var schedule = Schedule.builder()
                .id(id)
                .numberOfWeek(request.getNumberOfWeek())
                .dayOfWeek(request.getDayOfWeek())
                .lessonNumber(request.getLessonNumber())
                .groups(groupRep.findById(request.getGroups()).get())
                .teachers(teacherRep.findById(request.getTeachers()).get())
                .subjects(subjectRep.findById(request.getSubjects()).get())
                .audiences(audienceRep.findById(request.getAudiences()).get())
                .startOfLesson(request.getStartOfLesson())
                .build();

        return rep.save(schedule);

    }

    public Schedule updateDTO(ScheduleDTOUpdate request) {

        var schedule = Schedule.builder()
                .id(rep.findById(request.getId()).get().getId())
                .numberOfWeek(request.getNumberOfWeek())
                .dayOfWeek(request.getDayOfWeek())
                .lessonNumber(request.getLessonNumber())
                .groups(groupRep.findById(request.getGroups()).get())
                .teachers(teacherRep.findById(request.getTeachers()).get())
                .subjects(subjectRep.findById(request.getSubjects()).get())
                .audiences(audienceRep.findById(request.getAudiences()).get())
                .startOfLesson(request.getStartOfLesson())
                .build();

        return rep.save(schedule);

    }*/
}
