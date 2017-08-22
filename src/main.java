import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.udea.principal.LectorArchivos;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		LectorArchivos miArchivo = new LectorArchivos();
		List<String> codigo = miArchivo.ObtenerCodigo();
	}

}
