package validations;


import interfaces.Error;
import interfaces.IValidator;
import userInterface.user.UserInformation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class UserValidator implements IValidator, Error {
    UserInformation userInformation;

    public UserValidator(UserInformation userInformation) {
        this.userInformation = userInformation;
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
    private void validate2(List<String >brokenRules){
        validateName(userInformation.getName(),brokenRules);
        validateName(userInformation.getSurname(),brokenRules);
    }
    private void validate1(List<String >brokenRules){

        try{
            Integer.parseInt(userInformation.getIncome());
        }catch (Exception e){
            brokenRules.add(this.ERROR2);
        }
    }
    private List<String> Validation(List<String >brokenRules){
        validate(brokenRules);
        validate1(brokenRules);
        validate2(brokenRules);
        return brokenRules;
    }
    private void validateName(String name,List<String >brokenRules){
        if(Pattern.compile( "[0-9]" ).matcher(name).find())
            brokenRules.add(this.ERROR4);

    }
    private void validate(List<String >brokenRules){

         if (userInformation.getName().equals("") && userInformation.getSurname().equals("") && userInformation.getIncome().equals(""))
             brokenRules.add(this.ERROR1);
    }
}
