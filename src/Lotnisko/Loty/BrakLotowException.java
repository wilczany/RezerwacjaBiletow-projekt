package loty;

import trasy.Trasa;

public class BrakLotowException extends LotyException{
    Trasa t;
    BrakLotowException(String message,Trasa t){
        super(message);
        this.t=t;
    }

}
