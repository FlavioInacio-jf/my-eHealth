package javas.constants;
import javas.exceptions.AddressErrorMessages;
public class Addresses {
    public static final String[] validStates = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
                                         "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

    static public boolean isValidState(String state) {
        for (String value : validStates) {
            if (value == state) {
                return true;
            }
        }
        throw new IllegalArgumentException(AddressErrorMessages.STATE_INVALID);
    }
}
