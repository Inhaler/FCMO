package context;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MesasOperativas {

	private String mesa1;
	private String mesa2;
	private String mesa3;
	private String mesa4;
	private String mesa5;
	private String mesa6;
	
	public MesasOperativas(String mesa1,String mesa2,String mesa3,String mesa4,String mesa5,String mesa6) {
		this.mesa1 = mesa1;
		this.mesa2 = mesa2;
		this.mesa3 = mesa3;
		this.mesa4 = mesa4;
		this.mesa5 = mesa5;
		this.mesa6 = mesa6;
	}
	
	public MesasOperativas() {
		
	}

	public String getMesa1() {
		return mesa1;
	}

	@XmlElement
	public void setMesa1(String mesa) {
		this.mesa1 = mesa;
	}
	
	public String getMesa2() {
		return mesa2;
	}

	@XmlElement
	public void setMesa2(String mesa) {
		this.mesa2 = mesa;
	}
	
	public String getMesa3() {
		return mesa3;
	}

	@XmlElement
	public void setMesa3(String mesa) {
		this.mesa3 = mesa;
	}
	
	public String getMesa4() {
		return mesa4;
	}

	@XmlElement
	public void setMesa4(String mesa) {
		this.mesa4 = mesa;
	}
	
	public String getMesa5() {
		return mesa5;
	}

	@XmlElement
	public void setMesa5(String mesa) {
		this.mesa5 = mesa;
	}
	
	public String getMesa6() {
		return mesa6;
	}

	@XmlElement
	public void setMesa6(String mesa) {
		this.mesa6 = mesa;
	}

	
	
	
}
