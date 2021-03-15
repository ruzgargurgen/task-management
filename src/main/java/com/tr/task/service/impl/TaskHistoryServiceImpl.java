package com.tr.task.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tr.task.dto.TaskHistoryDto;
import com.tr.task.dto.PagedResultDto;
import com.tr.task.entity.TaskHistory;
import com.tr.task.entity.Task;
import com.tr.task.entity.User;
import com.tr.task.enums.TaskStatus;
import com.tr.task.exceptions.TaskNotFoundException;
import com.tr.task.mapper.TaskHistoryMapper;
import com.tr.task.repository.TaskHistoryRepository;
import com.tr.task.repository.TaskRepository;
import com.tr.task.repository.UserRepository;
import com.tr.task.service.TaskHistoryService;
import com.tr.task.service.BaseService;

@Service
public class TaskHistoryServiceImpl extends BaseService implements TaskHistoryService {

	@Autowired
	private TaskHistoryRepository assignedTaskRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskHistoryMapper assignedTaskMapper;

	public TaskHistoryServiceImpl() {
		super(TaskHistoryServiceImpl.class);
	}

	@Override
	public List<TaskHistoryDto> getAssignTasksByAssigneeId(Long assignId) {
		List<TaskHistory> assignedTasks = assignedTaskRepository.findByAssigneeId(assignId);
		return this.assignedTaskMapper.assignedTasksToAssignedTaskDtos(assignedTasks);
	}

	@Override
	public PagedResultDto<TaskHistoryDto> getAllAssignedTasks(Integer page, Integer size) {
		Page<TaskHistory> assignedTaskPage = this.assignedTaskRepository.findAll(PageRequest.of(page, size));
		return new PagedResultDto<>(
				this.assignedTaskMapper.assignedTasksToAssignedTaskDtos(assignedTaskPage.getContent()),
				assignedTaskPage.getNumber(), assignedTaskPage.getSize(), assignedTaskPage.getTotalElements());
	}

	@Override
	public PagedResultDto<TaskHistoryDto> getAllAssignedTasks(TaskStatus status, Integer page, Integer size) {

		Page<TaskHistory> assignedTaskPage = this.assignedTaskRepository.findByTaskStatus(status,
				PageRequest.of(page, size));

		return new PagedResultDto<>(
				this.assignedTaskMapper.assignedTasksToAssignedTaskDtos(assignedTaskPage.getContent()),
				assignedTaskPage.getNumber(), assignedTaskPage.getSize(), assignedTaskPage.getTotalElements());
	}

	@Override
	public TaskHistoryDto createAssignedTask(TaskHistoryDto assignedTaskDto) {
//		
//		 Task task=this.taskRepository.findById(assignedTaskDto.getTask().getId())
//		     .orElseThrow(()->new EntityNotFoundException(""));
//		 
//		 User assignee=this.userRepository.findById(assignedTaskDto.getAssignee().getId())
//				 .orElseThrow(()->new EntityNotFoundException(""));
//		
//		 AssignedTask assignedTask=new AssignedTask();
//		 
//		 assignedTask.setAssignee(assignee);
//		 assignedTask.setTask(task);
//		 
//		 assignedTask=this.assignedTaskRepository.save(assignedTask);

		TaskHistory assignedTask = this.assignedTaskMapper.assignedTaskDtoToAssignedTask(assignedTaskDto);

		assignedTask = this.assignedTaskRepository.save(assignedTask);

		return this.assignedTaskMapper.assignedTaskToAssignedTaskDto(assignedTask);
	}

	@Override
	public TaskHistoryDto updateAssignedTask(Long assignedTaskId, TaskHistoryDto assignedTaskDto) {

		TaskHistory currenAssignedTask = this.assignedTaskRepository.findById(assignedTaskId)
				.orElseThrow(() -> new TaskNotFoundException(String.format("No %s entity with id %s exists!",
						TaskHistory.class.getName(), assignedTaskId)));

		TaskHistory assignedTask = this.assignedTaskMapper.assignedTaskDtoToAssignedTask(assignedTaskDto);
		assignedTask.setId(assignedTaskId);

		assignedTask=this.assignedTaskRepository.save(assignedTask);
		
		return this.assignedTaskMapper.assignedTaskToAssignedTaskDto(assignedTask);
	}

	@Override
	public boolean deleteAssignedTask(Long assignedTaskId) {
		// TODO Auto-generated method stub
		return false;
	}

}
