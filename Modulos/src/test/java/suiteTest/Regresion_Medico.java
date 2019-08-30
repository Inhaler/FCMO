package suiteTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import components.Hook;
import steps.D_BorrarInvitacionStep;
import steps.D_CambiarContraseniaStep;
import steps.D_CambiarContrasenia_CoincidenciaStep;
import steps.D_CambiarContrasenia_LongitudStep;
import steps.D_CambiarContrasenia_ObligatoriedadStep;
import steps.D_EnvioInvitacion_GenerarInvitacionDuplicadaStep;
import steps.D_EnvioInvitacion_GenerarInvitacionSeleccionarBarrioStep;
import steps.D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep;
import steps.D_EnvioInvitacion_GenerarInvitacionSinMedicoStep;
import steps.D_EnvioInvitacion_GenerarInvitacionStep;
import steps.D_EnvioInvitacion_ObligatoriedadStep;
import steps.D_EnvioInvitacion_ValidacionEmailInvalidoStep;
import steps.D_EnvioInvitacion_ValidacionFechaInvalidaStep;
import steps.D_EnvioInvitacion_ValidacionFechaStep;
import steps.D_EnvioInvitacion_ValidacionLimitesMaximoLongitudStep;
import steps.D_EnvioInvitacion_ValidacionLocalidadStep;
import steps.D_EnvioInvitacion_ValidacionMesasOperativasStep;
import steps.D_EnvioInvitacion_ValidacionNroCelularStep;
import steps.D_EnvioInvitacion_ValidacionNroSocioStep;
import steps.D_EnvioInvitacion_ValidacionProvinciasStep;
import steps.D_EnvioInvitacion_VisualizacionColapsadoStep;
import steps.D_EnvioInvitacion_VisualizacionExpandidoStep;
import steps.D_EnvioInvitacion_VisualizacionStep;
import steps.D_EnvioInvitacion_VolverStep;
import steps.D_Home_Acceso_InvitacionesStep;
import steps.D_Home_CambiarContraseniaStep;
import steps.D_Home_SalirStep;
import steps.D_Home_VisualizacionStep;
import steps.D_Login_IngresoStep;
import steps.D_Login_Validacion_Usr_Pass_IncorrectoStep;
import steps.D_Login_Validacion_Usr_Pass_VacioStep;
import steps.D_Login_VisualizacionStep;
import steps.D_ReenvioInvitacion_ReenviarStep;
import steps.D_ReenvioInvitacion_ValidacionEmailInvalidoStep;
import steps.D_ReenvioInvitacion_VisualizacionStep;
import steps.M_EntrarVC_IngresarStep;
import steps.M_EntrarVC_SalirGuardiaStep;
import steps.M_Home_Ingreso_GuardiaStep;
import steps.M_Home_PerfilStep;
import steps.M_Home_SalirStep;
import steps.M_Home_ToolBoxStep;
import steps.M_Home_VisualizacionStep;
import steps.M_Login_IngresarStep;
import steps.M_Login_Recuperar_ContraseniaStep;
import steps.M_Login_Usr_Pass_IncorrectoStep;
import steps.M_Login_Validacion_FormatoStep;
import steps.M_Login_Validacion_ObligatoriedadStep;
import steps.M_Login_VisualizacionStep;

public class Regresion_Medico extends Hook {


	//Suite Login Medico
	@Test
	public void M_Login_01(Method method) {
		M_Login_VisualizacionStep.Run(method.getName());
	}

	@Test
	public void M_Login_02(Method method) {
		M_Login_IngresarStep.Run(method.getName());
	}

	@Test
	public void M_Login_03(Method method) {
		M_Login_Validacion_ObligatoriedadStep.Run(method.getName());
	}

	@Test
	public void M_Login_04(Method method) {
		M_Login_Validacion_FormatoStep.Run(method.getName());
	}

	@Test
	public void M_Login_05(Method method) {
		M_Login_Usr_Pass_IncorrectoStep.Run(method.getName());
	}

	@Test
	public void M_Login_06(Method method) {
		M_Login_Recuperar_ContraseniaStep.Run(method.getName());
	}


	//Suite Home Medico
	@Test
	public void M_Home_01(Method method) {
		M_Home_VisualizacionStep.Run(method.getName());
	}

	@Test
	public void M_Home_02(Method method) {
		M_Home_Ingreso_GuardiaStep.Run(method.getName());
	}

	@Test
	public void M_Home_03(Method method) {
		M_Home_PerfilStep.Run(method.getName());
	}

	@Test
	public void M_Home_04(Method method) {
		M_Home_ToolBoxStep.Run(method.getName());
	}

	@Test
	public void M_Home_05(Method method) {
		M_Home_SalirStep.Run(method.getName());
	}

	

	 
}
