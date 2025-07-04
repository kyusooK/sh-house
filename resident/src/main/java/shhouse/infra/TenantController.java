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
// @RequestMapping(value="/tenants")
@Transactional
public class TenantController {

    @Autowired
    TenantRepository tenantRepository;

    @RequestMapping(
        value = "/tenants/{id}/movein",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Tenant moveIn(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /tenant/moveIn  called #####");
        Optional<Tenant> optionalTenant = tenantRepository.findById(id);

        optionalTenant.orElseThrow(() -> new Exception("No Entity Found"));
        Tenant tenant = optionalTenant.get();
        tenant.moveIn();

        tenantRepository.save(tenant);
        return tenant;
    }

    @RequestMapping(
        value = "/tenants/{id}/leave",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Tenant leave(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /tenant/leave  called #####");
        Optional<Tenant> optionalTenant = tenantRepository.findById(id);

        optionalTenant.orElseThrow(() -> new Exception("No Entity Found"));
        Tenant tenant = optionalTenant.get();
        tenant.leave();

        tenantRepository.save(tenant);
        return tenant;
    }
}
//>>> Clean Arch / Inbound Adaptor
