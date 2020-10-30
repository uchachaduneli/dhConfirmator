package ge.dhl.activator.controllers;

import ge.dhl.activator.entities.Emails;
import ge.dhl.activator.entities.PhoneNumbers;
import ge.dhl.activator.repositories.EmailsRepository;
import ge.dhl.activator.repositories.PhoneNumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/confirm")
public class Controller {
    private final Integer ACTIVATED = 2;
    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;
    @Autowired
    private EmailsRepository emailsRepository;

    @GetMapping("/email/{id}/{code}")
    public @ResponseBody
    ResponseEntity<String> confirmEmail(@PathVariable Integer id, @PathVariable String code) {
        Emails obj = emailsRepository.findById(id).orElse(null);
        if (obj == null) {
            return new ResponseEntity<String>("<center>Wrong ID</center>", HttpStatus.UNAUTHORIZED);
        } else if (obj.getActivationCode() == null || !obj.getActivationCode().equals(code)) {
            return new ResponseEntity<String>("<center>Wrong Code</center>", HttpStatus.UNAUTHORIZED);
        } else if (obj.getConfirmed() == ACTIVATED.byteValue()) {
            return new ResponseEntity<String>("<center>Already Confirmed</center>", HttpStatus.UNAUTHORIZED);
        } else {
            obj.setConfirmed(ACTIVATED.byteValue());
            emailsRepository.save(obj);
            return new ResponseEntity<String>("<center>Email Comfirmed</center>", HttpStatus.OK);
        }
    }

    @GetMapping("/number/{id}/{code}")
    public @ResponseBody
    ResponseEntity<String> confirmSms(@PathVariable String id, @PathVariable String code) {
        PhoneNumbers obj = phoneNumbersRepository.findById(Integer.valueOf(id)).orElse(null);
        if (obj == null) {
            return new ResponseEntity<String>("<center>Wrong ID</center>", HttpStatus.UNAUTHORIZED);
        } else if (obj.getActivationCode() == null || !obj.getActivationCode().equals(code)) {
            return new ResponseEntity<String>("<center>Wrong Code</center>", HttpStatus.UNAUTHORIZED);
        } else if (obj.getConfirmed() == ACTIVATED.byteValue()) {
            return new ResponseEntity<String>("<center>Already Confirmed</center>", HttpStatus.UNAUTHORIZED);
        } else {
            obj.setConfirmed(ACTIVATED.byteValue());
            phoneNumbersRepository.save(obj);
            return new ResponseEntity<String>("<center>Phone Number Comfirmed</center>", HttpStatus.OK);
        }
    }
}
