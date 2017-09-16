import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.udea.principal.GenerarReporte;
import com.udea.principal.LectorArchivos;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException{

		GenerarReporte.GenerarElReporte();
		GenerarReporte.GenerarElReporteAnterior();
	}

}
