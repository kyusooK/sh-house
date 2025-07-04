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
// @RequestMapping(value="/extendContracts")
@Transactional
public class ExtendContractController {

    @Autowired
    ExtendContractRepository extendContractRepository;

    @RequestMapping(
        value = "/extendContracts/{id}/checkcontract",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ExtendContract checkContract(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /extendContract/checkContract  called #####");
        Optional<ExtendContract> optionalExtendContract = extendContractRepository.findById(
            id
        );

        optionalExtendContract.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ExtendContract extendContract = optionalExtendContract.get();
        extendContract.checkContract();

        extendContractRepository.save(extendContract);
        return extendContract;
    }
}
//>>> Clean Arch / Inbound Adaptor
