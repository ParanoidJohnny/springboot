package com.example.kazezahmed.Controllers;

import com.example.kazezahmed.Entities.Example;
import com.example.kazezahmed.Repositories.ExampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("example")
public class ExampleController {

    @Autowired
    ExampleRepository exampleRepository;

    @GetMapping("/getall")
    public List<Example> getall(){
        return exampleRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public Example getone (@PathVariable(value="id") Integer id) {
        return exampleRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Example add(@RequestBody Example entity) {
        return	exampleRepository.save(entity);
    }

    //@Transactional
    // Use this annotation to commit all managed entities without using the save function << contratRepository.save >>
    @PutMapping("/update")
    public Example update(@RequestBody Example entity) {
        return	exampleRepository.save(entity);
    }


    //Scheduler example for printing every 3 seconds
   // @Scheduled(fixedRate = 3000)
    //public void PrintEvery30Seconds() {
      // System.out.print("scheduler works");
   // }

    /*
    # Scheduler example
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms() {
        List<CoursClassroom> classrooms = coursClassroomRepository.findAll();
        for (CoursClassroom coursClassroom : classrooms) {
            coursClassroom.setArchive(true);
            coursClassroomRepository.save(coursClassroom);
        }
    }

    # When dealing with java.util.Date
    public static long diffInDaysBetween(Date secondDate, Date firstDate){
        long diffInMillies = secondDate.getTime() - firstDate.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

     # Kadem examples
    public Contrat affectContratToEtudiant(Integer idContrat, String nomE, String prenomE) {

        Contrat contrat = this.retrieveById(idContrat);
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        if(contrat != null && etudiant!= null){

            int activeContract = 0;
            activeContract =  etudiant.getContrats().stream()
                    .filter(contrat1 -> contrat1.getArchive().equals(true))
                    .collect(Collectors.toList())
                    .size();

            activeContract = contratRepository.countByArchiveIsTrueAndEtudiantIdEtudiant(etudiant.getIdEtudiant());

            if(activeContract<5){
                contrat.setEtudiant(etudiant);
            }

        }

        return null;
    }

    @Override
    public Integer nbContratsValides(LocalDate startDate, LocalDate endDate) {
        log.info("IN method nbContratsValides");
        Integer var = contratRepository.countByArchiveIsFalseAndDateDebutContratAfterAndDateFinContratBefore(startDate,endDate);
        log.info("out of method nbContratsValides");
        return var;
    }
     */
}
