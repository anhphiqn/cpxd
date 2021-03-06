package com.ita.cpkd.service.process;

import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.ita.cpkd.bo.ChangeBusinessBo;
import com.ita.cpkd.bo.EndBusinessBo;
import com.ita.cpkd.bo.HomeBusinessBo;
import com.ita.cpkd.bo.PersonRepresentBo;
import com.ita.cpkd.model.ChangeBusiness;
import com.ita.cpkd.model.EndBusiness;
import com.ita.cpkd.model.HomeBusiness;
import com.ita.cpkd.model.PersonRepresent;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("ita_endbusiness_saveservice")
@XPortalDataService(roles = {"cpkd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "ita/endbusiness/save", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class EndBusinessNewService extends DataServiceMarker {
    @Inject
    private EndBusinessBo endBusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        EndBusiness arbmodel = action.getModel(EndBusiness.class);

        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));
        String uuid= endBusinessBo.add(arbmodel);
        arbmodel.setUuid(uuid);

        return new ObjectWebDataservice<EndBusiness>(arbmodel);
    }

}