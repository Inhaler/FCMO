package suiteTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import components.Hook;
import steps.M_EntrarVC_IngresarStep;
import steps.M_EntrarVC_SalirGuardiaStep;
import steps.VC_Videoconsultas_RealizarVCStep;

public class Regresion_Socio extends Hook {

	// Suite de videoconsultas
	
	@Test
	public void M_AtenderVC_01(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
	}

	@Test (dependsOnMethods = {"M_AtenderVC_01"})
	public void VC_Videoconsulta_01(Method method) {
		VC_Videoconsultas_RealizarVCStep.Run(method.getName());
	}
	
	@Test (dependsOnMethods = {"VC_Videoconsulta_01"})
	public void M_AtenderVC_02(Method method) {
		M_EntrarVC_SalirGuardiaStep.Run(method.getName());
	}


}