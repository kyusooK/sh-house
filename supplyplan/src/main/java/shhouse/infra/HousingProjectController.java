package shhouse.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shhouse.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/housingProjects")
@Transactional
public class HousingProjectController {

    @Autowired
    HousingProjectRepository housingProjectRepository;

    @RequestMapping(
        value = "/housingProjects/{id}/processcompletion",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public HousingProject processCompletion(
        @PathVariable(value = "id") Long id,
        @RequestBody ProcessCompletionCommand processCompletionCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /housingProject/processCompletion  called #####"
        );
        Optional<HousingProject> optionalHousingProject = housingProjectRepository.findById(
            id
        );

        optionalHousingProject.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        HousingProject housingProject = optionalHousingProject.get();
        housingProject.processCompletion(processCompletionCommand);

        housingProjectRepository.save(housingProject);
        return housingProject;
    }
}
//>>> Clean Arch / Inbound Adaptor
