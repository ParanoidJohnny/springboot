package com.example.kazezahmed.Controllers;

import com.example.kazezahmed.Entities.Example;
import com.example.kazezahmed.Entities.Project;
import com.example.kazezahmed.Entities.User;
import com.example.kazezahmed.Repositories.ProjectRepository;
import com.example.kazezahmed.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("examen")
public class ExamenController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User entity) {
        return	userRepository.save(entity);
    }

    @PostMapping("/addProject")
    public Project addProject (@RequestBody Project entity) {
        return	projectRepository.save(entity);
    }

    @PutMapping("/assignProjectToUser/{idUser}/{idProject}")
    public void assignProjectToUser (@PathVariable(value="idUser") Integer idUser,@PathVariable(value="idProject") Integer idProject) {
        User user = userRepository.findById(idUser).orElse(null);
        Project project =projectRepository.findById(idProject).orElse(null);
        List<Project> projectlist = user.getProjectList();
        projectlist.add(project);
        user.setProjectList(projectlist);
        userRepository.save(user);
    }

    @PutMapping("/assignProjectToClient/{first}/{last}/{idProject}")
    public void assignProjectToClient (@PathVariable(value="first") String first,@PathVariable(value="last") String last,@PathVariable(value="idProject") Integer idProject) {
        User user = userRepository.findByFirstnameAndLastname(first,last);
        Project project =projectRepository.findById(idProject).orElse(null);
        List<Project> projectlist = user.getProjects();
        projectlist.add(project);
        user.setProjects(projectlist);
        userRepository.save(user);
    }

    @Scheduled(fixedRate = 30000)
    public List<Project> getNbrSprintByCurrentProject() {
         List<Project> list = projectRepository.findAll();
        log.info("list");
       return projectRepository.findAll();
    }


}
