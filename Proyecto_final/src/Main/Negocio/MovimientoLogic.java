package Main.Negocio;

import Main.Datos.*;
import Main.Entidades.*;

public class MovimientoLogic {
	MovimientoData movData;
	MovistockData mosData;
	
	public MovimientoLogic() {
		movData = new MovimientoData();
		mosData = new MovistockData();
	}
	
	public boolean RegistrarVenta(Movimiento mov) {
		Movimiento movResult = movData.Insert(mov);
		if(movResult != null) {
			for(Movistock mos : mov.getDetalles()) {
				mos.setMovimiento(movResult);
				mosData.Insert(mos);
			}
			
			return true;
		}
		else {
			return false;
		}
	}

}
