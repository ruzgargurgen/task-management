package com.tr.task.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tr.task.aspect.Loggable;
import com.tr.task.dto.PagedResultDto;
import com.tr.task.dto.TaskDto;
import com.tr.task.dto.TaskUpdateDto;
import com.tr.task.entity.Task;
import com.tr.task.enums.TaskStatus;
import com.tr.task.exceptions.BusinessException;
import com.tr.task.mapper.TaskMapper;
import com.tr.task.properties.SchedulingProperties;
import com.tr.task.repository.TaskRepository;
import com.tr.task.repository.UserRepository;
import com.tr.task.service.BaseService;
import com.tr.task.service.TaskService;

@Service
public class TaskServiceImpl extends BaseService implements TaskService {

	@Autowired
	private TaskMapper taskMapper;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchedulingProperties schedulingProperties;

	public TaskServiceImpl() {
		super(TaskServiceImpl.class);
	}

	@Override
	public List<TaskDto> getAllTasks() {
		return this.taskMapper.tasksToTaskDtos(taskRepository.findAll());
	}

	@Loggable
	@Override
	public TaskDto save(TaskDto dto) {
		Task task = this.taskMapper.taskDtoToTask(dto);
		if (task == null)
			throw new IllegalArgumentException("Task dto is null");

		task = this.taskRepository.save(task);

		return this.taskMapper.taskToTaskDto(task);
	}

	@Loggable
	@Override
	public PagedResultDto<TaskDto> getAllTasks(Integer page, Integer size) {
		Page<Task> taskPage = this.taskRepository.findAll(PageRequest.of(page, size));
		return new PagedResultDto<>(this.taskMapper.tasksToTaskDtos(taskPage.getContent()), //
				taskPage.getNumber(), //
				taskPage.getSize(), //
				taskPage.getTotalElements());
	}

	@Loggable
	@Override
	public TaskUpdateDto updateTask(Long id, TaskUpdateDto task) {

		Task taskEntity = this.taskRepository.getOne(id);

		taskEntity.setDescription(task.getDescription());
		taskEntity.setName(task.getName());
		taskEntity.setAssignee(this.userRepository.getOne(task.getAssigneeId()));
		taskEntity.setCompletedDate(task.getCompletedDate());
		taskEntity.setStatus(task.getStatus());
		this.taskRepository.save(taskEntity);

		task.setId(id);

		return task;
	}

	@Loggable
	@Override
	public PagedResultDto<TaskDto> getTasksByTaskStatus(TaskStatus status, Integer page, Integer size) {

		Page<Task> assignedTaskPage = this.taskRepository.findByStatus(status, //
				PageRequest.of(page, //
						size, //
						Sort.by(Direction.ASC, "name", "completedDate")//
				));

		return new PagedResultDto<>(this.taskMapper.tasksToTaskDtos(assignedTaskPage.getContent()), //
				assignedTaskPage.getNumber(), //
				assignedTaskPage.getSize(), //
				assignedTaskPage.getTotalElements());
	}
	
	@Loggable
	@Override
	public PagedResultDto<TaskDto> getTasksByAssigneeId(Long assigneeId, Integer page, Integer size) {
		Page<Task> assignedTaskPage = this.taskRepository.findByAssigneeId(assigneeId, //
				PageRequest.of(page, size)//
		);

		return new PagedResultDto<>(this.taskMapper.tasksToTaskDtos(assignedTaskPage.getContent()), //
				assignedTaskPage.getNumber(), //
				assignedTaskPage.getSize(), //
				assignedTaskPage.getTotalElements());
	}
	
	@Loggable
	@Override
	public TaskUpdateDto updateTaskCompletedDate(Long id, Date completedDate) {
		return null;
	}

	@Override
	public boolean deleteTaskById(Long id) {

		this.taskRepository.deleteById(id);

		return true;
	}

	@Override
	public TaskUpdateDto updateTaskStatus(Long taskId, TaskStatus taskStatus) {
		Task taskEntity = this.taskRepository.findById(taskId)//
				.orElseThrow(() -> new BusinessException("error.entity.not-found","Task",taskId));

		taskEntity.setStatus(taskStatus);

		taskEntity = this.taskRepository.saveAndFlush(taskEntity);

		return new TaskUpdateDto(taskId, taskStatus);
	}
	
	@Scheduled(fixedDelayString = "${application.scheduling.task.fixed-delay-in-milli-second}")
	public void onTaskAutoClose() {
		if (!schedulingProperties.getTask().isEnable())
			return;
		
		//Yapılacak işlem burda yazılacak.
		
	}

}
