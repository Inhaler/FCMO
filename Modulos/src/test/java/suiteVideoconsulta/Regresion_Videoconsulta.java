package suiteVideoconsulta;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import components.Hook;
import steps.D_Mobile_Envio_InvitacionStep;
import steps.M_Mobile_AtenderStep;
import steps.M_EntrarVC_IngresarStep;

public class Regresion_Videoconsulta extends Hook {

	// Suite de videoconsultas
	
	@Test
	public void M_AtenderVC_01(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
	}

	@Test (dependsOnMethods = {"M_AtenderVC_01"})
	public void VC_GenerarInvitacion_01(Method method) {
		D_Mobile_Envio_InvitacionStep.Run(method.getName());
	}

	@Test (dependsOnMethods = {"VC_GenerarInvitacion_01"})
	public void VC_AtenderSocio_01(Method method) {
		M_Mobile_AtenderStep.Run(method.getName());
	}
	
	
}