package becapp.menus.Ficheros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *  @author Eduardo y Arturo
 *
 *	Personalizar objeto de según de escritura, asi solo creamos una cabecera 
 *  
 *  
 */

public class MiObjeto extends ObjectOutputStream{

	public MiObjeto(OutputStream out) throws IOException{
		super(out);
	}

	public MiObjeto() throws IOException, SecurityException{
		super();
	}
	
	protected void writeStreamHeader() throws IOException{}
	
}
