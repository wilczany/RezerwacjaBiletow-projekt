package lotnisko.loty;

import lotnisko.trasy.Trasa;

public class BrakLotowException extends LotyException{
    Trasa t;
    BrakLotowException(String message,Trasa t){
        super(message);
        this.t=t;
    }

}
