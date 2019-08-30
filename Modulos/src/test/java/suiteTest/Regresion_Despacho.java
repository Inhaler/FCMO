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
import steps.D_ReenvioInvitacion_CerrarStep;
import steps.D_ReenvioInvitacion_ReenviarStep;
import steps.D_ReenvioInvitacion_SalirStep;
import steps.D_ReenvioInvitacion_ValidacionCelularInvalidoStep;
import steps.D_ReenvioInvitacion_ValidacionEmailCelularVaciosStep;
import steps.D_ReenvioInvitacion_ValidacionEmailInvalidoStep;
import steps.D_ReenvioInvitacion_VisualizacionStep;
import steps.D_SeccionInvitacion_ActualizacionAutomaticaStep;
import steps.D_SeccionInvitacion_ActualizarManualmenteStep;
import steps.D_SeccionInvitacion_AnularStep;
import steps.D_SeccionInvitacion_Anular_CerrarPopUpStep;
import steps.D_SeccionInvitacion_Anular_SalirStep;
import steps.D_SeccionInvitacion_Anular_SinMotivoStep;
import steps.D_SeccionInvitacion_Anular_SinMotivo_SalirStep;
import steps.D_SeccionInvitacion_Anular_VisualizacionStep;
import steps.D_SeccionInvitacion_ConInvitacionesStep;
import steps.D_SeccionInvitacion_Exportar_ExportarGrillaStep;
import steps.D_SeccionInvitacion_Exportar_SalirStep;
import steps.D_SeccionInvitacion_Exportar_ValidacionFechasStep;
import steps.D_SeccionInvitacion_Exportar_VisualizacionStep;
import steps.D_SeccionInvitacion_Invitacion_AceptadaStep;
import steps.D_SeccionInvitacion_Invitacion_LeidaStep;
import steps.D_SeccionInvitacion_MostrarActivas_DestildarStep;
import steps.D_SeccionInvitacion_MostrarActivas_TildarStep;
import steps.D_SeccionInvitacion_SinInvitacionesStep;
import steps.M_EntrarVC_IngresarStep;
import steps.M_EntrarVC_SalirGuardiaStep;

public class Regresion_Despacho extends Hook {

	// Suite de Login Despacho

	@Test
	public void D_Login_01(Method method) {
		D_Login_VisualizacionStep.Run(method.getName());
	}

	@Test
	public void D_Login_02(Method method) {
		D_Login_IngresoStep.Run(method.getName());
	}

	@Test
	public void D_Login_03(Method method) {
		D_Login_Validacion_Usr_Pass_VacioStep.Run(method.getName());
	}

	@Test
	public void D_Login_04(Method method) {
		D_Login_Validacion_Usr_Pass_IncorrectoStep.Run(method.getName());
	}

	@Test
	public void D_Login_05(Method method) {
		D_Login_Validacion_Usr_Pass_IncorrectoStep.Run(method.getName());
	}

	// Suite de Home Despacho

	@Test
	public void D_Home_01(Method method) {
		D_Home_VisualizacionStep.Run(method.getName());

	}

	@Test
	public void D_Home_02(Method method) {
		D_Home_Acceso_InvitacionesStep.Run(method.getName());
	}

	@Test
	public void D_Home_03(Method method) {
		D_Home_SalirStep.Run(method.getName());
	}

	@Test
	public void D_Home_04(Method method) {
		D_Home_CambiarContraseniaStep.Run(method.getName());
	}

	// Suite de Modificacion de contraseña Despacho

	@Test
	public void D_Mod_Pass_01(Method method) {
		D_CambiarContraseniaStep.Run(method.getName());
	}

	@Test
	public void D_Mod_Pass_02(Method method) {
		D_CambiarContrasenia_LongitudStep.Run(method.getName());
	}

	@Test
	public void D_Mod_Pass_03(Method method) {
		D_CambiarContrasenia_CoincidenciaStep.Run(method.getName());
	}

	@Test
	public void D_Mod_Pass_04(Method method) {
		D_CambiarContrasenia_ObligatoriedadStep.Run(method.getName());
	}

	// Suite envio de invitacion despacho (Sin dependencias)

	@Test
	public void D_Envio_Invitacion_01(Method method) {
		D_EnvioInvitacion_VisualizacionStep.Run(method.getName());
	}

	@Test
	public void D_Envio_Invitacion_02(Method method) {
		D_EnvioInvitacion_ObligatoriedadStep.Run(method.getName());
	}

	// Se genera invitacion sin algún campo obligatorio

	@Test
	public void D_Envio_Invitacion_05(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Se verifican las mesas operativas

	@Test
	public void D_Envio_Invitacion_06(Method method) {
		D_EnvioInvitacion_ValidacionMesasOperativasStep.Run(method.getName());
	}

	// Campo IDServicio - Limite maximo de longitud

	@Test
	public void D_Envio_Invitacion_08(Method method) {
		D_EnvioInvitacion_ValidacionLimitesMaximoLongitudStep.Run(method.getName());
	}

	// Se genera invitacion sin algún campo obligatorio

	@Test
	public void D_Envio_Invitacion_11(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Se genera invitacion con campo NroSocio corto

	@Test
	public void D_Envio_Invitacion_12(Method method) {
		D_EnvioInvitacion_ValidacionNroSocioStep.Run(method.getName());
	}

	// Se genera invitacion sin algún campo obligatorio

	@Test
	public void D_Envio_Invitacion_14(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Se verifican las provincias

	@Test
	public void D_Envio_Invitacion_15(Method method) {
		D_EnvioInvitacion_ValidacionProvinciasStep.Run(method.getName());
	}

	// Se verifican las localidades

	@Test
	public void D_Envio_Invitacion_16(Method method) {
		D_EnvioInvitacion_ValidacionLocalidadStep.Run(method.getName());
	}

	// Se selecciona el boton volver

	@Test
	public void D_Envio_Invitacion_27(Method method) {
		D_EnvioInvitacion_VolverStep.Run(method.getName());
	}

	// Expandir formulario

	@Test
	public void D_Envio_Invitacion_28(Method method) {
		D_EnvioInvitacion_VisualizacionExpandidoStep.Run(method.getName());
	}

	// Colapsar formulario

	@Test
	public void D_Envio_Invitacion_29(Method method) {
		D_EnvioInvitacion_VisualizacionColapsadoStep.Run(method.getName());
	}

	// Se ingresa un email con logitud no valida

	@Test
	public void D_Envio_Invitacion_32(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// nroSocio - No Se ingresa

	@Test
	public void D_Envio_Invitacion_33(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Nro Socio - Se ingresa mas de 11 numeros

	@Test
	public void D_Envio_Invitacion_35(Method method) {
		D_EnvioInvitacion_ValidacionNroSocioStep.Run(method.getName());
	}

	// Nro Socio - Se ingresan letras

	@Test
	public void D_Envio_Invitacion_37(Method method) {
		D_EnvioInvitacion_ValidacionNroSocioStep.Run(method.getName());
	}

	// celular - No Se ingresa

	@Test
	public void D_Envio_Invitacion_38(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Nro Telefono - Se ingresan menos de 10 numeros

	@Test
	public void D_Envio_Invitacion_39(Method method) {
		D_EnvioInvitacion_ValidacionNroCelularStep.Run(method.getName());
	}

	// Nro Telefono - Se ingresa mas de 10 numeros

	@Test
	public void D_Envio_Invitacion_41(Method method) {
		D_EnvioInvitacion_ValidacionNroCelularStep.Run(method.getName());
	}

	// Nro Telefono - Se ingresan letras

	@Test
	public void D_Envio_Invitacion_42(Method method) {
		D_EnvioInvitacion_ValidacionNroCelularStep.Run(method.getName());
	}

	// Email - Se ingresa email no valido - Sin @

	@Test
	public void D_Envio_Invitacion_44(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// No Se ingresa email

	@Test
	public void D_Envio_Invitacion_45(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Campo Email - Formato no valido

	@Test
	public void D_Envio_Invitacion_46(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Campo Email - Formato no valido

	@Test
	public void D_Envio_Invitacion_48(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Campo Email - Formato no valido

	@Test
	public void D_Envio_Invitacion_49(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Email - Se ingresa email no valido - caracteres especiales

	@Test
	public void D_Envio_Invitacion_50(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Campo Email - Formato no valido

	@Test
	public void D_Envio_Invitacion_52(Method method) {
		D_EnvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Campo Detalle Motivo - Limite maximo de longitud

	@Test
	public void D_Envio_Invitacion_53(Method method) {
		D_EnvioInvitacion_ValidacionLimitesMaximoLongitudStep.Run(method.getName());
	}

	// No Se ingresa detalle motivo

	@Test
	public void D_Envio_Invitacion_54(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Campo Nombre - Limite maximo de longitud

	@Test
	public void D_Envio_Invitacion_56(Method method) {
		D_EnvioInvitacion_ValidacionLimitesMaximoLongitudStep.Run(method.getName());
	}

	// No Se ingresa nombre

	@Test
	public void D_Envio_Invitacion_57(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Campo Apellido - Limite maximo de longitud

	@Test
	public void D_Envio_Invitacion_60(Method method) {
		D_EnvioInvitacion_ValidacionLimitesMaximoLongitudStep.Run(method.getName());
	}

	// No Se ingresa apellido

	@Test
	public void D_Envio_Invitacion_61(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep.Run(method.getName());
	}

	// Se ingresa una fecha de Nac con dia superior a 31

	@Test
	public void D_Envio_Invitacion_65(Method method) {
		D_EnvioInvitacion_ValidacionFechaInvalidaStep.Run(method.getName());
	}

	// Se ingresa una fecha de Nac con mes superior a 12

	@Test
	public void D_Envio_Invitacion_66(Method method) {
		D_EnvioInvitacion_ValidacionFechaInvalidaStep.Run(method.getName());
	}

	// Se ingresa una fecha de Nac - año invalido

	@Test
	public void D_Envio_Invitacion_67(Method method) {
		D_EnvioInvitacion_ValidacionFechaStep.Run(method.getName());
	}

	// Se ingresa una fecha de Nac mayor a la actual

	@Test
	public void D_Envio_Invitacion_68(Method method) {
		D_EnvioInvitacion_ValidacionFechaStep.Run(method.getName());
	}

	// Se ingresa a la guardia con el medico especialidad = pediatria

	@Test
	public void M_AtenderVC_03(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y marca discapacidad

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_04(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y marca discapacidad

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_22(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y marca CI

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_23(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y marca PMI

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_24(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y marca ID

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_25(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria y todas las marcas

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_26(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico sin medico

	@Test(dependsOnMethods = { "M_AtenderVC_03" })
	public void D_Envio_Invitacion_20(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinMedicoStep.Run(method.getName());
	}

	// Se sale de la guardia con el medico especialidad = pediatria

	@Test(dependsOnMethods = { "D_Envio_Invitacion_20", "D_Envio_Invitacion_04", "D_Envio_Invitacion_22",
			"D_Envio_Invitacion_23", "D_Envio_Invitacion_24", "D_Envio_Invitacion_25", "D_Envio_Invitacion_26" })
	public void M_AtenderVC_04(Method method) {
		M_EntrarVC_SalirGuardiaStep.Run(method.getName());
	}

	// Se ingresa a la guardia con el medico especialidad = clinico
	@Test(dependsOnMethods = { "M_AtenderVC_04" })
	public void M_AtenderVC_01(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = pediatria sin medico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_21(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinMedicoStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_03(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con datos duplicados del socio del TC
	// "D_Envio_Invitacion_03"

	@Test(dependsOnMethods = { "M_AtenderVC_01", "D_Envio_Invitacion_03" })
	public void D_Envio_Invitacion_30(Method method) {
		D_EnvioInvitacion_GenerarInvitacionDuplicadaStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico y un solo digito en
	// id_servicio

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_10(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_09(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_13(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_34(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_40(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_43(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_47(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_36(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_58(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_59(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_62(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_63(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_64(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_55(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_17(Method method) {
		D_EnvioInvitacion_GenerarInvitacionStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Envio_Invitacion_18(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSeleccionarBarrioStep.Run(method.getName());
	}

	// Se sale de la guardia con el medico especialidad = clinico

	@Test(dependsOnMethods = { "D_Envio_Invitacion_21", "D_Envio_Invitacion_10", "D_Envio_Invitacion_36",
			"D_Envio_Invitacion_58", "D_Envio_Invitacion_59", "D_Envio_Invitacion_62", "D_Envio_Invitacion_63",
			"D_Envio_Invitacion_64", "D_Envio_Invitacion_09", "D_Envio_Invitacion_13", "D_Envio_Invitacion_34",
			"D_Envio_Invitacion_40", "D_Envio_Invitacion_43", "D_Envio_Invitacion_47", "D_Envio_Invitacion_30",
			"D_Envio_Invitacion_03", "D_Envio_Invitacion_55", "D_Envio_Invitacion_17", "D_Envio_Invitacion_18",
			"D_Reenvio_Invitacion_01" })
	public void M_AtenderVC_02(Method method) {
		M_EntrarVC_SalirGuardiaStep.Run(method.getName());
	}

	// Se genera invitacion sin medico logueado a la guardia - (No deben existir
	// medicos logueados a la guardia)

	@Test(dependsOnMethods = { "M_AtenderVC_02" })
	public void D_Envio_Invitacion_19(Method method) {
		D_EnvioInvitacion_GenerarInvitacionSinMedicoStep.Run(method.getName());
	}

	// Se genera invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "M_AtenderVC_01" })
	public void D_Reenvio_Invitacion_01(Method method) {
		D_ReenvioInvitacion_VisualizacionStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_02(Method method) {
		D_ReenvioInvitacion_ReenviarStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_04(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_05(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_06(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_07(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_08(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_09(Method method) {
		D_ReenvioInvitacion_ReenviarStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_10(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_12(Method method) {
		D_ReenvioInvitacion_ValidacionEmailInvalidoStep.Run(method.getName());
	}

	// step para eliminar todas las invitaciones generadas

	@Test
	public void D_Invitacion_Borrar(Method method) {
		D_BorrarInvitacionStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_14(Method method) {
		D_ReenvioInvitacion_ValidacionCelularInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_15(Method method) {
		D_ReenvioInvitacion_ValidacionCelularInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_16(Method method) {
		D_ReenvioInvitacion_ValidacionCelularInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_17(Method method) {
		D_ReenvioInvitacion_ValidacionCelularInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_18(Method method) {
		D_ReenvioInvitacion_ValidacionCelularInvalidoStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_13(Method method) {
		D_ReenvioInvitacion_ReenviarStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_21(Method method) {
		D_ReenvioInvitacion_ValidacionEmailCelularVaciosStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_22(Method method) {
		D_ReenvioInvitacion_SalirStep.Run(method.getName());
	}

	// Se reenvia invitacion con especialidad = clinico

	@Test(dependsOnMethods = { "D_Reenvio_Invitacion_01" })
	public void D_Reenvio_Invitacion_23(Method method) {
		D_ReenvioInvitacion_CerrarStep.Run(method.getName());
	}

	// Se visualiza la grilla de invitaciones - Sin invitaciones
	@Test(dependsOnMethods = { "M_AtenderVC_02", "D_Reenvio_Invitacion_02", "D_Reenvio_Invitacion_04",
			"D_Reenvio_Invitacion_05", "D_Reenvio_Invitacion_06", "D_Reenvio_Invitacion_07", "D_Reenvio_Invitacion_08",
			"D_Reenvio_Invitacion_09", "D_Reenvio_Invitacion_10", "D_Reenvio_Invitacion_12", "D_Reenvio_Invitacion_13",
			"D_Reenvio_Invitacion_14", "D_Reenvio_Invitacion_15", "D_Reenvio_Invitacion_16", "D_Reenvio_Invitacion_17",
			"D_Reenvio_Invitacion_18", "D_Reenvio_Invitacion_21", "D_Reenvio_Invitacion_22",
			"D_Reenvio_Invitacion_23"})
	public void D_Seccion_Invitacion_01(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
		D_SeccionInvitacion_SinInvitacionesStep.Run(method.getName());
	}

	// Se visualiza la grilla de invitaciones - COn invitaciones
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_02(Method method) {
		D_SeccionInvitacion_ConInvitacionesStep.Run(method.getName());
	}

	// Se verifica que se muestre un popUp al anular una invitación
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_03(Method method) {
		D_SeccionInvitacion_Anular_VisualizacionStep.Run(method.getName());
	}

	// Se anula la invitacion
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_04(Method method) {
		D_SeccionInvitacion_AnularStep.Run(method.getName());
	}

	// Se intenta anular sin completar campo motivo
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_05(Method method) {
		D_SeccionInvitacion_Anular_SinMotivoStep.Run(method.getName());
	}

	// Se sale del popUp de anular cargando un motivo
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_06(Method method) {
		D_SeccionInvitacion_Anular_SalirStep.Run(method.getName());
	}

	// Se sale del popUp de anular sin cargar motivo
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_07(Method method) {
		D_SeccionInvitacion_Anular_SinMotivo_SalirStep.Run(method.getName());
	}

	// Se cierra el popUp de anular
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_08(Method method) {
		D_SeccionInvitacion_Anular_CerrarPopUpStep.Run(method.getName());
	}

	// Se muestran invitaciones inactivas
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_09(Method method) {
		D_SeccionInvitacion_MostrarActivas_DestildarStep.Run(method.getName());
	}

	// Se muestran invitaciones activas
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_01" })
	public void D_Seccion_Invitacion_10(Method method) {
		D_SeccionInvitacion_MostrarActivas_TildarStep.Run(method.getName());
	}

	// Actualizar grilla de invitaciones manualmente
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_11(Method method) {
		D_SeccionInvitacion_ActualizarManualmenteStep.Run(method.getName());
	}

	// Visualizar el popUp de exportar grilla de invitaciones
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_12(Method method) {
		D_SeccionInvitacion_Exportar_VisualizacionStep.Run(method.getName());
	}

	// Exportar grilla de invitaciones
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_13(Method method) {
		D_SeccionInvitacion_Exportar_ExportarGrillaStep.Run(method.getName());
	}

	// Exportar grilla de invitaciones - Fecha desde mayor al día actual
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_14(Method method) {
		D_SeccionInvitacion_Exportar_ValidacionFechasStep.Run(method.getName());
	}

	// Exportar grilla de invitaciones - Fecha hasta menor a fecha desde
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_15(Method method) {
		D_SeccionInvitacion_Exportar_ValidacionFechasStep.Run(method.getName());
	}

	// Exportar grilla de invitaciones - Salir
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_16(Method method) {
		D_SeccionInvitacion_Exportar_SalirStep.Run(method.getName());
	}

	// Invitacion Leida
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_20(Method method) {
		D_SeccionInvitacion_Invitacion_LeidaStep.Run(method.getName());
	}

	// Invitacion aceptada
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10"})
	public void D_Seccion_Invitacion_21(Method method) {
		D_SeccionInvitacion_Invitacion_AceptadaStep.Run(method.getName());
	}

	// Actualizacion automatica
	@Test(dependsOnMethods = { "D_Seccion_Invitacion_10" })
	public void D_Seccion_Invitacion_22(Method method) {
		D_SeccionInvitacion_ActualizacionAutomaticaStep.Run(method.getName());
	}

}
