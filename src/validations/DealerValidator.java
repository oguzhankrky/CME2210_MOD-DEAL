package validations;

import interfaces.Error;
import interfaces.Frame;
import interfaces.IValidator;
import userInterface.dealer.Register;

import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class DealerValidator implements IValidator, Error {
    Register register;

    public DealerValidator(Register register) {
        this.register = register;
    }

    @Override
    public boolean IsValid() {
        return ((Collection<?>)BrokenRules()).size()==0;
    }

    @Override
    public List<String> BrokenRules() {
        List<String> brokenRules= new LinkedList<>();
        return Validation(brokenRules);
    }
    private void passwordConfirmValidation(List<String>brokenRules){
        String passwordField=register.getPassword();
        String confirmField=register.getConfirm();

        if(passwordField.equals(confirmField)) {
            if(passwordField.length()<8){
                brokenRules.add(this.ERROR1);
            }else{
                for (int i=0;i<passwordField.length();i++){
                    if(!(Character.isLetterOrDigit(passwordField.charAt(i)))){
                        brokenRules.add(this.ERROR2);
                    }
                }
            }
        }else{
            brokenRules.add(this.ERROR3);
        }
    }
    private void validateInsideName(String name,List<String> brokenRules){
        for (int index=0;index<name.length();index++){
            char temp=name.charAt(index);
            if (Character.isDigit(temp)){
                brokenRules.add(this.ERROR4);
                break;
            }
        }
    }
    private void validateName(String name,List<String> brokenRules){
        if(Pattern.compile( "[0-9]" ).matcher(name).find())
            brokenRules.add(this.ERROR5);
    }
    private List<String> Validation(List<String> brokenRules){
        validateInsideName(register.getName(),brokenRules);
        validateInsideName(register.getSurname(),brokenRules);
        validateName(register.getName(),brokenRules);
        validateName(register.getSurname(),brokenRules);
        passwordConfirmValidation(brokenRules);
        return brokenRules;
    }
}
