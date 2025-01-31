package com.hszg.demo.data.impl;

import com.hszg.demo.data.api.TaskManager;
import com.hszg.demo.model.student.Student;
import com.hszg.demo.model.task.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class PropertyFileTaskManagerImpl implements TaskManager {

    String fileName;

    static PropertyFileTaskManagerImpl propertyFileTaskManager = null;

    private PropertyFileTaskManagerImpl(String fileName) {
        this.fileName = fileName;
    }

    static public PropertyFileTaskManagerImpl getPropertyFileTaskManagerImpl(String fileName) {
        if (propertyFileTaskManager == null)
            propertyFileTaskManager = new PropertyFileTaskManagerImpl(fileName);
        return propertyFileTaskManager;
    }


    @Override
    public List<Task> getAllTasks(String email) {

        List<Task> tasks = new ArrayList<>();
        Properties properties = new Properties();

        try {
            properties.load(Files.newInputStream(Paths.get(fileName)));
            int i = 1;
            while (properties.containsKey("Task." + i + ".name")) {
                String taskName = properties.getProperty("Task." + i + ".name");
                String taskModule = properties.getProperty("Task." + i + ".module");
                String taskDeadline = properties.getProperty("Task." + i + ".deadline");
                String taskRecipient = properties.getProperty("Task." + i + ".recipient");
                String taskDescription = properties.getProperty("Task." + i + ".description");
                String taskLocation = properties.getProperty("Task." + i + ".location");
                int taskPriority = Integer.parseInt(properties.getProperty("Task." + i + ".priority"));
                double taskGrade = Double.parseDouble(properties.getProperty("Task." + i + ".grade"));
                int taskDurationInHourse = Integer.parseInt(properties.getProperty("Task." + i + ".durationInHours"));
                String taskStatus = properties.getProperty("Task." + i + ".status");
                tasks.add(new Task(taskName, taskModule, taskDeadline,
                                    taskRecipient, taskDescription, taskLocation, null,
                                    taskPriority, taskGrade, taskDurationInHourse, taskStatus
                                    ));
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }




    @Override
    public void addTask(Task task, Student student) {
        Collection<Task> tasks = getAllTasks("whatever email");
        tasks.add(task);
        storeAllTasks(tasks, student);
    }

    @Override
    public void deleteTask(String name, Student student) {
        // TODO
    }


    public void storeAllTasks(Collection<Task> tasks, Student student) {

        Properties properties = new Properties();

        int i = 1;

        for (Task task : tasks) {


            properties.setProperty("Task." + i + ".name", task.getName());
            properties.setProperty("Task." + i + ".module", task.getModule());
            properties.setProperty("Task." + i + ".deadline", task.getDeadline());
            properties.setProperty("Task." + i + ".recipient", task.getRecipient());
            properties.setProperty("Task." + i + ".description", task.getDescription());
            properties.setProperty("Task." + i + ".location", task.getLocation());
            properties.setProperty("Task." + i + ".priority", task.getPriority() + "");
            properties.setProperty("Task." + i + ".grade", task.getGrade().toString());
            properties.setProperty("Task." + i + ".durationInHours", task.getDurationInHours() + "");
            properties.setProperty("Task." + i + ".status", task.getStatus());
            properties.setProperty("Task." + i + ".email", "tom@tom.com");

            i++;
        }

        try {
            properties.store(Files.newOutputStream(Paths.get(fileName)), "Writing all tasks to properties file");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }



    }


}
