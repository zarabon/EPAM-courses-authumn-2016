package syntaxElements;

import logicElements.SentenseElement;

public abstract class Symbol {
     private String value;
    
    public Symbol(String value) {
        this.value = value;
    }  

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
 