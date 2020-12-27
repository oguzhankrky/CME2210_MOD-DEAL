package interfaces;

import java.util.List;

public interface IValidator{
    boolean IsValid();
    List<String> BrokenRules();
}
