package net.sytes.joaojunior.model;



public class Semana {
	private int dia;

	
	public int getDia() {		
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public String getDiaDaSemana() {
		String diaSemana ="";
		
		try {			
			switch (getDia()){	 
		    case 1: diaSemana = "Domingo";
		      	break;		    		
		    case 2: diaSemana = "Segunda";
		    	break;		    
		    case 3: diaSemana = "Terça";
		      break;		    
		    case 4: diaSemana = "Quarta";
		      break;		    
		    case 5: diaSemana = "Quinta";
		      break;
		    case 6: diaSemana = "Sexta";
		      break;
		    case 7: diaSemana = "Sábado";
		      break;	
		    default:
		    	diaSemana = "Dia inexistente!";
			}
		}catch (NumberFormatException e){
			System.out.println("SWITCH: Erro NO FORMATO: "+e);
		}catch (NullPointerException e){
			System.out.println("SWITCH: NullPointerException: "+e);
		}catch (Exception e) {
			System.out.println("SWITCH: Exception: "+e);
		}
		
		
		return diaSemana;
	}

	
}
