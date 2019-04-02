package com.dw.ngms.cis.uam.controller;

import com.dw.ngms.cis.uam.dto.ExternalUserAssistantDTO;
import com.dw.ngms.cis.uam.entity.ExternalUserAssistant;
import com.dw.ngms.cis.uam.service.ExternalUserAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by swaroop on 2019/03/26.
 */
@RestController
@RequestMapping("/cisorigin.uam/api/v1")
@CrossOrigin(origins = "*")
public class ExternalUserAssistantController extends MessageController {


    @Autowired
    private ExternalUserAssistantService externalUserAssistantService;


    @RequestMapping(value = "/approveRejectAssitant", method = RequestMethod.PUT)
    public ResponseEntity<?> approveRejectAssitant(HttpServletRequest request, @RequestBody @Valid ExternalUserAssistantDTO externalUserAssistantDTO) throws IOException {
        try {
            ExternalUserAssistant externalUserAssistant = this.externalUserAssistantService.findByUserCodeName(externalUserAssistantDTO);
            if (isEmpty(externalUserAssistant)){
                return generateEmptyResponse(request, "External User Assistant not found");
            }
            if (!isEmpty(externalUserAssistant)) {
                externalUserAssistant.setIsApproved(externalUserAssistantDTO.getIsapproved());
                externalUserAssistant.setRejectionreason(externalUserAssistantDTO.getRejectionreason());
                externalUserAssistant.setIsapprejdate(new Date());
            }
             this.externalUserAssistantService.updateExternalAssistant(externalUserAssistant);
            //todo Send Email to User
            return ResponseEntity.status(HttpStatus.OK).body("External User Assistant Updated Sucessfully");
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }


    @RequestMapping(value = "/deleteAssistant", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAssistant(HttpServletRequest request, @RequestBody @Valid ExternalUserAssistantDTO externalUserAssistantDTO) throws IOException {
        try {
            ExternalUserAssistant externalUserAssistant = this.externalUserAssistantService.findByUserCodeName(externalUserAssistantDTO);
            if (isEmpty(externalUserAssistant)){
                return generateEmptyResponse(request, "External User Assistant not found");
            }
            if (!isEmpty(externalUserAssistant)) {
                this.externalUserAssistantService.deleteAssistant(externalUserAssistant);
            }
            //todo Send Email to User
            return ResponseEntity.status(HttpStatus.OK).body("Assistant Deleted Successfully");
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }



}
